package com.demoandroid.news.ui.implemetation;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amit.mvvmnews.R;
import com.demoandroid.news.adapters.NewsDetailsAdapter;
import com.demoandroid.news.dagger.DaggerAppComponent;
import com.demoandroid.news.dagger.PresentationModule;
import com.demoandroid.news.models.NewsItem;
import com.demoandroid.news.presenters.implemetation.NewsDetailsPresenter;
import com.demoandroid.news.presenters.interfaces.INewsDetailsPresenter;
import com.demoandroid.news.ui.interfaces.INewsView;
import com.demoandroid.news.ui.interfaces.IOnItemClickListener;
import com.demoandroid.news.viewmodels.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class NewsActivity extends AppCompatActivity implements INewsView, IOnItemClickListener {

    public static final String NEWS_MODEL = "news_model";
    @Inject
    INewsDetailsPresenter mPresenter;

    private ArrayList<NewsItem> mArticleArrayList = new ArrayList<>();
    private NewsDetailsAdapter mNewsAdapter;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        initDaggerComponent();
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * Initializes the dagger component
     */
    private void initDaggerComponent() {
        DaggerAppComponent.builder().presentationModule(PresentationModule
                .getInstance(new NewsDetailsPresenter(this,
                        ViewModelProviders.of(this).get(NewsViewModel.class)))).build()
                .inject(this);
    }

    /**
     * Initializes the view components
     */
    private void initView() {
        RecyclerView rvHeadline = findViewById(R.id.rvNews);
        mNewsAdapter = new NewsDetailsAdapter(mArticleArrayList, this);
        rvHeadline.setLayoutManager(new LinearLayoutManager(this));
        rvHeadline.setAdapter(mNewsAdapter);
        rvHeadline.setItemAnimator(new DefaultItemAnimator());
        rvHeadline.setNestedScrollingEnabled(true);
        mPresenter.onUiComponentLoaded();
    }

    @Override
    public void setNewsList(List<NewsItem> dataList) {
        mArticleArrayList.clear();
        mArticleArrayList.addAll(dataList);
        mNewsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showNewsLoadingView() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.setMessage("Loading News...");
        mProgressDialog.show();
    }

    @Override
    public void hideNewsLoadingView() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onItemClicked(View view) {
        if (view != null && view.getTag() != null) {
            NewsItem newsItem = (NewsItem) view.getTag();
            Bundle bundle = new Bundle();
            bundle.putSerializable(NEWS_MODEL, newsItem);
            Intent intent = new Intent(this, NewsDetailsActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
