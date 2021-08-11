package com.evotech.apptest;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface UserCall {

    @GET("users/{username}")
    Call<Users> getUser(@Path("username") String username);
}
