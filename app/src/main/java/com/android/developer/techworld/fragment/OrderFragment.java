package com.android.developer.techworld.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.developer.techworld.DAO.OrderDAO;
import com.android.developer.techworld.MainActivity;
import com.android.developer.techworld.R;
import com.android.developer.techworld.adapter.OrderAdapter;
import com.android.developer.techworld.model.Order;

import java.util.ArrayList;


public class OrderFragment extends Fragment {
    //Widget
    private RecyclerView rev_order;
    private void initUI(View view){
        rev_order = view.findViewById(R.id.rev_order);
    }
    //Var
    private OrderAdapter adapter;
    private OrderDAO orderDAO;
    private SharedPreferences sharedPreferences;
    private void var(){
        adapter = new OrderAdapter(getContext());

        orderDAO = new OrderDAO(getContext());

        sharedPreferences = getContext().getSharedPreferences(MainActivity.PREFS_FILE, Context.MODE_PRIVATE);
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
        refreshUI(orderDAO.getDatabase_Customer(sharedPreferences.getString("ID","")));

        //Launcher UI
        launcherUI();


        return view;
    }

    private void refreshUI(ArrayList<Order> list) {
        adapter.setData(list);
        rev_order.setLayoutManager(new LinearLayoutManager(getContext()));
        rev_order.setAdapter(adapter);
    }
}