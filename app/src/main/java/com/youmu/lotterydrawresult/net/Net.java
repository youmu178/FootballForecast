package com.youmu.lotterydrawresult.net;

import android.util.Log;

import com.youmu.lotterydrawresult.common.WebDefine;

import retrofit.RestAdapter;

/**
 * Created by youzh on 2015/2/9.
 */
public class Net {

    public static WoZhongLaApi getApi () {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(WebDefine.URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new RestAdapter.Log() {
                    @Override
                    public void log(String message) {
                        Log.e("youzh", message);
                    }
                }).build();
        WoZhongLaApi woZhongLaApi = restAdapter.create(WoZhongLaApi.class);
        return woZhongLaApi;
    }

}
