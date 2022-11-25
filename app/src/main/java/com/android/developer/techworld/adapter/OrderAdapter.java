package com.android.developer.techworld.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.developer.techworld.DAO.AccountDAO;
import com.android.developer.techworld.DAO.OrderDAO;
import com.android.developer.techworld.R;
import com.android.developer.techworld.model.Order;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderHolder>{
    private Context context;
    private ArrayList<Order> list;
    private OrderDAO orderDAO;
    private AccountDAO accountDAO;
    public OrderAdapter(Context context) {
        this.context = context;
        orderDAO = new OrderDAO(context);
        accountDAO = new AccountDAO(context);
    }
    public void setData(ArrayList<Order> list){
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

        //Product
        holder.product_banner.setImageResource(order.getProduct_banner());
        holder.product_name.setText(order.getProduct_name());
        holder.product_price.setText("$ "+order.getProduct_price());

        //Account
        holder.account_name.setText(order.getAccount_name());
        holder.account_phone.setText(order.getAccount_phone());
        holder.account_address.setText(order.getAccount_address());

        //Order
        //quantity
        count = order.getQuantity();
        holder.btn_down.setOnClickListener(v -> {
            countDown(holder,order);

        });
        holder.btn_up.setOnClickListener(v -> countUp(holder,order));
        holder.order_quantity.setText(String.valueOf(order.getQuantity()));
        holder.order_total.setText("$ "+order.getTotal());
        //status
        holder.layout_order.setOnClickListener(v -> {
            if(holder.layout_delivery_detail.getVisibility() == View.GONE){
                holder.layout_delivery_detail.setVisibility(View.VISIBLE);
            }else{
                holder.layout_delivery_detail.setVisibility(View.GONE);
            }
        });
        switch (order.getStatus()){
            case -1:
                holder.layout_delivery.setVisibility(View.GONE);
                break;
            case 1:
                uiAfterOrder(holder);
                holder.order_status.setText("Chờ xử lý");
                break;
            case 10:
                uiAfterOrder(holder);
                holder.order_status.setText("Đang giao hàng");
                break;
            case 0:
                uiAfterOrder(holder);
                holder.order_status.setText("Giao hàng thất bại");
                break;
            case 100:
                uiAfterOrder(holder);
                holder.order_status.setText("Giao hàng thành công");
                break;
        }
        //
        holder.btn_customer_order.setOnClickListener(v -> {
            dialogOrder(holder,order);
        });

    }

    private void uiAfterOrder(OrderHolder holder){
        holder.layout_delivery.setVisibility(View.VISIBLE);
        holder.btn_customer_order.setVisibility(View.GONE);

        holder.btn_down.setClickable(false);
        holder.btn_up.setClickable(false);
    }

    private void dialogOrder(OrderHolder holder, Order order) {
        //View
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_order,null);
        TextInputEditText account_name = view.findViewById(R.id.account_name);
        TextInputEditText account_phone = view.findViewById(R.id.account_phone);
        TextInputEditText account_address = view.findViewById(R.id.account_address);
        //
        account_name.setText(order.getAccount_name());
        account_phone.setText(order.getAccount_phone());
        account_address.setText(order.getAccount_address());


        //Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setNegativeButton("Hủy",null)
                .setPositiveButton("OK",null)
                .setView(view);


        //Alert Dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


        //Button
        Button btn = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        btn.setOnClickListener(v -> {
            String name = account_name.getText().toString().trim();
            String phone = account_phone.getText().toString().trim();
            String address = account_address.getText().toString().trim();

            boolean check = orderDAO.updateDatabase(order.getId());
            boolean updateAccount = accountDAO.updateDatabase(order.getAccount_id(),name,phone,address);

            if(check && updateAccount){
                Toast.makeText(context, "Đặt hàng thành công", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Đặt hàng thất bại!", Toast.LENGTH_SHORT).show();
            }

            setData(orderDAO.getDatabase());

            alertDialog.dismiss();
        });


        //Style
    }



    int count;
    private void countUp(OrderHolder holder, Order order) {
        count++;

        holder.order_quantity.setText(String.valueOf(count));
        holder.order_total.setText(String.valueOf(count*order.getProduct_price()));

        order.setQuantity(count);
    }

    private void countDown(OrderHolder holder, Order order) {
        if(count <= 1){
            return;
        }

        count--;

        holder.order_quantity.setText(String.valueOf(count));
        holder.order_total.setText(String.valueOf(count*order.getProduct_price()));

        order.setQuantity(count);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class OrderHolder extends RecyclerView.ViewHolder {
        private ImageView product_banner;
        private TextView product_name, product_price;
        private TextView order_quantity, order_total;
        private ImageButton btn_down,btn_up;
        private Button btn_customer_order;
        private TextView order_status,account_name,account_phone,account_address;
        private LinearLayout layout_delivery,layout_delivery_detail,layout_order;

        public OrderHolder(@NonNull View itemView) {
            super(itemView);

            product_banner = itemView.findViewById(R.id.product_banner);
            product_name = itemView.findViewById(R.id.product_name);
            product_price = itemView.findViewById(R.id.product_price);
            order_quantity = itemView.findViewById(R.id.order_quantity);
            order_total = itemView.findViewById(R.id.order_total);
            btn_down = itemView.findViewById(R.id.btn_down);
            btn_up = itemView.findViewById(R.id.btn_up);
            btn_customer_order = itemView.findViewById(R.id.btn_customer_order);
            order_status = itemView.findViewById(R.id.order_status);
            account_name = itemView.findViewById(R.id.account_name);
            account_phone = itemView.findViewById(R.id.account_phone);
            account_address = itemView.findViewById(R.id.account_address);
            layout_delivery = itemView.findViewById(R.id.layout_delivery);
            layout_delivery_detail = itemView.findViewById(R.id.layout_delivery_detail);
            layout_order = itemView.findViewById(R.id.layout_order);
        }
    }
}
