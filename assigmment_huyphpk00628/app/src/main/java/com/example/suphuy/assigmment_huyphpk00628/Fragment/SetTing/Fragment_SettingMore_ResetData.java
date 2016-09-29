package com.example.suphuy.assigmment_huyphpk00628.Fragment.SetTing;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.R;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class Fragment_SettingMore_ResetData extends Fragment implements View.OnClickListener {
    View view;
FragmentManager fragmentManager;
    LinearLayout lnConfirm;
    FrameLayout fragmentSettingInRight,frameLayoutSetTingMoreRight;
    ImageView btnBack;
    Animation animationthoat,animation,animation01 ,animationright_out,animationleft_in;

    public Fragment_SettingMore_ResetData(){

    }
    public Fragment_SettingMore_ResetData(FragmentManager fm, FrameLayout fragmentSettingInRight, FrameLayout flht){
this.fragmentManager=fm;
        this.frameLayoutSetTingMoreRight=flht;
        this.fragmentSettingInRight=fragmentSettingInRight;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.setting_confirm_resetdata, container, false);
        anhxa();
        btnBack.setOnClickListener(this);
        lnConfirm.setOnClickListener(this);
        return view;
    }
    private void thongbao(String nd){
        Toast.makeText(getContext(),nd,Toast.LENGTH_LONG).show();
    }
    private void anhxa(){
        lnConfirm=(LinearLayout)view.findViewById(R.id.lnConfirm);
        btnBack=(ImageView)view.findViewById(R.id.btnBack);
        animationthoat = AnimationUtils.loadAnimation(getContext(), R.anim.left_out);
        animationleft_in = AnimationUtils.loadAnimation(getContext(), R.anim.left_in);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.right_in);
        animation01 = AnimationUtils.loadAnimation(getContext(), R.anim.text01);
        animationright_out= AnimationUtils.loadAnimation(getContext(), R.anim.right_out);
    }

    @Override
    public void onClick(View view) {
            if(view==lnConfirm){
                frameLayoutSetTingMoreRight.startAnimation(animationright_out);
                frameLayoutSetTingMoreRight.setVisibility(View.GONE);
                Toast.makeText(getContext(),"đã reset thành công",Toast.LENGTH_SHORT).show();
            }
            else if(view==btnBack){
                frameLayoutSetTingMoreRight.startAnimation(animationright_out);
                frameLayoutSetTingMoreRight.setVisibility(View.GONE);
            }
        }
    }

