package com.cwy.nenu.android_demo;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by lenovo on 2017/5/9.
 */
public interface TestService {
    @GET("/test")
    Call<Object> test(@Query("test") String test);
}

