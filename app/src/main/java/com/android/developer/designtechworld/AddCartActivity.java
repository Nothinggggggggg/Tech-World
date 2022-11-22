package com.android.developer.designtechworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.android.developer.designtechworld.fragment.AccountFragment;
import com.android.developer.designtechworld.fragment.HomeFragment;
import com.android.developer.designtechworld.fragment.OrderFragment;
import com.android.developer.designtechworld.fragment.ShoppingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class AddCartActivity extends AppCompatActivity {
    //Widget
    private void initUI(){
    }
    //Var
    private void var(){

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
        setContentView(R.layout.activity_add_cart);

        //Widget - Var
        initUI();
        var();

        //

        //Launcher UI
        launcherUI();
    }
}