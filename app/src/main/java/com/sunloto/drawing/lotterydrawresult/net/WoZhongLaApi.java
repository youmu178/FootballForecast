package com.sunloto.drawing.lotterydrawresult.net;

import com.sunloto.drawing.lotterydrawresult.bean.HotGame;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by youzh on 2015/2/1.
 */
public interface WoZhongLaApi {

    @GET("/hotgames")
    List<HotGame> getLotteryHotList();

    @GET("/games/{game}")
    String getLottertGameList(@Path("game") String gameID);
}
