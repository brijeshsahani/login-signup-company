package com.example.getretrofit.api;

import com.example.getretrofit.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {


    @GET("Posts")
    Call<List<Post>> getPost();

}
