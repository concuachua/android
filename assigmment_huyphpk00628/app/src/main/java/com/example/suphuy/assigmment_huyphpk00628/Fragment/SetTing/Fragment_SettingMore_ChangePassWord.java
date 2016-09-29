package com.example.suphuy.assigmment_huyphpk00628.Fragment.SetTing;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.R;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class Fragment_SettingMore_ChangePassWord extends Fragment implements View.OnClickListener {
    View view;
    LinearLayout lnSave;
    FragmentManager fragmentManager;
    ImageView btnBack;
    Button btnSave;
    FrameLayout fragmentSettingInRight;
    Animation animationthoat,animation,animation01 ,animationright_out,animationleft_in;
   public Fragment_SettingMore_ChangePassWord(){

    }
    public Fragment_SettingMore_ChangePassWord(FrameLayout fl ){
        this.fragmentSettingInRight=fl;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.settingchangepass, container, false);
        anhxa();
        btnBack.setOnClickListener(this);
        lnSave.setOnClickListener(this);
        btnSave.setOnClickListener(this);
                return view;
    }
    private void thongbao(String nd){

        Toast.makeText(getContext(),nd,Toast.LENGTH_LONG).show();
    }
    private void anhxa(){
        lnSave=(LinearLayout)view.findViewById(R.id.lnSave);
        btnSave=(Button)view.findViewById(R.id.btnSave);
        btnBack=(ImageView) view.findViewById(R.id.btnBack);
        animationthoat = AnimationUtils.loadAnimation(getContext(), R.anim.left_out);
        animationleft_in = AnimationUtils.loadAnimation(getContext(), R.anim.left_in);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.right_in);
        animation01 = AnimationUtils.loadAnimation(getContext(), R.anim.text01);
        animationright_out= AnimationUtils.loadAnimation(getContext(), R.anim.right_out);
    }

    @Override
    public void onClick(View view) {
            if(view==btnBack){
                fragmentSettingInRight.startAnimation(animationright_out);
                fragmentSettingInRight.setVisibility(View.GONE);
            }else if(view==btnSave ||view==lnSave){
                fragmentSettingInRight.startAnimation(animationright_out);
                fragmentSettingInRight.setVisibility(View.GONE);
                thongbao("bạn đã thay đổi mật khẩu");
            }
        }

    }

