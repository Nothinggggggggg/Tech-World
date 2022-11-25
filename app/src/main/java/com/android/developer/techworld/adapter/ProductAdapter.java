package com.android.developer.techworld.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.developer.techworld.AddOrderActivity;
import com.android.developer.techworld.R;
import com.android.developer.techworld.model.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder>{
    private Context context;
    private ArrayList<Product> list;
    public ProductAdapter(Context context) {
        this.context = context;
    }
    public void setData(ArrayList<Product> list){
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
        holder.product_config.setText(product.getConfig());
        holder.product_banner.setImageResource(product.getIMG_banner());

        holder.layout_product.setOnClickListener(v -> {
            Intent intent = new Intent(context, AddOrderActivity.class);

            Bundle bundle = new Bundle();
            bundle.putSerializable("BUNDLE_PRODUCT",product);
            intent.putExtras(bundle);

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ProductHolder extends RecyclerView.ViewHolder {
        private TextView product_name ,  product_price,product_config;
        private ImageView product_banner;
        private LinearLayout layout_product;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);

            product_name = itemView.findViewById(R.id.product_name);
            product_price = itemView.findViewById(R.id.product_price);
            product_banner = itemView.findViewById(R.id.product_banner);
            product_config = itemView.findViewById(R.id.product_config);
            layout_product = itemView.findViewById(R.id.layout_product);
        }
    }
}
