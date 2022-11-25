package com.android.developer.techworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.android.developer.techworld.fragment.AccountFragment;
import com.android.developer.techworld.fragment.HomeFragment;
import com.android.developer.techworld.fragment.OrderFragment;
import com.android.developer.techworld.fragment.ShoppingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    public static final String PREFS_FILE = "PREFS_FILE.MY_APP";
    //Widget
    private BottomNavigationView bottom_nav;
    private void initUI(){
         bottom_nav = findViewById(R.id.bottom_nav);
    }
    //Var
    private void var(){

    }
    //Launcher UI
    private void launcherUI(){
        //Tab 'Home' is Launcher Screen
        switchFragment(new HomeFragment());

        //Full Screen
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Widget - Var
        initUI();
        var();

       

        //Switch Screen
        bottom_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        switchFragment (new HomeFragment());
                        return true;
                    case R.id.shopping:
                        switchFragment (new ShoppingFragment());
                        return true;
                    case R.id.order:
                        switchFragment (new OrderFragment());
                        return true;
                    case R.id.account:
                        switchFragment (new AccountFragment());
                        return true;
                    default:
                        return false;
                }
            }
        });

        //Launcher UI
        launcherUI();

    }

    private void switchFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();
    }

}