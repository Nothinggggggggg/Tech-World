package com.android.developer.designtechworld.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.android.developer.designtechworld.R;
import com.android.developer.designtechworld.adapter.OrderAdapter;
import com.android.developer.designtechworld.adapter.ProductAdapter;
import com.android.developer.designtechworld.model.Order;
import com.android.developer.designtechworld.model.Product;

import java.util.ArrayList;
import java.util.List;


public class OrderFragment extends Fragment {
    //Widget
    private RecyclerView rev_order;
    private void initUI(View view){
        rev_order = view.findViewById(R.id.rev_order);
    }
    //Var
    private OrderAdapter adapter;
    private void var(){
        adapter = new OrderAdapter(getContext());
    }
    //Launcher UI
    private void launcherUI(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        //Widget - Var
        initUI(view);
        var();

        //Recycler View
        List<Order> list = new ArrayList<>();
        list.add(new Order());
        list.add(new Order());
        list.add(new Order());
        list.add(new Order());
        list.add(new Order());
        refreshUI(list);

        //Launcher UI
        launcherUI();


        return view;
    }

    private void refreshUI(List<Order> list) {
        adapter.setData(list);
        rev_order.setLayoutManager(new LinearLayoutManager(getContext()));
        rev_order.setAdapter(adapter);
    }
}