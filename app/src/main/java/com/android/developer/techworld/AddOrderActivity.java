package com.android.developer.techworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.developer.techworld.DAO.OrderDAO;
import com.android.developer.techworld.model.Product;

public class AddOrderActivity extends AppCompatActivity {
    //Widget
    private ImageView product_banner;
    private TextView product_price,product_description;
    private ImageButton btn_up,btn_down;
    private TextView tv_total,tv_count;
    private Button btn_add_order;
    private void initUI(){
        product_banner = findViewById(R.id.product_banner);
        product_price = findViewById(R.id.product_price);
        product_description = findViewById(R.id.product_description);
        btn_up = findViewById(R.id.btn_up);
        btn_down = findViewById(R.id.btn_down);
        tv_count = findViewById(R.id.tv_count);
        tv_total = findViewById(R.id.tv_total);
        btn_add_order = findViewById(R.id.btn_add_order);
    }
    //Var
    private Product product;
    private int count;
    private OrderDAO orderDAO;
    private SharedPreferences sharedPreferences;
    private void var(){
        if(getIntent() != null){
            Bundle bundle = getIntent().getExtras();

             product = (Product) bundle.getSerializable("BUNDLE_PRODUCT");
        }

        count = 1;

        orderDAO = new OrderDAO(this);

        sharedPreferences = getSharedPreferences(MainActivity.PREFS_FILE,MODE_PRIVATE);
    }
    //Launcher UI
    private void launcherUI(){
        //Full Screen
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        //Widget - Var
        initUI();
        var();

        //
        if(getIntent() != null){
            product_banner.setImageResource(product.getIMG_banner());
            product_price.setText("$"+product.getPrice());
            product_description.setText(product.getDescription());
            tv_total.setText(String.valueOf(product.getPrice()));
        }

        //quantity
        btn_down.setOnClickListener(v -> countDown());
        btn_up.setOnClickListener(v -> countUp());

        //Add to Order
        btn_add_order.setOnClickListener(v -> {
            int quantity = count;
            int total = quantity*product.getPrice();
            String account_id = sharedPreferences.getString("ID","");
            int product_id = product.getId();
            boolean check = orderDAO.insertDatabase(quantity,total,account_id,product_id);
            
            if(check){
                Toast.makeText(this, "Thêm vào giỏ hàng thành công", Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(this, "Thêm vào giỏ hàng thất bại!", Toast.LENGTH_SHORT).show();

            }
        });

        //Launcher UI
        launcherUI();
    }

    private void countUp() {
        count++;

        tv_count.setText(String.valueOf(count));
        tv_total.setText(String.valueOf(count*product.getPrice()));
    }

    private void countDown() {
        if(count <= 1){
            return;
        }

        count--;

        tv_count.setText(String.valueOf(count));
        tv_total.setText(String.valueOf(count*product.getPrice()));
    }
}