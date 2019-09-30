package com.demoandroid.news.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.demoandroid.news.models.NewsResponseModel;
import com.demoandroid.news.utils.Repository;


public class NewsViewModel extends ViewModel {

    private MutableLiveData<NewsResponseModel> mutableLiveData;

    /**
     * Gets the {@link LiveData} instance for the News
     *
     * @return LiveData
     */
    public LiveData<NewsResponseModel> getNewsLiveData() {
        if (mutableLiveData != null) {
            return mutableLiveData;
        }
        mutableLiveData =
                Repository.getInstance().getNewsList("in", "d4acdec35ffd4982ba5e8fb945b4e3b4");
        return mutableLiveData;
    }

}
