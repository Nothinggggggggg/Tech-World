package com.android.developer.designtechworld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.developer.designtechworld.R;
import com.android.developer.designtechworld.model.Order;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderHolder>{
    private Context context;
    private List<Order> list;
    public OrderAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<Order> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_order,parent,false);
        return new OrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {
        Order order = list.get(position);

        holder.product_name.setOnClickListener(v -> {
            if(holder.layout_order.getVisibility() == View.GONE){
                holder.layout_order.setVisibility(View.VISIBLE);
            }else{
                holder.layout_order.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class OrderHolder extends RecyclerView.ViewHolder {
        private TextView product_name;
        private LinearLayout layout_order;

        public OrderHolder(@NonNull View itemView) {
            super(itemView);

            product_name = itemView.findViewById(R.id.product_name);
            layout_order = itemView.findViewById(R.id.layout_order);
        }
    }
}
