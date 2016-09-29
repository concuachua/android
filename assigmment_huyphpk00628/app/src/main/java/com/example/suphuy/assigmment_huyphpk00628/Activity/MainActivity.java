package com.example.suphuy.assigmment_huyphpk00628.Activity;

/**
 * Created by SUPHUY on 9/19/2016.  (huyphpk00628@fpt.edu.vn) phạm hoàng huy 01293223225
 */

import android.annotation.TargetApi;
import android.app.TabActivity;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.R;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity implements View.OnClickListener  {
ImageButton ImageButtonTab1,ImageButtonTab2,ImageButtonTab4,ImageButtonTab3;
    Animation animation;
    TabHost tabHost;
    LinearLayout LinearLayoutTabControl,LinearLayoutTabCustomControl;
    int tabon=0;
    float initialX;
    private  int columnIndex, position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar();
        setTitle("dsfsds");
        SetTabHost();
        anhxa();
        ImageButtonTab1.setOnClickListener(this);
        ImageButtonTab2.setOnClickListener(this);
        ImageButtonTab3.setOnClickListener(this);
        ImageButtonTab4.setOnClickListener(this);
        ImageButtonTab1.setImageResource(R.drawable.note_selected);

    }
    private void anhxa() {

        LinearLayoutTabCustomControl=(LinearLayout)findViewById(R.id.LinearLayoutTabCustomControl);
        LinearLayoutTabControl=(LinearLayout)findViewById(R.id.LinearLayoutTabControl);
        ImageButtonTab1=(ImageButton)  findViewById(R.id.ImageButtonTab1);
        ImageButtonTab2=(ImageButton)  findViewById(R.id.ImageButtonTab2);
        ImageButtonTab3=(ImageButton)  findViewById(R.id.ImageButtonTab3);
        ImageButtonTab4=(ImageButton)  findViewById(R.id.ImageButtonTab4);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_in);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        SetTabOff(tabon);
        switch (view.getId()){
            case  R.id.ImageButtonTab1:
                {

                  ImageButtonTab1.setImageResource(R.drawable.note_selected);
                 tabHost.setCurrentTab(0);
            }break;
            case R.id.ImageButtonTab2:
            {
                ImageButtonTab2.setImageResource(R.drawable.wallet_selected);
                tabHost.setCurrentTab(1);
             }break;
            case R.id.ImageButtonTab3:{
                ImageButtonTab3.setImageResource(R.drawable.pie_chart_selected);
                tabHost.setCurrentTab(2);
             }break;
            case R.id.ImageButtonTab4:{
                ImageButtonTab4.setImageResource(R.drawable.more_selected);
                tabHost.setCurrentTab(3);
             }
        }
        tabon=tabHost.getCurrentTab();
    }
    private void SetTabOff(int tab){
        switch (tab){
            case 0:{
                ImageButtonTab1.setImageResource(R.drawable.note);
            } break;
            case 1:{
                ImageButtonTab2.setImageResource(R.drawable.wallet);
            } break;
            case 2:{
                ImageButtonTab3.setImageResource(R.drawable.pie_chart);
            } break;
            case 3:{
                ImageButtonTab4.setImageResource(R.drawable.more);
            }
        }
    }
    private void SetTabHost(){
        tabHost = getTabHost();
        TabHost.TabSpec ThuChispec = tabHost.newTabSpec("thu chi");
        ThuChispec.setIndicator("thu chi");
        Intent ThuChiactivity = new Intent(this, ControlThuChiActivity.class);
        ThuChispec.setContent(ThuChiactivity);
        TabHost.TabSpec TaiKhoanSpec = tabHost.newTabSpec("tai khoan");
        TaiKhoanSpec.setIndicator("tài khoản");
        Intent TaiKhoanactivity = new Intent(this, TaiKhoanActivity.class);
        TaiKhoanSpec.setContent(TaiKhoanactivity);
        TabHost.TabSpec ThongKeSpec = tabHost.newTabSpec("thong ke");
        ThongKeSpec.setIndicator("thống kê");
        Intent ThongKeactivity = new Intent(this, ThongKeActivity.class);
        ThongKeSpec.setContent(ThongKeactivity);
        TabHost.TabSpec CaiDatSpec = tabHost.newTabSpec("cai dat");
        CaiDatSpec.setIndicator("cài đặt");
        Intent CaiDatactivity = new Intent(this, SetTingsActivity.class);
        CaiDatSpec.setContent(CaiDatactivity);
        tabHost.addTab(ThuChispec);
        tabHost.addTab(TaiKhoanSpec);
        tabHost.addTab(ThongKeSpec);
        tabHost.addTab(CaiDatSpec);

    }


    private void thongbao(String nd){
        Toast.makeText(getApplicationContext(),nd,Toast.LENGTH_SHORT).show();
    }

}