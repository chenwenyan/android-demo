package com.cwy.nenu.android_demo;


import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2017/5/9.
 */
public interface TestService {
    @POST("/test")
    Call<JSONObject> test(@Query("test")String test);
}

