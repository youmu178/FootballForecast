package com.youmu.lotterydrawresult;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.youmu.lotterydrawresult.bean.IsLogin;
import com.umeng.analytics.MobclickAgent;

import de.greenrobot.event.EventBus;
import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by youzh on 2015/2/6.
 */
public class BaseActionBarActivity extends ActionBarActivity {
    protected BaseActionBarActivity mAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAct = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected void showDialog(String title, String message, String positive, String negative, final int id) {
        final MaterialDialog materialDialog = new MaterialDialog(this);
        materialDialog.setTitle(title);
        materialDialog.setMessage(message);
        materialDialog.setPositiveButton(positive, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id == R.id.action_website) {
                    String web = getResources().getString(R.string.string_web);
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + web)));
                } else if (id == 2){
                    startActivity(new Intent(mAct, LogingActivity.class));
                } else if (id == 1) {
                    EventBus.getDefault().post(new IsLogin(false));
                }
                 materialDialog.dismiss();
            }
        });
        materialDialog.setNegativeButton(negative, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id == 1) {
                    EventBus.getDefault().post(new IsLogin(false));
                } else if (id == 2) {
                    EventBus.getDefault().post(new IsLogin(false));
                }
                materialDialog.dismiss();
            }
        });
        materialDialog.show();
    }
    //    @Override
//    protected void onStart() {
//        super.onStart();
//        EventBus.getDefault().register(this);
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        EventBus.getDefault().unregister(this);
//    }
//
//    public void onEventMainThread(User user) {
//
//    }
}
