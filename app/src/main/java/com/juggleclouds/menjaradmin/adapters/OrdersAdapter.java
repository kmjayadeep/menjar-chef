package com.juggleclouds.menjaradmin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.juggleclouds.menjaradmin.R;
import com.juggleclouds.menjaradmin.models.Order;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jayadeep on 5/9/17.
 */

public class OrdersAdapter extends BaseAdapter {

    List<Order> orderList;
    Context context;

    public OrdersAdapter(Context c, List<Order> orders) {
        context = c;
        orderList = orders;
    }

    public void refresh(List<Order> orders) {
        orderList = orders;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return orderList.size();
    }

    @Override
    public Order getItem(int i) {
        return orderList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_order, viewGroup, false);
            holder = new Holder(view);
            view.setTag(holder);
        } else
            holder = (Holder) view.getTag();
        Order order = getItem(i);
        holder.tvTable.setText(order.table);
        holder.tvAmount.setText("₹" + order.amount);
        holder.tvComments.setText(order.comments);
        return view;
    }

    class Holder {
        @BindView(R.id.table)
        TextView tvTable;
        @BindView(R.id.amount)
        TextView tvAmount;
        @BindView(R.id.comments)
        TextView tvComments;

        public Holder(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
