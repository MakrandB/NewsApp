package com.demoandroid.news.presenters.interfaces;

/**
 * Exposes the functionality of NewsDetailsPresenter
 */
public interface INewsDetailsPresenter {

    /**
     * Gets the list of news
     */
    void getNewsList();

    /**
     * Notifies the ui components are loaded
     */
    void onUiComponentLoaded();
}
