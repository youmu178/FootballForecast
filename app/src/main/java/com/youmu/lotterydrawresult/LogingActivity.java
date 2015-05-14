package com.youmu.lotterydrawresult;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.balysv.materialmenu.extras.toolbar.MaterialMenuIconToolbar;
import com.dd.processbutton.iml.ActionProcessButton;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.youmu.lotterydrawresult.bean.IsLogin;
import com.youmu.lotterydrawresult.bean.User;
import com.youmu.lotterydrawresult.bean.UserInfo;
import com.youmu.lotterydrawresult.common.WebDefine;
import com.youmu.lotterydrawresult.net.BackCookie;
import com.youmu.lotterydrawresult.net.Net;
import com.youmu.lotterydrawresult.utils.ProgressGenerator;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.greenrobot.event.EventBus;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by youzh on 2015/2/5.
 */
public class LogingActivity extends BaseActionBarActivity implements ProgressGenerator.OnCompleteListener {

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
                EventBus.getDefault().post(new IsLogin(false));
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
                String username = mUsernameEt.getText().toString();
                String password = mPasswordEt.getText().toString();
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(LogingActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LogingActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressGenerator.start(mBtnSignIn);
                mBtnSignIn.setEnabled(false);

                Net.getApi(WebDefine.URL).login(username, password, new BackCookie<UserInfo>() {
                    @Override
                    public void success(UserInfo userInfo, Response response) {
                        super.success(userInfo, response);

                        progressGenerator.stop();
                        mBtnSignIn.setEnabled(true);
                        if (userInfo.isState()) {
                            User user = userInfo.getUser();
                            EventBus.getDefault().post(user);
                            EventBus.getDefault().post(new IsLogin(true));
                            finish();
                        } else {
                            Toast.makeText(LogingActivity.this, userInfo.getmMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void failure(RetrofitError error) {
                        super.failure(error);
                        Toast.makeText(LogingActivity.this, "网络连接异常，请等一会喔.", Toast.LENGTH_SHORT).show();
                        progressGenerator.stop();
                        mBtnSignIn.setEnabled(true);
                    }
                });

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        EventBus.getDefault().post(new IsLogin(false));
    }

    @Override
    public void onComplete() {

    }
}
