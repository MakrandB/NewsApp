package com.demoandroid.news.dagger;

import com.demoandroid.news.presenters.interfaces.INewsDetailsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module
public class PresentationModule {

    private static PresentationModule mInstance;
    private static INewsDetailsPresenter mNewsDetailsPresenter;


    private PresentationModule() {
    }

    private static PresentationModule getInstance() {
        if (mInstance == null) {
            mInstance = new PresentationModule();
        }
        return mInstance;
    }


    public static PresentationModule getInstance(INewsDetailsPresenter newsDetailsPresenter) {
        if (mNewsDetailsPresenter == null) {
            mNewsDetailsPresenter = newsDetailsPresenter;
        }
        return getInstance();
    }

    @Provides
    public INewsDetailsPresenter providesNewsDetailsPresenter() {
        return mNewsDetailsPresenter;
    }

}
