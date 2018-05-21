package com.t3h.buoi10.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.t3h.buoi10.R;
import com.t3h.buoi10.model.News;

import java.util.ArrayList;

/**
 * Created by admin on 5/19/2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private ArrayList<News> arrData;
    private LayoutInflater inflater;

    private OnItemNewsClickListener onItemNewsClickListener;

    public NewsAdapter(ArrayList<News> arrData, Context context) {
        this.arrData = arrData;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_news, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News news = arrData.get(position);
        holder.bindData(news);
    }

    @Override
    public int getItemCount() {
        return arrData.size();
    }

    public News getItem(int position) {
        return arrData.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imNews;
        private TextView tvTitle;
        private TextView tvDesc;
        private TextView tvPubDate;
        private LinearLayout llClick;

        public ViewHolder(View itemView) {
            super(itemView);
            imNews = itemView.findViewById(R.id.im_news);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            tvPubDate = itemView.findViewById(R.id.tv_date);
            tvTitle = itemView.findViewById(R.id.tv_title);
            llClick = itemView.findViewById(R.id.ll_click);
            llClick.setOnClickListener(this);
        }

        public void bindData(News news) {
            Log.e(getClass().getName(), news.getImg() + "--");
            Glide.with(itemView.getContext())
                    .load(news.getImg())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(imNews);
            tvTitle.setText(news.getTitle());
            tvPubDate.setText(news.getPubDate());
            tvDesc.setText(news.getDesc());
        }

        @Override
        public void onClick(View v) {
            if (onItemNewsClickListener != null) {
                onItemNewsClickListener.onClickItemNews(getAdapterPosition());
            }
        }
    }

    public interface OnItemNewsClickListener {
        void onClickItemNews(int position);
    }

    public void setOnItemNewsClickListener(OnItemNewsClickListener onItemNewsClickListener) {
        this.onItemNewsClickListener = onItemNewsClickListener;
    }
}
