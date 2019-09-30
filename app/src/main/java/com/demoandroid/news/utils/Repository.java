package com.demoandroid.news.utils;


import androidx.lifecycle.MutableLiveData;

import com.demoandroid.news.models.NewsResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private static Repository newsRepository;
    private NewsApi newsApi;

    private Repository() {
        newsApi = RetrofitService.createService(NewsApi.class);
    }

    public static Repository getInstance() {
        if (newsRepository == null) {
            newsRepository = new Repository();
        }
        return newsRepository;
    }

    /**
     * Provides the list of News from given source
     *
     * @param countryCode : country code
     * @param apiKey      : API Key
     * @return androidx.lifecycle.MutableLiveData
     */
    public MutableLiveData<NewsResponseModel> getNewsList(String countryCode, String apiKey) {
        MutableLiveData<NewsResponseModel> newsData = new MutableLiveData<>();
        newsApi.getNewsList(countryCode, apiKey).enqueue(new Callback<NewsResponseModel>() {
            @Override
            public void onResponse(Call<NewsResponseModel> call,
                                   Response<NewsResponseModel> response) {
                if (response.isSuccessful()) {
                    newsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<NewsResponseModel> call, Throwable t) {
                newsData.setValue(null);
            }
        });
        return newsData;
    }
}
