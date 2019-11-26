package com.demoandroid.news.ui.implemetation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.amit.mvvmnews.R;
import com.demoandroid.news.models.NewsItem;
import com.squareup.picasso.Picasso;

public class NewsDetailsActivity extends AppCompatActivity {

    private TextView mTvHeading;
    private TextView mTvDetails;
    private TextView mTvNewsURL;
    private ImageView mIVContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.news_details_layout);
        initView();
        if (getIntent() != null && getIntent().getExtras() != null) {
            NewsItem newsItem = (NewsItem) getIntent().getExtras()
                    .getSerializable(NewsActivity.NEWS_MODEL);
            populateView(newsItem);
        }
    }

    /**
     * Populates view
     *
     * @param newsItem : news details
     */
    private void populateView(NewsItem newsItem) {
        if (newsItem != null) {
            mTvHeading.setText(newsItem.getTitle());
            mTvDetails.setText(newsItem.getContent());
            mTvNewsURL.setText(newsItem.getUrl());
            Picasso.get().load(newsItem.getUrlToImage())
                    .placeholder(R.drawable.black_gradient).into(mIVContent);
            mTvNewsURL.setOnClickListener(view -> {
                Intent intent =
                        new Intent(Intent.ACTION_VIEW, Uri.parse(newsItem.getUrl().trim()));
                if (intent.resolveActivity(NewsDetailsActivity.this
                        .getPackageManager()) != null) {
                    startActivity(intent);
                }
            });
        }
    }

    /**
     * Initializes the view components
     */
    private void initView() {
        mTvHeading = findViewById(R.id.tv_heading);
        mTvDetails = findViewById(R.id.tv_content);
        mTvNewsURL = findViewById(R.id.tv_url);
        mIVContent = findViewById(R.id.iv_news_icon);

    }
}
