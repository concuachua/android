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
import android.widget.ToggleButton;

import com.example.suphuy.assigmment_huyphpk00628.R;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class Fragment_SettingMore_PassWord extends Fragment implements View.OnClickListener {
    View view;
FragmentManager fragmentManager;
    LinearLayout Use_passcode,lnchangePasscode;
    ToggleButton tbtn_use_passcode;
    FrameLayout fragmentSettingInRight,frameLayoutSetTingMoreRight;
    ImageView btnBack;
    Animation animationthoat,animation,animation01 ,animationright_out,animationleft_in;

    public Fragment_SettingMore_PassWord(){

    }
    public Fragment_SettingMore_PassWord(FragmentManager fm,FrameLayout fragmentSettingInRight, FrameLayout flht){
this.fragmentManager=fm;
        this.frameLayoutSetTingMoreRight=flht;
        this.fragmentSettingInRight=fragmentSettingInRight;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.setting_password, container, false);
        anhxa();
        tbtn_use_passcode.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        lnchangePasscode.setOnClickListener(this);
        return view;
    }
    private void thongbao(String nd){
        Toast.makeText(getContext(),nd,Toast.LENGTH_LONG).show();
    }
    private void anhxa(){
        lnchangePasscode=(LinearLayout)view.findViewById(R.id.lnchangePasscode);
        btnBack=(ImageView)view.findViewById(R.id.btnBack);
        tbtn_use_passcode=(ToggleButton)view.findViewById(R.id.tbtn_use_passcode) ;
        animationthoat = AnimationUtils.loadAnimation(getContext(), R.anim.left_out);
        animationleft_in = AnimationUtils.loadAnimation(getContext(), R.anim.left_in);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.right_in);
        animation01 = AnimationUtils.loadAnimation(getContext(), R.anim.text01);
        animationright_out= AnimationUtils.loadAnimation(getContext(), R.anim.right_out);
        Use_passcode=(LinearLayout)view.findViewById(R.id.Use_passcode);
    }

    @Override
    public void onClick(View view) {
            if(view==tbtn_use_passcode){
                fragmentSettingInRight.setVisibility(View.VISIBLE);
                fragmentManager.beginTransaction().replace(fragmentSettingInRight.getId(),
                 new Fragment_SettingMore_PassCode_Add(fragmentSettingInRight)).commit();
                this.view.startAnimation(animationthoat);
                fragmentSettingInRight.startAnimation(animation);
            }
            else if(view==btnBack){
                frameLayoutSetTingMoreRight.startAnimation(animationright_out);
                frameLayoutSetTingMoreRight.setVisibility(View.GONE);
            }else if(view==lnchangePasscode){
                Toast.makeText(getContext(),"huydsdfsd",Toast.LENGTH_SHORT).show();
                fragmentSettingInRight.setVisibility(View.VISIBLE);
                fragmentManager.beginTransaction().replace(fragmentSettingInRight.getId(),
                        new Fragment_SettingMore_ChangePassWord(fragmentSettingInRight)).commit();
                this.view.startAnimation(animationthoat);
                fragmentSettingInRight.startAnimation(animation);
            }
        }
    }

