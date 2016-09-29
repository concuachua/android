package com.example.suphuy.assigmment_huyphpk00628.Fragment.Chi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.R;

/**
 * Created by SUPHUY on 9/19/2016.
 */

public class Fragment_Add_Category_Sub extends Fragment implements View.OnClickListener {
    FrameLayout fragmentControlThuChiRight;
    FragmentManager fragmentManager;
    View view;
    Animation animationthoat ,animation;
    TextView btnCancel,btnSave;
    public Fragment_Add_Category_Sub(FragmentManager frm ,FrameLayout fl) {
        fragmentControlThuChiRight=fl;
        this.fragmentManager=frm;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_add_category_sub, container, false);
        anhxa();
        btnCancel.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        return view ;

    }

    @Override
    public void onClick(View view) {
        if(view==btnSave){
            Toast.makeText(getContext(),"bạn đã tạo mới 1 mục",Toast.LENGTH_SHORT).show();
            fragmentControlThuChiRight.startAnimation(animationthoat);
            fragmentControlThuChiRight.setVisibility(View.GONE);
        } else if(view==btnCancel){
            fragmentControlThuChiRight.startAnimation(animationthoat);
            fragmentControlThuChiRight.setVisibility(View.GONE);
        }
    }
    private void anhxa(){
        btnCancel=(TextView)view.findViewById(R.id.btnCancel);
        btnSave=(TextView)view.findViewById(R.id.btnSave);
        animationthoat = AnimationUtils.loadAnimation(getContext(), R.anim.right_out);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.right_in);
    }
}