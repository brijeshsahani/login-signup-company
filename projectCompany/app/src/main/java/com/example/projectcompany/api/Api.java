package com.example.projectcompany.api;

import com.example.projectcompany.models.DefaultResponse;
import com.example.projectcompany.models.UsersResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    @FormUrlEncoded
    @POST("login.php")
    Call<DefaultResponse> userlogin(
            @Header("key") String keys,
            @Field("emailid") String emailid,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("registration.php")
    Call<DefaultResponse> userregistration(
            @Header("key") String key,
            @Field("firstname") String firstname,
            @Field("lastname") String lastname,
            @Field("emailid") String emailid,
            @Field("address") String address,
           @Field("gender")String gender,
            @Field("birthdate") String birthdate,
            @Field("mobileno") int mobileno,
            @Field("password") String password,
            @Field("confirmpassword") String confirmpassword



    );
    @GET("getusers.php")
    @Headers("key: 846012712784601271278460127127")
    Call<Object> getUsers();

    @FormUrlEncoded
    @POST("delete.php/{id}")
    Call<DefaultResponse> deleteUser(
            @Header("key") String key,
          //  @Path("id") int id,
            @Field("id") int id
    );

    @FormUrlEncoded
    @POST("update.php/{id}")
    Call<DefaultResponse> updateUser(
            @Header("key") String key,
            @Field("id") int id,
            @Field("firstname") String firstname,
            @Field("lastname") String lastname,
            @Field("emailid") String emailid,
            @Field("address") String address,
            @Field("gender")String gender,
            @Field("birthdate") String birthdate,
            @Field("mobileno") int mobileno,
            @Field("password") String password,
            @Field("confirmpassword") String confirmpassword

    );

}
