package com.demoandroid.news.utils;

import com.demoandroid.news.models.NewsResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("top-headlines")
    Call<NewsResponseModel> getNewsList(@Query("country") String country,
                                        @Query("apiKey") String apiKey);
}
