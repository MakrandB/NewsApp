package com.demoandroid.news.presenters.implemetation;

import androidx.lifecycle.LifecycleOwner;

import com.demoandroid.news.presenters.interfaces.INewsDetailsPresenter;
import com.demoandroid.news.ui.interfaces.INewsView;
import com.demoandroid.news.viewmodels.NewsViewModel;

import javax.inject.Inject;

/**
 * Presenter that handles the News details view
 */
public class NewsDetailsPresenter implements INewsDetailsPresenter {

    private INewsView mMainView;
    private NewsViewModel mNewsViewModel;

    @Inject
    public NewsDetailsPresenter(INewsView mainView, NewsViewModel newsViewModel) {
        this.mMainView = mainView;
        mNewsViewModel = newsViewModel;
    }

    @Override
    public void getNewsList() {
        mNewsViewModel.getNewsLiveData().observe((LifecycleOwner) mMainView, newsResponse -> {
            mMainView.hideNewsLoadingView();
            if (newsResponse != null) {
                mMainView.setNewsList(newsResponse.getArticles());
            }
        });
    }

    @Override
    public void onUiComponentLoaded() {
        getNewsList();
        mMainView.showNewsLoadingView();
    }
}
