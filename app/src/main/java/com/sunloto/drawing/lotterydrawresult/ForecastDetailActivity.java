package com.sunloto.drawing.lotterydrawresult;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sunloto.drawing.lotterydrawresult.bean.GameDetail;
import com.sunloto.drawing.lotterydrawresult.common.WebDefine;
import com.sunloto.drawing.lotterydrawresult.dialog.DialogProgress;
import com.sunloto.drawing.lotterydrawresult.net.WoZhongLaApi;
import com.sunloto.drawing.lotterydrawresult.utils.LayoutCommon;
import com.sunloto.drawing.lotterydrawresult.utils.Utils;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by youzh on 2015/2/9.
 */
public class ForecastDetailActivity extends BaseActionBarActivity {

    @InjectView(R.id.tv_homeTeamName)
    TextView mTvHomeTeamName;
    @InjectView(R.id.tv_team_goal)
    TextView mTvTeamGoal;
    @InjectView(R.id.tv_awayTeamName)
    TextView mTvAwayTeamName;
    @InjectView(R.id.percent_left_tv)
    TextView mPercentLeftTv;
    @InjectView(R.id.percent_middle_tv)
    TextView mPercentMiddleTv;
    @InjectView(R.id.percent_right_tv)
    TextView mPercentRightTv;
    @InjectView(R.id.percent_layout)
    LinearLayout mPercentLayout;
    @InjectView(R.id.tv_game_date)
    TextView mTvGameDate;

    DialogProgress dialogProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast_detail);
        ButterKnife.inject(this);
        Intent intent = getIntent();
        String gameID = intent.getStringExtra("gameID");
        if (!TextUtils.isEmpty(gameID)) {
            getData(gameID);
        }
        dialogProgress = DialogProgress.newIntance();
        dialogProgress.show(getSupportFragmentManager(),"加载数据中...");
    }

    private void getData(String gameID) {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(WebDefine.URL).setLogLevel(RestAdapter.LogLevel.FULL).setLog(new RestAdapter.Log() {
            @Override
            public void log(String message) {
                Log.e("youzh", message);
            }
        }).setRequestInterceptor(new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                SharedPreferences userConfig = PreferenceManager.getDefaultSharedPreferences(mAct);
                String cookie = userConfig.getString("cookie", "");
                request.addHeader("Cookie", cookie);
            }
        }).build();
        WoZhongLaApi woZhongLaApi = restAdapter.create(WoZhongLaApi.class);
        woZhongLaApi.getForcastDetail(gameID, new Callback<GameDetail>() {
            @Override
            public void success(GameDetail gameDetail, Response response) {
                //{"message":"没有登录或登录超时","error":"401","state":false}
                if (!TextUtils.isEmpty(gameDetail.getmMessage()) && ("401".equals(gameDetail.getmError()))) {
                    showDialog("提示", gameDetail.getmMessage(), "登录", "取消", 2);
                } else if (!TextUtils.isEmpty(gameDetail.getmMessage()) && ("502".equals(gameDetail.getmError()))) {
                    showDialog("服务提示", gameDetail.getmMessage(), "", "取消", 1);
                } else {
                    if (gameDetail != null) {
                        dialogProgress.dismiss();
                        showDataToLayout(gameDetail);
//                        Log.e("youzh", gameDetail.getHomeTeamName());
//                        Log.i("youzh", gameDetail.getDate() + "--" + gameDetail.getAwayGoalsCharts().toString());
                    }
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("youzh", "错误信息：" + error.getMessage());
                Toast.makeText(mAct, "网络连接异常，请等一会再试.", Toast.LENGTH_SHORT).show();
                dialogProgress.dismiss();
            }
        });
    }

    private void showDataToLayout(GameDetail detail) {
        mTvHomeTeamName.setText(detail.getHomeTeamName());
        mTvTeamGoal.setText(detail.getHomeGoal() + ":" + detail.getAwayGoal());
        mTvAwayTeamName.setText(detail.getAwayTeamName());
        mTvGameDate.setText("比赛时间：" + Utils.getTimeStrFromMillis(detail.getDate()));
        int homeWin = detail.getHomeWin();
        int awayWin = detail.getAwayWin();
        int draw = detail.getDraw();
        LayoutCommon.showRercentLayout(mPercentLayout, mPercentLeftTv, mPercentMiddleTv, mPercentRightTv, draw, awayWin, homeWin);
    }
}
