package com.youmu.lotterydrawresult.net;

import com.youmu.lotterydrawresult.bean.GameDetail;
import com.youmu.lotterydrawresult.bean.HotGame;
import com.youmu.lotterydrawresult.bean.UserInfo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by youzh on 2015/2/1.
 */
public interface WoZhongLaApi {

    @GET("/inf/data/hotgames")
    void getLotteryHotList(Callback<List<HotGame>> callback);

    @GET("/inf/data/games/{game}")
    void getLottertGameList(@Path("game") String gameID, Callback<List<HotGame>> callback);

    @GET("/inf/userinfo/login")
    void login(@Query("loginname")String username, @Query("password") String password, Callback<UserInfo> callBack);

    @GET("/inf/data/game/{game}")
    void getForcastDetail(@Path("game") String gameID, Callback<GameDetail> callback);

}
