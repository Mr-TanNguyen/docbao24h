package com.t3h.buoi10.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.t3h.buoi10.R;
import com.t3h.buoi10.activity.MainActivity;
import com.t3h.buoi10.adapter.CaterogyAdapter;
import com.t3h.buoi10.model.News;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CaterogyNewsFragment extends Fragment implements CaterogyAdapter.OnItemCaterogyClickListenr {
    private RecyclerView lvCaterogyNews;
    private CaterogyAdapter adapter;
    private MainActivity mainActivity;

    public CaterogyNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_caterogy, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof MainActivity) {
            mainActivity = (MainActivity) getActivity();
            mainActivity.setTitleToolBar(mainActivity.getResources().getString(R.string.app_name));
        }
    }

    private void initViews(View view) {
        lvCaterogyNews = view.findViewById(R.id.lv_caterogy_news);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        lvCaterogyNews.setLayoutManager(layoutManager);
        adapter = new CaterogyAdapter(getContext());
        adapter.setOnItemCaterogyClickListenr(this);
        lvCaterogyNews.setAdapter(adapter);
    }

    @Override
    public void onClickItemCaterogy(int position) {
        if (mainActivity != null) {
            mainActivity.replaceFragment(DetailCaterogyFragment.newInstance(adapter.getItem(position).getUrl()), R.id.fragment_container, true);
            mainActivity.setTitleToolBar(adapter.getItem(position).getTitle());
        }
    }
}
