package com.juggleclouds.menjaradmin.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.juggleclouds.menjaradmin.R;
import com.juggleclouds.menjaradmin.models.Order;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jayadeep on 5/9/17.
 */

public class OrdersAdapter extends BaseExpandableListAdapter {

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
    public int getGroupCount() {
        return orderList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return orderList.get(i).orderItems.size();
    }

    @Override
    public Order getGroup(int i) {
        return orderList.get(i);
    }

    @Override
    public Order.OrderItem getChild(int i, int i1) {
        return orderList.get(i).orderItems.get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        GroupHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_order, viewGroup, false);
            holder = new GroupHolder(view);
            view.setTag(holder);
        } else
            holder = (GroupHolder) view.getTag();
        Order order = getGroup(i);
        holder.tvTable.setText(order.table);
        holder.tvAmount.setText("₹" + order.amount);
        holder.tvComments.setText(order.comments);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_orderitem, viewGroup, false);
            holder = new ChildHolder(view);
            view.setTag(holder);
        } else
            holder = (ChildHolder) view.getTag();
        Log.i("child", i + " " + i1);
        Order.OrderItem item = getChild(i, i1);
        holder.tvNo.setText(i1 + ".");
        holder.tvItem.setText(item.item.name);
        holder.tvQuantity.setText(item.quantity + "");
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    class GroupHolder {
        @BindView(R.id.table)
        TextView tvTable;
        @BindView(R.id.amount)
        TextView tvAmount;
        @BindView(R.id.comments)
        TextView tvComments;

        public GroupHolder(View v) {
            ButterKnife.bind(this, v);
        }
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
