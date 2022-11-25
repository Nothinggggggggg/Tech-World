package com.android.developer.techworld.fragment.product;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.developer.techworld.DAO.ProductDAO;
import com.android.developer.techworld.R;
import com.android.developer.techworld.adapter.ProductAdapter;
import com.android.developer.techworld.model.Product;

import java.util.ArrayList;


public class OtherFragment extends Fragment {
    //Widget
    private RecyclerView rev_product;
    private void initUI(View view){
        rev_product = view.findViewById(R.id.rev_product);
    }
    //Var
    private ProductAdapter adapter;
    private ProductDAO productDAO;
    private void var(){
        adapter = new ProductAdapter(getContext());
        productDAO = new ProductDAO(getContext());
    }
    //Launcher UI
    private void launcherUI(){
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_other, container, false);

        //Widget - Var
        initUI(view);
        var();

        //Recycler View
        if(productDAO.getDatabase_Other().size() <= 0){
            productDAO.insertDatabase(new Product(R.drawable.other_tv_lg_qled,"LG QLED Tivi","65 inch - 2K","Thiết kế Infinity One màn hình vô cực nâng tầm trải nghiệm xem\n",2100,3));
        }

        refreshUI(productDAO.getDatabase_Other());

        //Launcher UI
        launcherUI();


        return view;
    }

    private void refreshUI(ArrayList<Product> list) {
        adapter.setData(list);
        rev_product.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        rev_product.setAdapter(adapter);
    }
}
