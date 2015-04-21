package com.youmu.lotterydrawresult.net;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.youmu.lotterydrawresult.AppContext;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Header;
import retrofit.client.Response;

/**
 * Created by youzh on 2015/2/9.
 */
public class BackCookie<T> implements Callback<T> {
    @Override
    public void success(T t, Response response) {
        for (Header header : response.getHeaders()) {
            if (header == null) {
                continue;
            }
            String name = header.getName();

            if ("Set-Cookie".equals(name)) {
                String value = header.getValue();
                if (!TextUtils.isEmpty(value) && value.contains("JSESSIONID")) {

                    SharedPreferences userConfig = PreferenceManager.getDefaultSharedPreferences(AppContext.getInstance());
                    SharedPreferences.Editor edit = userConfig.edit();
                    edit.putString("cookie", value);
                    edit.commit();
                }
            }
        }
    }

    @Override
    public void failure(RetrofitError error) {

    }
}
