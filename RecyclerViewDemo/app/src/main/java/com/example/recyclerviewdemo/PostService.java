package com.example.recyclerviewdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostService {

    @GET("posts/{post}/comments")
    Call<List<Post>> getPostComments(@Path("post") int postId);
}
