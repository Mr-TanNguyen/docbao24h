package com.t3h.buoi10.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.t3h.buoi10.R;
import com.t3h.buoi10.adapter.NewsAdapter;
import com.t3h.buoi10.model.News;
import com.t3h.buoi10.parser.XMLAsync;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailCaterogyFragment extends Fragment {

    private static final String KEY_CATEROGY_URL = "key_caterogy_url";
    private NewsAdapter adapter;
    private ArrayList<News> arrNews = new ArrayList<>();

    private RecyclerView rcNews;

    public static DetailCaterogyFragment newInstance(String url) {
        Bundle args = new Bundle();
        args.putString(KEY_CATEROGY_URL, url);
        DetailCaterogyFragment fragment = new DetailCaterogyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public DetailCaterogyFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_caterogy, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        parseData();
    }

    private void initViews(View view) {
        adapter = new NewsAdapter(arrNews, getContext());

        rcNews = view.findViewById(R.id.rc_news);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcNews.setLayoutManager(layoutManager);
        rcNews.setAdapter(adapter);
    }


    private void parseData() {
        String url = getArguments().getString(KEY_CATEROGY_URL, "");
        XMLAsync xmlAsync = new XMLAsync(handler);
        xmlAsync.execute(url);
    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == XMLAsync.WHAT_DATA) {
                ArrayList<News> arr = (ArrayList<News>) msg.obj;
                arrNews.addAll(arr);
                adapter.notifyDataSetChanged();

            }
        }
    };
}
