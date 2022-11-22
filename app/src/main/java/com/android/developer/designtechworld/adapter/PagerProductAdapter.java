package com.android.developer.designtechworld.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.android.developer.designtechworld.fragment.product.ComputerFragment;
import com.android.developer.designtechworld.fragment.product.OtherFragment;
import com.android.developer.designtechworld.fragment.product.SmartPhoneFragment;

public class PagerProductAdapter extends FragmentStateAdapter {
    public PagerProductAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new ComputerFragment();
            case 1:
                return new SmartPhoneFragment();
            case 2:
                return new OtherFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
