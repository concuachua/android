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
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.R;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class Fragment_SettingMore extends Fragment implements View.OnClickListener {
    View view;
   LinearLayout lnPassCode,LinearLayoutMainSetTingMore,lnResetData,lnLanguage;
    FragmentManager fragmentManager;
    FrameLayout frameLayoutSetTingMoreRight,frameLayoutSetTingMore,fragmentSettingInRight;
    LinearLayout btnBack,lnSync;
    Animation animationthoat,animation,animation01 ,animationright_out,animationleft_in;
   public Fragment_SettingMore(){

    }
    public Fragment_SettingMore(FragmentManager fm, FrameLayout fl, FrameLayout flRight, FrameLayout flInRight){
        this.fragmentManager=fm;
        this.frameLayoutSetTingMore=fl;
        this.fragmentSettingInRight=flInRight;
        this.frameLayoutSetTingMoreRight=flRight;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.settingmore, container, false);
        anhxa();
        lnPassCode.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        lnResetData.setOnClickListener(this);
        lnLanguage.setOnClickListener(this);
        lnSync.setOnClickListener(this);
                return view;
    }
    private void thongbao(String nd){

        Toast.makeText(getContext(),nd,Toast.LENGTH_LONG).show();
    }
    private void anhxa(){
        lnSync=(LinearLayout)view.findViewById(R.id.lnSync);
        lnLanguage=(LinearLayout)view.findViewById(R.id.lnLanguage);
        lnResetData=(LinearLayout)view.findViewById(R.id.lnResetData);
        btnBack=(LinearLayout)view.findViewById(R.id.btnBack);
        LinearLayoutMainSetTingMore=(LinearLayout)view.findViewById(R.id.LinearLayoutMainSetTingMore);
        lnPassCode =(LinearLayout)view.findViewById(R.id.lnPassCode);
        animationthoat = AnimationUtils.loadAnimation(getContext(), R.anim.left_out);
        animationleft_in = AnimationUtils.loadAnimation(getContext(), R.anim.left_in);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.right_in);
        animation01 = AnimationUtils.loadAnimation(getContext(), R.anim.text01);
        animationright_out= AnimationUtils.loadAnimation(getContext(), R.anim.right_out);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.lnSync:{
                frameLayoutSetTingMoreRight.setVisibility(View.VISIBLE);
                fragmentManager.beginTransaction().replace(frameLayoutSetTingMoreRight.getId(),
                        new Fragment_SettingMore_Sync(fragmentManager,fragmentSettingInRight,frameLayoutSetTingMoreRight)).commit();
                LinearLayoutMainSetTingMore.startAnimation(animationthoat);
                frameLayoutSetTingMoreRight.startAnimation(animation);
            }break;
            case R.id.lnPassCode:{
                frameLayoutSetTingMoreRight.setVisibility(View.VISIBLE);
                fragmentManager.beginTransaction().replace(frameLayoutSetTingMoreRight.getId(),
                        new Fragment_SettingMore_PassWord(fragmentManager,fragmentSettingInRight,frameLayoutSetTingMoreRight)).commit();
                LinearLayoutMainSetTingMore.startAnimation(animationthoat);
                frameLayoutSetTingMoreRight.startAnimation(animation);
            }break;
            case R.id.lnResetData:{
                frameLayoutSetTingMoreRight.setVisibility(View.VISIBLE);
                fragmentManager.beginTransaction().replace(frameLayoutSetTingMoreRight.getId(),
                        new Fragment_SettingMore_ResetData(fragmentManager,fragmentSettingInRight,frameLayoutSetTingMoreRight)).commit();
                LinearLayoutMainSetTingMore.startAnimation(animationthoat);
                frameLayoutSetTingMoreRight.startAnimation(animation);
            }break;
            case R.id.lnLanguage:{
                frameLayoutSetTingMoreRight.setVisibility(View.VISIBLE);
                fragmentManager.beginTransaction().replace(frameLayoutSetTingMoreRight.getId(),
                        new Fragment_SettingMore_Language(fragmentManager,fragmentSettingInRight,frameLayoutSetTingMoreRight)).commit();
                LinearLayoutMainSetTingMore.startAnimation(animationthoat);
                frameLayoutSetTingMoreRight.startAnimation(animation);
            }break;
            case R.id.btnBack:{
                frameLayoutSetTingMore.startAnimation(animationright_out);
                frameLayoutSetTingMore.setVisibility(View.GONE);
            }
        }


    }


}
