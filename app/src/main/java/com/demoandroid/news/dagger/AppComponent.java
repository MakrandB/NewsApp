package com.demoandroid.news.dagger;

import com.demoandroid.news.ui.implemetation.NewsActivity;

import dagger.Component;

/**
 * App component
 */
@Component(modules = {PresentationModule.class})
public interface AppComponent {

    void inject(NewsActivity activity);

}
