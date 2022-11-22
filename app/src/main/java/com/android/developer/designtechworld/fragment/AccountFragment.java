package com.android.developer.designtechworld.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.android.developer.designtechworld.R;

public class AccountFragment extends Fragment {
    //Widget
    private void initUI(){
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
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        //Widget - Var
        initUI();
        var();



        //Launcher UI
        launcherUI();


        return view;
    }
}