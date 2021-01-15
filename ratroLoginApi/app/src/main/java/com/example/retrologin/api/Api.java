package com.example.retrologin.api;

import com.example.retrologin.models.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> userlogin(
            @Header("key") String keys,
            @Field("emailid") String emailid,
            @Field("password") String password
    );
}
