package com.example.quanlychitieu.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.quanlychitieu.TabPage.KhoanThuFragment;
import com.example.quanlychitieu.TabPage.LoaiThuFragment;


public class PageAdapter extends FragmentStatePagerAdapter {


    public PageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag= new KhoanThuFragment();
                break;
            case 1:
                frag=new LoaiThuFragment();

                break;

        }
        return frag;
    }


    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        String title = "";
        switch (position){
            case 0:
                title = "Khoản Thu";
                break;
            case 1:
                title = "Loại Thu";
                break;
        }
        return title;
    }
}
