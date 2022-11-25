package com.android.developer.techworld.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.developer.techworld.LoginActivity;
import com.android.developer.techworld.MainActivity;
import com.android.developer.techworld.R;

public class AccountFragment extends Fragment {
    //Widget
    private TextView tv_account_role,tv_account_name,tv_account_id,
            tv_name,tv_phone,tv_address;
    private LinearLayout profile,profile_detail,logout;
    private ImageView img_profile_detail;
    private void initUI(View view){
        tv_account_id = view.findViewById(R.id.tv_account_id);
        tv_account_name = view.findViewById(R.id.tv_account_name);
        tv_account_role = view.findViewById(R.id.tv_account_role);
        tv_name = view.findViewById(R.id.tv_name);
        tv_phone = view.findViewById(R.id.tv_phone);
        tv_address = view.findViewById(R.id.tv_address);
        profile = view.findViewById(R.id.profile);
        img_profile_detail = view.findViewById(R.id.img_profile_detail);
        profile_detail = view.findViewById(R.id.profile_detail);
        logout = view.findViewById(R.id.logout);
    }
    //Var
    SharedPreferences sharedPreferences;
    private void var(){
        sharedPreferences = getActivity().getSharedPreferences(MainActivity.PREFS_FILE, Context.MODE_PRIVATE);
    }
    //Launcher UI
    private void launcherUI(){
        // 'Info'
        tv_account_id.setText(sharedPreferences.getString("ID",""));
        tv_account_name.setText(sharedPreferences.getString("NAME",""));
        if (sharedPreferences.getBoolean("ROLE",false)){
            tv_account_role.setText("Admin");
        }else{
            tv_account_role.setText("User");
        }

        // 'Profile'
        tv_name.setText("Họ tên : "+sharedPreferences.getString("NAME",""));
        tv_phone.setText("Số điện thoại : "+sharedPreferences.getString("PHONE",""));
        tv_address.setText("Địa chỉ : "+sharedPreferences.getString("ADDRESS",""));

        // 'Logout'
        logout.setOnClickListener(v -> switchUI(LoginActivity.class));

    }

    private void switchUI(Class activity) {
        Intent intent = new Intent(getActivity(),activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        //Widget - Var
        initUI(view);
        var();

        // 'Profile'
        profile.setOnClickListener(v -> {
            if(profile_detail.getVisibility() == View.GONE){
                profile_detail.setVisibility(View.VISIBLE);

                img_profile_detail.setImageResource(R.drawable.ic_down);
            }else{
                profile_detail.setVisibility(View.GONE);

                img_profile_detail.setImageResource(R.drawable.ic_next);
            }
        });

        //Launcher UI
        launcherUI();


        return view;
    }
}