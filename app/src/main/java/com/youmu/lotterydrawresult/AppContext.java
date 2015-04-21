package com.youmu.lotterydrawresult;

import android.app.Application;

/**
 * Created by youzh on 2015/2/9.
 */
public class AppContext extends Application {
    private static AppContext instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static AppContext getInstance() {
        return instance;
    }
}
