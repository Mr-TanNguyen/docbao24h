package com.t3h.buoi10.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.t3h.buoi10.R;
import com.t3h.buoi10.model.CaterogyNews;

import java.util.ArrayList;

public class CaterogyAdapter extends RecyclerView.Adapter<CaterogyAdapter.ViewHolder> {

    private Context context;
    private ArrayList<CaterogyNews> arrCaterogy = new ArrayList<>();

    private OnItemCaterogyClickListenr onItemCaterogyClickListenr;

    public CaterogyAdapter(Context context) {
        this.context = context;
        initData();
    }

    private void initData() {
        arrCaterogy.clear();
        arrCaterogy.add(new CaterogyNews(R.drawable.ic_home, "Trang chủ", "https://vnexpress.net/rss/tin-moi-nhat.rss"));
        arrCaterogy.add(new CaterogyNews(R.drawable.ic_thoi_su, "Thời sự", "https://vnexpress.net/rss/thoi-su.rss"));
        arrCaterogy.add(new CaterogyNews(R.drawable.ic_home, "Kinh doanh", "https://vnexpress.net/rss/kinh-doanh.rss"));
        arrCaterogy.add(new CaterogyNews(R.drawable.ic_home, "Kinh doanh", "https://vnexpress.net/rss/kinh-doanh.rss"));
        arrCaterogy.add(new CaterogyNews(R.drawable.ic_home, "Startup", "https://vnexpress.net/rss/startup.rss"));
        arrCaterogy.add(new CaterogyNews(R.drawable.ic_home, "Giải trí", "https://vnexpress.net/rss/giai-tri.rss"));
        arrCaterogy.add(new CaterogyNews(R.drawable.ic_the_thao, "Thể thao", "https://vnexpress.net/rss/the-thao.rss"));
        arrCaterogy.add(new CaterogyNews(R.drawable.ic_home, "Pháp luật", "https://vnexpress.net/rss/phap-luat.rss"));
        arrCaterogy.add(new CaterogyNews(R.drawable.ic_home, "Giáo dục", "https://vnexpress.net/rss/giao-duc.rss"));
        arrCaterogy.add(new CaterogyNews(R.drawable.ic_home, "Sức khỏe", "https://vnexpress.net/rss/suc-khoe.rss"));
        arrCaterogy.add(new CaterogyNews(R.drawable.ic_home, "Gia đình", "https://vnexpress.net/rss/gia-dinh.rss"));
        arrCaterogy.add(new CaterogyNews(R.drawable.ic_home, "Du lịch", "https://vnexpress.net/rss/du-lich.rss"));
        arrCaterogy.add(new CaterogyNews(R.drawable.ic_home, "Khoa học", "https://vnexpress.net/rss/khoa-hoc.rss"));
        arrCaterogy.add(new CaterogyNews(R.drawable.ic_home, "Số hóa", "https://vnexpress.net/rss/so-hoa.rss"));
        arrCaterogy.add(new CaterogyNews(R.drawable.ic_home, "Xe", "https://vnexpress.net/rss/oto-xe-may.rss"));
        arrCaterogy.add(new CaterogyNews(R.drawable.ic_home, "Cộng đồng", "https://vnexpress.net/rss/cong-dong.rss"));
        arrCaterogy.add(new CaterogyNews(R.drawable.ic_home, "Tâm sự", "https://vnexpress.net/rss/tam-su.rss"));
        arrCaterogy.add(new CaterogyNews(R.drawable.ic_home, "Cười", "https://vnexpress.net/rss/cuoi.rss"));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_caterogy_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        CaterogyNews item = arrCaterogy.get(position);

        holder.imvImageCate.setImageResource(item.getImageResource());
        holder.tvTitleCate.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return arrCaterogy.size();
    }

    public CaterogyNews getItem(int position) {
        return arrCaterogy.get(position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imvImageCate;
        TextView tvTitleCate;
        LinearLayout llClick;

        public ViewHolder(View itemView) {
            super(itemView);
            imvImageCate = itemView.findViewById(R.id.imv_image_caterogy);
            tvTitleCate = itemView.findViewById(R.id.tv_title_caterogy);
            llClick = itemView.findViewById(R.id.ll_click);
            llClick.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ll_click:
                    if (onItemCaterogyClickListenr != null) {
                        onItemCaterogyClickListenr.onClickItemCaterogy(getAdapterPosition());
                    }
                    break;
            }
        }
    }

    public interface OnItemCaterogyClickListenr {
        void onClickItemCaterogy(int position);
    }

    public void setOnItemCaterogyClickListenr(OnItemCaterogyClickListenr onItemCaterogyClickListenr) {
        this.onItemCaterogyClickListenr = onItemCaterogyClickListenr;
    }

}
