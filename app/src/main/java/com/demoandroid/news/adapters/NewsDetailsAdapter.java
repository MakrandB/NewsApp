package com.demoandroid.news.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amit.mvvmnews.R;
import com.demoandroid.news.models.NewsItem;
import com.demoandroid.news.ui.interfaces.IOnItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Adapter for the News
 */
public class NewsDetailsAdapter extends RecyclerView.Adapter<NewsDetailsAdapter.NewsViewHolder> {

    private ArrayList<NewsItem> mDataList;
    private IOnItemClickListener mOnItemClickListener;

    /**
     * News details adapter
     *
     * @param articles : news list
     */
    public NewsDetailsAdapter(ArrayList<NewsItem> articles,
                              IOnItemClickListener onItemClickListener) {
        this.mDataList = articles;
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public NewsDetailsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsDetailsAdapter.NewsViewHolder holder, int position) {
        holder.tvName.setText(mDataList.get(position).getTitle().toString());
        holder.tvDesCription.setText(mDataList.get(position).toString());
        Picasso.get().load(mDataList.get(position).getUrlToImage()).into(holder.ivNews);
        holder.mContainerView.setTag(mDataList.get(position));
        holder.mContainerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClicked(view);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    /**
     * View holder
     */
    class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDesCription;
        ImageView ivNews;
        View mContainerView;

        NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            mContainerView = itemView;
            tvName = itemView.findViewById(R.id.tvName);
            tvDesCription = itemView.findViewById(R.id.tvDesCription);
            ivNews = itemView.findViewById(R.id.ivNews);

        }
    }
}
