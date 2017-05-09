package com.juggleclouds.menjaradmin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.juggleclouds.menjaradmin.R;
import com.juggleclouds.menjaradmin.models.Order;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jayadeep on 5/9/17.
 */

public class SummaryAdapter extends BaseAdapter {

    List<Order.OrderItem> orderItems;
    Context context;

    public SummaryAdapter(Context c, List<Order.OrderItem> items) {
        context = c;
        orderItems = items;
    }

    @Override
    public int getCount() {
        return orderItems.size();
    }

    @Override
    public Order.OrderItem getItem(int i) {
        return orderItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ChildHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_orderitem, viewGroup, false);
            holder = new ChildHolder(view);
            view.setTag(holder);
        } else
            holder = (ChildHolder) view.getTag();
        Order.OrderItem item = getItem(i);
        holder.tvNo.setText(i + ".");
        holder.tvItem.setText(item.item.name);
        holder.tvQuantity.setText(item.quantity + "");
        return view;
    }

    public void refresh(Collection<Order.OrderItem> values) {
        orderItems.clear();
        orderItems.addAll(values);
        notifyDataSetChanged();
    }

    class ChildHolder {
        @BindView(R.id.no)
        TextView tvNo;
        @BindView(R.id.item)
        TextView tvItem;
        @BindView(R.id.quantity)
        TextView tvQuantity;

        public ChildHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
