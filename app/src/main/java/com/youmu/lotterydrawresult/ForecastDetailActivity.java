package com.youmu.lotterydrawresult;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.youmu.lotterydrawresult.bean.AwayTeam;
import com.youmu.lotterydrawresult.bean.CurrentForm;
import com.youmu.lotterydrawresult.bean.GameDetail;
import com.youmu.lotterydrawresult.bean.HomeTeam;
import com.youmu.lotterydrawresult.bean.IsLogin;
import com.youmu.lotterydrawresult.bean.ScoreGoalsChart;
import com.youmu.lotterydrawresult.bean.SpreadPrediction;
import com.youmu.lotterydrawresult.common.WebDefine;
import com.youmu.lotterydrawresult.dialog.DialogProgress;
import com.youmu.lotterydrawresult.net.WoZhongLaApi;
import com.youmu.lotterydrawresult.utils.LayoutCommon;
import com.youmu.lotterydrawresult.utils.Utils;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.greenrobot.event.EventBus;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by youzh on 2015/2/9.
 */
public class ForecastDetailActivity extends BaseActionBarActivity {
    @InjectView(R.id.layout_detail)
    ScrollView mLayoutDetail;
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
    @InjectView(R.id.score_goals_chart_layout)
    LinearLayout mLayoutScroreGoals;
    @InjectView(R.id.home_name)
    TextView mHomeName;
    @InjectView(R.id.away_name)
    TextView mAwayName;
    @InjectView(R.id.home_handicap)
    TextView mHomeHandicap;
    @InjectView(R.id.away_handicap)
    TextView mAwayHandicap;
    @InjectView(R.id.home_probability)
    TextView mHomeProbability;
    @InjectView(R.id.away_probability)
    TextView mAwayProbability;
    @InjectView(R.id.home_current_form_tv)
    TextView mHomeCurrentFormTv;
    @InjectView(R.id.home_current_form_layout)
    LinearLayout mHomeCurrentFormLayout;
    @InjectView(R.id.away_current_form_tv)
    TextView mAwayCurrentFormTv;
    @InjectView(R.id.away_current_form_layout)
    LinearLayout mAwayCurrentFormLayout;
    @InjectView(R.id.home_stat_comments)
    TextView mHomeStatComments;
    @InjectView(R.id.away_stat_comments)
    TextView mAwayStatComments;

    DialogProgress dialogProgress;
    String gameID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast_detail);
        ButterKnife.inject(this);
        EventBus.getDefault().register(this);
        Intent intent = getIntent();

        gameID = intent.getStringExtra("gameID");
        if (!TextUtils.isEmpty(gameID)) {
            getData(gameID);
        }
        mLayoutDetail.setVisibility(View.GONE);
        dialogProgress = DialogProgress.newIntance();
        dialogProgress.show(getSupportFragmentManager(), "加载数据中...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(IsLogin isLogin) {
        if (isLogin.isLogin()) {
            getData(gameID);
        } else {
            finish();
        }
    }

    private void getData(String gameID) {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(WebDefine.URL)
//                .setLogLevel(RestAdapter.LogLevel.FULL).setLog(new RestAdapter.Log() {
//            @Override
//            public void log(String message) {
//                Log.e("youzh", message);
//            }
//        })
                .setRequestInterceptor(new RequestInterceptor() {
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
                    showDialog("服务提示", gameDetail.getmMessage(), "取消", "", 1);
                } else {
                    if (gameDetail != null) {
                        mLayoutDetail.setVisibility(View.VISIBLE);
                        showDataToLayout(gameDetail);
//                        Log.e("youzh", gameDetail.getHomeTeamName());
//                        Log.i("youzh", gameDetail.getDate() + "--" + gameDetail.getAwayGoalsCharts().toString());
                    }
                }
                dialogProgress.dismiss();
            }

            @Override
            public void failure(RetrofitError error) {
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

        List<ScoreGoalsChart> scoreGoalsChartsList = detail.getScoreGoalsCharts();
        for (ScoreGoalsChart scoreGoalsCharts : scoreGoalsChartsList) {
            View scoreGoalsChartsLayout = LayoutInflater.from(mAct).inflate(R.layout.layout_score_goals_charts, null);
            ScoreGoalsChartView scoreGoalsChartView = new ScoreGoalsChartView(scoreGoalsChartsLayout);
            mLayoutScroreGoals.addView(scoreGoalsChartsLayout);
            String goal = scoreGoalsCharts.getGoal();
            if ("other".equals(goal)) {
                scoreGoalsChartView.mTVGoal.setText(goal);
            } else {
                int length = goal.length();
                if (length % 2 == 0) {
                    scoreGoalsChartView.mTVGoal.setText(goal.substring(0, 1) + "-" + goal.substring(1, 2));
                }
            }
            scoreGoalsChartView.mTVPctg.setText(scoreGoalsCharts.getPctg() + "%");
        }

        mHomeName.setText(detail.getHomeTeamName());
        mAwayName.setText(detail.getAwayTeamName());
        List<SpreadPrediction> spreadPredictionsList = detail.getSpreadPredictions();
        if (spreadPredictionsList.size() > 1) {
            SpreadPrediction spreadPrediction1 = spreadPredictionsList.get(0);
            SpreadPrediction spreadPrediction2 = spreadPredictionsList.get(1);
            mHomeHandicap.setText(spreadPrediction1.getHandicap());
            mAwayHandicap.setText(spreadPrediction2.getHandicap());
            mHomeProbability.setText(spreadPrediction1.getProbability()+"");
            mAwayProbability.setText(spreadPrediction2.getProbability()+"");
        }

        CurrentForm currentForm = detail.getCurrentForm();
        List<HomeTeam> homeTeams = currentForm.getHomeTeams();
        List<AwayTeam> awayTeams = currentForm.getAwayTeams();
        mHomeCurrentFormTv.setText(detail.getHomeTeamName() + "过去的" + homeTeams.size() + "场比赛");
        mAwayCurrentFormTv.setText(detail.getAwayTeamName() + "过去的" + awayTeams.size() + "场比赛");
        for (HomeTeam homeTeam : homeTeams) {
            View homeTeamsLayout = LayoutInflater.from(mAct).inflate(R.layout.layout_current_form, null);
            CurrentFormView homeCurrentForm = new CurrentFormView(homeTeamsLayout);
            mHomeCurrentFormLayout.addView(homeTeamsLayout);
            homeCurrentForm.mHomeTeamName.setText(homeTeam.getHomeTeamName());
            homeCurrentForm.mAwayTeamName.setText(homeTeam.getAwayTeamName());
            homeCurrentForm.mHomeAwayGoals.setText(homeTeam.getHomeGoal() + " - " + homeTeam.getQuestGoal());
            homeCurrentForm.mDateLocation.setText(Utils.getTimeStrFromMillis(homeTeam.getDate()) + " " + homeTeam.getLocation());
        }

        for (AwayTeam awayTeam : awayTeams) {
            View awayTeamsLayout = LayoutInflater.from(mAct).inflate(R.layout.layout_current_form, null);
            CurrentFormView awayCurrentForm = new CurrentFormView(awayTeamsLayout);
            mAwayCurrentFormLayout.addView(awayTeamsLayout);
            awayCurrentForm.mHomeTeamName.setText(awayTeam.getHomeTeamName());
            awayCurrentForm.mAwayTeamName.setText(awayTeam.getAwayTeamName());
            awayCurrentForm.mHomeAwayGoals.setText(awayTeam.getHomeGoal() + " - " + awayTeam.getQuestGoal());
            awayCurrentForm.mDateLocation.setText(Utils.getTimeStrFromMillis(awayTeam.getDate()) + " " + awayTeam.getLocation());
        }
        List<String> homeStatComments = detail.getHomeStatComments();
        StringBuilder builder = new StringBuilder();
        int index = 0;
        for (String string : homeStatComments) {
            if (index > 0) {
                builder.append("\n");
            }
            builder.append(string);
            index ++;
        }
        mHomeStatComments.setText(builder.toString());
        List<String> awayStatComments = detail.getAwayStatComments();
        StringBuilder builder1 = new StringBuilder();
        int index1 = 0;
        for (String string : awayStatComments) {
            if (index1 > 0) {
                builder1.append("\n");
            }
            builder1.append(string);
            index1 ++;
        }
        mAwayStatComments.setText(builder1.toString());
    }

    public class ScoreGoalsChartView {
        @InjectView(R.id.scoreGoalsCharts_Goal)
        TextView mTVGoal;
        @InjectView(R.id.scoreGoalsCharts_Pctg)
        TextView mTVPctg;

        public ScoreGoalsChartView(View layout) {
            ButterKnife.inject(this, layout);
        }
    }

    public class CurrentFormView {
        @InjectView(R.id.home_team_name)
        TextView mHomeTeamName;
        @InjectView(R.id.home_away_goals)
        TextView mHomeAwayGoals;
        @InjectView(R.id.away_team_name)
        TextView mAwayTeamName;
        @InjectView(R.id.date_location)
        TextView mDateLocation;

        public CurrentFormView(View layout) {
            ButterKnife.inject(this, layout);
        }
    }
}
