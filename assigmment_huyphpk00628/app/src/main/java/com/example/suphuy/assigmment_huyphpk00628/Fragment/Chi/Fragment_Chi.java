package com.example.suphuy.assigmment_huyphpk00628.Fragment.Chi;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.Custom.DiaLog_Date;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.Receiver.ReceiverNotification;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class Fragment_Chi extends Fragment implements View.OnClickListener {
    private static FragmentManager fragmentManager;
    FrameLayout fragmentControlThuChi,fragmentControlThuChiRight,fragmenttControlThuChiInRight;
    LinearLayout lnSelectDate,lnSelectCategory,MainThuChi,lnSelectAccount,lnDescription;
    Animation animationthoat,animation ,animationright_out,animationleft_in;
    TextView txteditMoney,txtExpenseType, txtDescription, txtAccountName, txtDate ,txtExpenseFor ,txtLenderTitle, txtLender;
    ImageView imageViewGhiChu,imgAdd;
    View view;
    Context ct;
   public Fragment_Chi(){

    }
    public Fragment_Chi(Context a,FragmentManager fm, FrameLayout fl, FrameLayout flRight, FrameLayout flInRight){
        this.fragmentManager=fm;
        this.fragmentControlThuChi=fl;
        this.fragmentControlThuChiRight=flInRight;
        ct=a;
        this.fragmenttControlThuChiInRight=flRight;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.fragment_chi, container, false);
        anhxa();


        txteditMoney.setOnClickListener(this);
        lnSelectDate.setOnClickListener(this);
        lnSelectCategory.setOnClickListener(this);
        lnSelectAccount.setOnClickListener(this);
        lnDescription.setOnClickListener(this);
        return view;
    }
    private void anhxa(){
      txtExpenseType=(TextView)view.findViewById(R.id.txtExpenseType);
        txtDescription=(TextView)view.findViewById(R.id.txtDescription);
        txtAccountName=(TextView)view.findViewById(R.id.txtAccountName);
        txtDate=(TextView)view.findViewById(R.id.txtDate);
        txtExpenseFor=(TextView)view.findViewById(R.id.txtExpenseFor);
        txtLenderTitle=(TextView)view.findViewById(R.id.txtLenderTitle);
        lnDescription=(LinearLayout)view.findViewById(R.id.lnDescription);

        lnSelectAccount=(LinearLayout)view.findViewById(R.id.lnSelectAccount) ;
        lnSelectCategory=(LinearLayout)view.findViewById(R.id.lnSelectCategory);
        lnSelectDate=(LinearLayout)view.findViewById(R.id.lnSelectDate);
        txteditMoney=(TextView)view.findViewById(R.id.txteditMoney);
        imageViewGhiChu=(ImageView)view.findViewById(R.id.imageViewGhiChu);
        animationthoat = AnimationUtils.loadAnimation(getContext(), R.anim.left_out);
        animationleft_in = AnimationUtils.loadAnimation(getContext(), R.anim.left_in);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.right_in);
        animationright_out= AnimationUtils.loadAnimation(getContext(), R.anim.right_out);
        MainThuChi=(LinearLayout)getActivity().findViewById(R.id.MainThuChi);
    }
    private void thongbao(String nd){
        Toast.makeText(getContext(),nd,Toast.LENGTH_LONG).show();
    }
    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.lnDescription: {
                {
                    fragmentControlThuChi.setVisibility(View.VISIBLE);
                    fragmentManager.beginTransaction().replace(fragmentControlThuChi.getId(),
                      new Fragment_EditText(fragmentControlThuChi,txtDescription,txtDescription.getText().toString())).commit();
                    fragmentControlThuChi.startAnimation(animation);
                    MainThuChi.startAnimation(animationthoat);
                } }break;
            case R.id.txteditMoney: {
                {
                    fragmentControlThuChi.setVisibility(View.VISIBLE);
                    fragmentManager.beginTransaction().replace(fragmentControlThuChi.getId(),
                            new Fragment_Edit_Money(fragmentControlThuChi,txteditMoney)).commit();
                    fragmentControlThuChi.startAnimation(animation);
                    MainThuChi.startAnimation(animationthoat);
                } }break;
            case R.id.lnSelectDate:{
//                dialog_time=new Dialog_Time(getContext());
//                onCreateDialog(Date_id).show();
//                try{
//                    showDialog(Date_id);
//                }catch (Exception e){
//                    thongbao(e.getMessage().toString()+" lỗi");
//             }
                try{
                    DiaLog_Date diaLog_date=new DiaLog_Date(getContext());
                    diaLog_date.show();
                }catch (Exception e){
                    thongbao("lỗi"+e.getMessage().toString());
                }


            }break;
            case R.id.lnSelectCategory:{
                {
                    fragmentControlThuChi.setVisibility(View.VISIBLE);
                    fragmentManager.beginTransaction().replace(fragmentControlThuChi.getId(),
                            new Fragment_Category(fragmentManager,fragmentControlThuChi,
                                    fragmentControlThuChiRight,txtExpenseType)).commit();
                    fragmentControlThuChi.startAnimation(animation);
                    MainThuChi.startAnimation(animationthoat);
                }}break;
            case R.id.lnSelectAccount:{
                {
                    fragmentControlThuChi.setVisibility(View.VISIBLE);
                    fragmentManager.beginTransaction().setCustomAnimations(R.anim.right_in, R.anim.left_out)
                            .replace(fragmentControlThuChi.getId(),
                            new Fragment_Tick_Account(fragmentControlThuChi,txtAccountName,txtAccountName.getText().toString())).commit();
                    fragmentControlThuChi.startAnimation(animation);
                    MainThuChi.startAnimation(animationthoat);
                }}break;
        }
    }


}
