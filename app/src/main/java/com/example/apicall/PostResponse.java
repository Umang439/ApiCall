package com.example.apicall;

import com.google.gson.annotations.SerializedName;

public class PostResponse {

    @SerializedName("UserId")
    private int userid;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;

    public int getUserId() { return userid; }

    public int getId() { return id; }

    public String getTitle() { return title; }

    public String getBody() { return body; }
}
