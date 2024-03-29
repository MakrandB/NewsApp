package com.demoandroid.news.ui.interfaces;

import com.demoandroid.news.models.NewsItem;

import java.util.List;

/**
 * Represents the news view
 */
public interface INewsView {

    /**
     * Sets the news list
     *
     * @param dataList : news details list
     */
    void setNewsList(List<NewsItem> dataList);

    /**
     * Displays progress bar while news are loading
     */
    void showNewsLoadingView();

    /**
     * Hides the progressbar after news loading is completed
     */
    void hideNewsLoadingView();
}
