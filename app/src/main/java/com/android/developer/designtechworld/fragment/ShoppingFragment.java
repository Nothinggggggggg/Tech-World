package com.android.developer.designtechworld.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.android.developer.designtechworld.R;
import com.android.developer.designtechworld.adapter.PagerProductAdapter;


public class ShoppingFragment extends Fragment {
    //Widget
    private ViewPager2 view_pager;

    private void initUI(View view) {
        view_pager = view.findViewById(R.id.view_pager);
    }

    //Var
    private void var() {

    }

    //Launcher UI
    private void launcherUI() {
        //switch tab Viewpager (vs Màn hình sản phẩm dc gọi từ tab 'Home')
        if (getArguments() != null) {
            view_pager.setCurrentItem(getArguments().getInt("BUNDLE_TAB"));
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shopping, container, false);

        //Widget - Var
        initUI(view);
        var();

        //Tabs 'Product'
        PagerProductAdapter productAdapter = new PagerProductAdapter(getActivity());
        view_pager.setAdapter(productAdapter);

        //



        //Launcher UI
        launcherUI();


        return view;
    }




}