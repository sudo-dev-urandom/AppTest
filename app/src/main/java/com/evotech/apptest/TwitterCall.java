package com.evotech.apptest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TwitterCall {

    @GET("tweets/{id}")
    Call<TwitterCall> getUser(@Header("Authorization") String auth, @Path("id") String id, @Query("tweet.fields") String tweetFields);
}
