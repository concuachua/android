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

import com.example.suphuy.assigmment_huyphpk00628.Control.SetTingLanguage;
import com.example.suphuy.assigmment_huyphpk00628.R;

import java.util.Locale;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class Fragment_SettingMore_Language extends Fragment implements View.OnClickListener {
    View view;
FragmentManager fragmentManager;
    FrameLayout fragmentSettingInRight,frameLayoutSetTingMoreRight;
    ImageView btnBack,imageViewchecked2,imageViewchecked1;
    Button btSave;
    LinearLayout lnSelectLanguage2,lnSelectLanguage1,lnSave;
    Animation animationthoat,animation,animation01 ,animationright_out,animationleft_in;
    private Locale myLocale;
    public Fragment_SettingMore_Language(){

    }
    public Fragment_SettingMore_Language(FragmentManager fm, FrameLayout fragmentSettingInRight,
                                         FrameLayout flht){
this.fragmentManager=fm;
        this.frameLayoutSetTingMoreRight=flht;
        this.fragmentSettingInRight=fragmentSettingInRight;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.fragment_setting_language, container, false);
        anhxa();
//      Toast.makeText(getContext(),"ngôn ngữ"+ myLocale.getLanguage(),Toast.LENGTH_LONG).show();
        imageViewchecked2.setVisibility(view.GONE);
        imageViewchecked1.setVisibility(View.VISIBLE);
        btSave.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        lnSelectLanguage2.setOnClickListener(this);
        lnSelectLanguage1.setOnClickListener(this);
        lnSave.setOnClickListener(this);
        return view;
    }
    private void thongbao(String nd){
        Toast.makeText(getContext(),nd,Toast.LENGTH_LONG).show();
    }
    private void anhxa(){
        lnSave=(LinearLayout)view.findViewById(R.id.lnSave);
        lnSelectLanguage2=(LinearLayout)view.findViewById(R.id.lnSelectLanguage2);
        imageViewchecked2=(ImageView)view.findViewById(R.id.imageViewchecked2);
        imageViewchecked1=(ImageView)view.findViewById(R.id.imageViewchecked1);
        lnSelectLanguage1=(LinearLayout)view.findViewById(R.id.lnSelectLanguage1);
        btSave=(Button) view.findViewById(R.id.btnSave);
        btnBack=(ImageView)view.findViewById(R.id.btnBack);
        animationthoat = AnimationUtils.loadAnimation(getContext(), R.anim.left_out);
        animationleft_in = AnimationUtils.loadAnimation(getContext(), R.anim.left_in);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.right_in);
        animation01 = AnimationUtils.loadAnimation(getContext(), R.anim.text01);
        animationright_out= AnimationUtils.loadAnimation(getContext(), R.anim.right_out);
    }

    @Override
    public void onClick(View view) {
            if(view==btnBack){
                frameLayoutSetTingMoreRight.startAnimation(animationright_out);
                frameLayoutSetTingMoreRight.setVisibility(View.GONE);
            }else if(view==btSave){
                frameLayoutSetTingMoreRight.startAnimation(animationright_out);
                frameLayoutSetTingMoreRight.setVisibility(View.GONE);

            }else if(view== lnSelectLanguage2){
                SetTingLanguage.changeLang("en",getActivity());
                SetTingLanguage.loadLocale(getActivity());
                Toast.makeText(getContext(),"Changed Language",Toast.LENGTH_SHORT).show();
                imageViewchecked2.setVisibility(view.VISIBLE);
                imageViewchecked1.setVisibility(View.GONE);
            }else
            if(view== lnSelectLanguage1){
                SetTingLanguage.changeLang("vi",getActivity());
                SetTingLanguage.loadLocale(getActivity());
                Toast.makeText(getContext(),"đã thay đổi ngôn ngữ",Toast.LENGTH_SHORT).show();
                imageViewchecked2.setVisibility(view.GONE);
                imageViewchecked1.setVisibility(View.VISIBLE);
            }else if(view==lnSave){
                getActivity().finish();
                frameLayoutSetTingMoreRight.startAnimation(animationright_out);
                frameLayoutSetTingMoreRight.setVisibility(View.GONE);
            }
        }

    @Override
    public void onResume() {
        SetTingLanguage.loadLocale(getActivity());
        super.onResume();
    }
}

