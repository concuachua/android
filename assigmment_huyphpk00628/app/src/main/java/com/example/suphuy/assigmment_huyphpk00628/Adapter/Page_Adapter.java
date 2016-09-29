package com.example.suphuy.assigmment_huyphpk00628.Adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.suphuy.assigmment_huyphpk00628.Fragment.TaiKhoan.Fragment_Account_Tab1;
import com.example.suphuy.assigmment_huyphpk00628.Fragment.TaiKhoan.Fragment_Account_Tab2;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class Page_Adapter  extends FragmentStatePagerAdapter {
    public Page_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag=null;
        switch (position){
            case 0:
                frag=new Fragment_Account_Tab1();
                break;
            case 1:
                frag=new Fragment_Account_Tab2();
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
                title="Tài Khoản";
                break;
            case 1:
                title="Sổ Tiết Kiệm";
                break;
        }
        return title;
    }

}