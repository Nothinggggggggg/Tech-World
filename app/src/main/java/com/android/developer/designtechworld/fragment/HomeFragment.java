package com.android.developer.designtechworld.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.android.developer.designtechworld.R;
import com.android.developer.designtechworld.fragment.product.ComputerFragment;
import com.android.developer.designtechworld.fragment.product.OtherFragment;
import com.android.developer.designtechworld.fragment.product.SmartPhoneFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomeFragment extends Fragment {
    //Widget
    private CardView card_computer, card_phone,card_other;
    private BottomNavigationView bottom_nav;
    private ViewPager2 view_pager;
    private ImageButton btn_account;
    private void initUI(View view){
        card_computer =view.findViewById(R.id.card_computer);
        card_phone =view.findViewById(R.id.card_phone);
        card_other =view.findViewById(R.id.card_other);
        bottom_nav = getActivity().findViewById(R.id.bottom_nav);
        btn_account = view.findViewById(R.id.btn_account);
    }
    //Var
    private void var(){

    }
    //Launcher UI
    private void launcherUI(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Widget - Var
        initUI(view);
        var();

        //switch Tab 'Shopping'
        card_computer.setOnClickListener(v -> {
            switchTabProduct(0);
        });
        card_phone.setOnClickListener(v -> {
            switchTabProduct(1);
        });
        card_other.setOnClickListener(v -> {
            switchTabProduct(2);
        });

        //switch Tab 'Shopping'
        btn_account.setOnClickListener(v -> {
            bottom_nav.setSelectedItemId(R.id.account);
        });


        //Launcher UI
        launcherUI();

        return view;
    }

    private void switchTabProduct(int current) {
        bottom_nav.setSelectedItemId(R.id.shopping);

        try {
            Bundle bundle = new Bundle();
            bundle.putInt("BUNDLE_TAB",current);
            ShoppingFragment fragment = new ShoppingFragment();
            fragment.setArguments(bundle);
            FragmentTransaction fts = getActivity().getSupportFragmentManager().beginTransaction();
            fts.replace(R.id.frame_layout, fragment);
            fts.addToBackStack(fragment.getClass().getSimpleName());
            fts.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}