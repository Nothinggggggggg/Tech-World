package com.android.developer.designtechworld.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.developer.designtechworld.AddCartActivity;
import com.android.developer.designtechworld.R;
import com.android.developer.designtechworld.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder>{
    private Context context;
    private List<Product> list;
    public ProductAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<Product> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product,parent,false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        Product product = list.get(position);

        holder.product_name.setText(product.getName());
        holder.product_price.setText("$"+product.getPrice());

        holder.product_price.setOnClickListener(v -> {
            Intent intent = new Intent(context, AddCartActivity.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ProductHolder extends RecyclerView.ViewHolder {
        private TextView product_name ,  product_price;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);

            product_name = itemView.findViewById(R.id.product_name);
            product_price = itemView.findViewById(R.id.product_price);
        }
    }
}
