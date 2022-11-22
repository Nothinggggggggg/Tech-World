package com.android.developer.designtechworld.fragment.product;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.developer.designtechworld.R;
import com.android.developer.designtechworld.adapter.ProductAdapter;
import com.android.developer.designtechworld.model.Product;

import java.util.ArrayList;
import java.util.List;


public class SmartPhoneFragment extends Fragment {
    //Widget
    private RecyclerView rev_product;
    private void initUI(View view){
        rev_product = view.findViewById(R.id.rev_product);
    }
    //Var
    private ProductAdapter adapter;
    private void var(){
        adapter = new ProductAdapter(getContext());
    }
    //Launcher UI
    private void launcherUI(){
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_smart_phone, container, false);

        //Widget - Var
        initUI(view);
        var();

        //Recycler View
        List<Product> list = new ArrayList<>();
        list.add(new Product("ROG G513IH","8/512GB",1100));
        list.add(new Product("ROG G513IH","8/512GB",1100));
        list.add(new Product("ROG G513IH","8/512GB",1100));
        list.add(new Product("ROG G513IH","8/512GB",1100));
        list.add(new Product("ROG G513IH","8/512GB",1100));
        list.add(new Product("ROG G513IH","8/512GB",1100));
        refreshUI(list);

        //Launcher UI
        launcherUI();


        return view;
    }

    private void refreshUI(List<Product> list) {
        adapter.setData(list);
        rev_product.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        rev_product.setAdapter(adapter);
    }

}