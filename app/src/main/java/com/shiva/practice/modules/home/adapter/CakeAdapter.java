package com.shiva.practice.modules.home.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.shiva.practice.R;
import com.shiva.practice.mvp.model.Cake;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.Holder> {
    private LayoutInflater mLayoutInflater;
    private List<Cake> mCakeList = new ArrayList<>();

    public CakeAdapter(Context mContext, LayoutInflater inflater) {
        mLayoutInflater = inflater;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.list_item, parent, false);
        return new Holder(view);
    }

    @Override
    public int getItemCount() {
        return mCakeList.size();
    }

    public void addCakes(List<Cake> cakes) {
        mCakeList.addAll(cakes);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(mCakeList.get(position));
    }

    public void clearCakes() {
        mCakeList.clear();
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.cake_icon)
        protected ImageView mCakeIcon;

        @BindView(R.id.textview_title)
        protected TextView mCakeTitle;

        @BindView(R.id.textview_preview_description)
        protected TextView mcakePreviewDescription;

        private Context mContext;

        public Holder(@NonNull View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            ButterKnife.bind(this, itemView);
        }

        public void bind(Cake cake) {
            mCakeTitle.setText(cake.getTitle());
            mcakePreviewDescription.setText(cake.getPreviewDescription());
            Glide.with(mContext).load(cake.getImageUrl())
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .into(mCakeIcon);
        }
    }
}
