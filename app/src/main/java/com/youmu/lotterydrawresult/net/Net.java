package com.youmu.lotterydrawresult.net;

import retrofit.RestAdapter;

/**
 * Created by youzh on 2015/2/9.
 */
public class Net {

    public static WoZhongLaApi getApi (String endpoint) {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(endpoint)
                .setLogLevel(RestAdapter.LogLevel.FULL)
//                .setLog(new RestAdapter.Log() {
//                    @Override
//                    public void log(String message) {
//                        Log.e("youzh", message);
//                    }
//                })
                .build();
        WoZhongLaApi woZhongLaApi = restAdapter.create(WoZhongLaApi.class);
        return woZhongLaApi;
    }

}
