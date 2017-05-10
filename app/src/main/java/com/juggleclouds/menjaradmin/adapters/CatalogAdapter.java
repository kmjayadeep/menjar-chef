package com.juggleclouds.menjaradmin.adapters;

/**
 * Created by amrith on 5/10/17.
 */
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.juggleclouds.menjaradmin.R;
import com.juggleclouds.menjaradmin.models.Item;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by amrith on 10/05/17.
 */

public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.ItemViewHolder> {

    public interface ItemClickListener {
        public void onClick(View view, int position);
    }
    private ItemClickListener clickListener;
    private List<Item> itemList;
    private Context context;

    public CatalogAdapter(Context con, List<Item> items) {
        context = con;
        itemList = items;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_catalog, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item item=itemList.get(position);
        holder.tvItem.setText(item.name);
        String price= "₹"+String.valueOf(item.price);
        holder.tvPrice.setText(price);
    }
    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.iv_item)
        ImageView ivItem;
        @BindView(R.id.tv_item)
        TextView tvItem;
        @BindView(R.id.tv_cost)
        TextView tvPrice;
        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                clickListener.onClick(view, getAdapterPosition());
            }
        }
    }

}
