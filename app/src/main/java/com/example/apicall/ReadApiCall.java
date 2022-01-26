package com.example.apicall;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ReadApiCall {
    @GET("/posts")
    default Call<ArrayList<PostResponse>> getPosts() {

        return (Call<ArrayList<PostResponse>>) new PostResponse();
    }
}
