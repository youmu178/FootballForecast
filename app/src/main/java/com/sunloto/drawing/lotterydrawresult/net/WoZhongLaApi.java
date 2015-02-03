package com.sunloto.drawing.lotterydrawresult.net;

import com.sunloto.drawing.lotterydrawresult.bean.HotGame;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by youzh on 2015/2/1.
 */
public interface WoZhongLaApi {

    @GET("/hotgames")
    void getLotteryHotList(Callback<List<HotGame>> callback);

    @GET("/games/{game}")
    void getLottertGameList(@Path("game") String gameID, Callback<List<HotGame>> callback);
}
