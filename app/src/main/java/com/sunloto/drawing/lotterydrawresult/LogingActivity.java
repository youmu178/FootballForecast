package com.sunloto.drawing.lotterydrawresult;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.balysv.materialmenu.extras.toolbar.MaterialMenuIconToolbar;
import com.dd.processbutton.iml.ActionProcessButton;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.sunloto.drawing.lotterydrawresult.bean.UserInfo;
import com.sunloto.drawing.lotterydrawresult.common.WebDefine;
import com.sunloto.drawing.lotterydrawresult.net.WoZhongLaApi;
import com.sunloto.drawing.lotterydrawresult.utils.ProgressGenerator;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by youzh on 2015/2/5.
 */
public class LogingActivity extends ActionBarActivity implements ProgressGenerator.OnCompleteListener{

    @InjectView(R.id.login_toolBar)
    Toolbar mLoginToolBar;
    @InjectView(R.id.username_et)
    MaterialEditText mUsernameEt;
    @InjectView(R.id.password_et)
    MaterialEditText mPasswordEt;
    @InjectView(R.id.btnSignIn)
    ActionProcessButton mBtnSignIn;
    private MaterialMenuIconToolbar materialMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        initViews();
    }

    private void initViews() {
        mLoginToolBar.setTitle("登录");
        setSupportActionBar(mLoginToolBar);
        mLoginToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialMenu.animatePressedState(MaterialMenuDrawable.IconState.BURGER);
                finish();
            }
        });
        materialMenu = new MaterialMenuIconToolbar(this, Color.WHITE, MaterialMenuDrawable.Stroke.THIN) {
            @Override
            public int getToolbarViewId() {
                return R.id.login_toolBar;
            }
        };
        materialMenu.setNeverDrawTouch(true);
        final ProgressGenerator progressGenerator = new ProgressGenerator(this);
        mBtnSignIn.setMode(ActionProcessButton.Mode.ENDLESS);
        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressGenerator.start(mBtnSignIn);
                mBtnSignIn.setEnabled(false);

                RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(WebDefine.URL).setLogLevel(RestAdapter.LogLevel.FULL)
                        .setLog(new RestAdapter.Log() {
                            @Override
                            public void log(String message) {
                                Log.d("youzh", message);
                            }
                        }).build();
                WoZhongLaApi woZhongLaApi = restAdapter.create(WoZhongLaApi.class);
                woZhongLaApi.login("1018710942@qq.com", "zhao2550", new Callback<UserInfo>() {
                    @Override
                    public void success(UserInfo userInfo, Response response) {
                        Log.e("youzh", userInfo.getUser().getUsername());
                        progressGenerator.stop();
                        mBtnSignIn.setEnabled(true);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        progressGenerator.stop();
                        mBtnSignIn.setEnabled(true);
                    }
                });

            }
        });

    }


    @Override
    public void onComplete() {

    }
}
