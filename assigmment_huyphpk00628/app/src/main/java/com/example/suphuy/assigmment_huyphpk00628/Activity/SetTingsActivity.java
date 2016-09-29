package com.example.suphuy.assigmment_huyphpk00628.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.Fragment.SetTing.Fragment_SettingMore;
import com.example.suphuy.assigmment_huyphpk00628.R;

public class SetTingsActivity extends AppCompatActivity implements View.OnClickListener{
    private static FragmentManager fragmentManager;
    LinearLayout lnSettingMore,LinearLayoutMainSetTing;
    FrameLayout frameLayoutSetTingMore,fragmentContentSettingMoreRight,fragmentSettingInRight;
    Animation animationthoat,animation,animation01 ,animationright_out,animationleft_in;
    Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_setting);

        anhxa();

        lnSettingMore.setOnClickListener(this);
    }
    private void anhxa(){
        activity=getParent();
        fragmentSettingInRight=(FrameLayout)findViewById(R.id.fragmentSettingInRight);
        fragmentContentSettingMoreRight=(FrameLayout)findViewById(R.id.fragmentContentSettingMoreRight);
        frameLayoutSetTingMore=(FrameLayout)findViewById(R.id.fragmentContentSettingMore);
        LinearLayoutMainSetTing=(LinearLayout)findViewById(R.id.LinearLayoutMainSetTing);
        fragmentManager = getSupportFragmentManager();
        lnSettingMore=(LinearLayout)findViewById(R.id.lnSettingMore);
        animationthoat = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_out);
        animationleft_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_in);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_in);
        animation01 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.text01);
        animationright_out= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_out);
        fragmentSettingInRight.setVisibility(View.GONE);
        fragmentContentSettingMoreRight.setVisibility(View.GONE);
        frameLayoutSetTingMore.setVisibility(View.GONE);

    }

    @Override
    public void onClick(View view) {
        if(view==lnSettingMore){
            try{
                frameLayoutSetTingMore.setVisibility(View.VISIBLE);
                fragmentManager.beginTransaction().replace(R.id.fragmentContentSettingMore,
                        new Fragment_SettingMore(fragmentManager,frameLayoutSetTingMore,fragmentContentSettingMoreRight,fragmentSettingInRight)).commit();
                LinearLayoutMainSetTing.startAnimation(animationthoat);
                frameLayoutSetTingMore.startAnimation(animation);
            }catch(Exception e){
                Toast.makeText(getApplicationContext(),
                "lỗi rồi má"+e.getMessage().toString(),Toast.LENGTH_SHORT).show();
            }

        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if(fragmentSettingInRight.getVisibility()==View.VISIBLE){
                Toast.makeText(getApplicationContext(),"nó muốn thoát từ 3",Toast.LENGTH_SHORT).show();
                fragmentSettingInRight.startAnimation(animationright_out);
                fragmentSettingInRight.setVisibility(View.GONE);
            }else
            if(fragmentContentSettingMoreRight.getVisibility()==View.VISIBLE){
                Toast.makeText(getApplicationContext(),"nó muốn thoát từ 2",Toast.LENGTH_SHORT).show();
                fragmentContentSettingMoreRight.startAnimation(animationright_out);
                fragmentContentSettingMoreRight.setVisibility(View.GONE);
            }else
            if(frameLayoutSetTingMore.getVisibility()==View.VISIBLE){
                Toast.makeText(getApplicationContext(),"nó muốn thoát từ 1",Toast.LENGTH_SHORT).show();
                frameLayoutSetTingMore.startAnimation(animationright_out);
                frameLayoutSetTingMore.setVisibility(View.GONE);
            }else{
                Intent intent = new Intent(getApplicationContext(), Login_Design_Activity.class);
                startActivity(intent);

                // Tao su kien ket thuc app
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(startMain);
                finish();

            }

            return true;
        } else if ((keyCode == KeyEvent.KEYCODE_MENU)) {
            thongbao("Bạn vừa bấm nút MENU!");
            return true;
        } else if ((keyCode == KeyEvent.KEYCODE_VOLUME_UP)) {
            thongbao("Bạn vừa bấm nút VOLUME+");
            return true;
        } else if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)) {
            thongbao("Bạn vừa bấm nút VOLUME-");
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void thongbao(String nd){
        Toast.makeText(getApplicationContext(),nd,Toast.LENGTH_LONG).show();
    }
}
