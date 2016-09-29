package com.example.suphuy.assigmment_huyphpk00628.Activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.Fragment.Chi.Fragment_Chi;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.Receiver.ReceiverNotification;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */

@SuppressWarnings("deprecation")
public class ControlThuChiActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonThu,buttonChi,buttonChuyenKhoan;
    LinearLayout layoutmenucontrol,lnSelectMenuControl;
    Animation animationthoat,animation,animationsidedown;
    FragmentManager fragmentManager;
    FrameLayout fragmentControlThuChi,fragmentControlThuChiRight,fragmenttControlThuChiInRight;
    FrameLayout  fragmentThuChiTab1;
    float initialX;
    private  int columnIndex, position = 0;
    private static TextView set_date, set_time;
    private static final int Date_id = 0;
    private static final int Time_id = 1;
    Context ct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_thu_chi);
        anhxa();

        Intent intent = new Intent(this, ReceiverNotification.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplication(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (10000), pendingIntent);
        lnSelectMenuControl.setOnClickListener(this);
        buttonChi.setOnClickListener(this);
        buttonThu.setOnClickListener(this);
        fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentThuChiTab1,
                new Fragment_Chi(getParent(),fragmentManager,fragmentControlThuChi,
                        fragmentControlThuChiRight,fragmenttControlThuChiInRight)).commit();
    }

    private void anhxa(){

        fragmentControlThuChi=(FrameLayout)findViewById(R.id.fragmentControlThuChi);
        fragmentControlThuChiRight=(FrameLayout)findViewById(R.id.fragmentControlThuChiRight);
        fragmenttControlThuChiInRight=(FrameLayout)findViewById(R.id.fragmenttControlThuChiInRight);
        buttonChi=(Button)findViewById(R.id.buttonChi);
        buttonThu=(Button)findViewById(R.id.buttonThu) ;
        lnSelectMenuControl=(LinearLayout)findViewById(R.id.lnSelectMenuControl);
        layoutmenucontrol=(LinearLayout)findViewById(R.id.layoutmenucontrol);
        animationthoat = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_out);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sidedown);
        fragmentControlThuChi.setVisibility(View.GONE);
        fragmentControlThuChiRight.setVisibility(View.GONE);
        fragmenttControlThuChiInRight.setVisibility(View.GONE);
        layoutmenucontrol.setVisibility(View.GONE);
    }
    private void closeControl() {
        if (layoutmenucontrol.getVisibility() == (View.GONE)) {
            layoutmenucontrol.setVisibility(View.VISIBLE);
            layoutmenucontrol.startAnimation(animation);
        } else {
            layoutmenucontrol.startAnimation(animationthoat);
            layoutmenucontrol.setVisibility(View.GONE);
        }
    }
    @Override
    public void onClick(View view) {
        if(view==buttonChi){
            {
                try{
                    layoutmenucontrol.startAnimation(animationthoat);
                    layoutmenucontrol.setVisibility(View.GONE);
                    fragmentManager.beginTransaction().replace(R.id.fragmentThuChiTab1,
                            new Fragment_Chi(getParent(), fragmentManager,fragmentControlThuChi,
                                    fragmentControlThuChiRight,fragmenttControlThuChiInRight)).commit();
                    fragmentThuChiTab1.startAnimation(animation);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"huy",Toast.LENGTH_SHORT).show();
                }
            }
        }else
            if(view==buttonThu){
                {

                    layoutmenucontrol.startAnimation(animationthoat);
                    layoutmenucontrol.setVisibility(View.GONE);
                }
            }else if(view==lnSelectMenuControl){
                closeControl();
            }
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if(fragmenttControlThuChiInRight.getVisibility()==View.VISIBLE){
                Toast.makeText(getApplicationContext(),"nó muốn thoát từ 3",Toast.LENGTH_SHORT).show();
                fragmenttControlThuChiInRight.startAnimation(animationthoat);
                fragmenttControlThuChiInRight.setVisibility(View.GONE);
            }else
            if(fragmentControlThuChiRight.getVisibility()==View.VISIBLE){
                Toast.makeText(getApplicationContext(),"nó muốn thoát từ 2",Toast.LENGTH_SHORT).show();
                fragmentControlThuChiRight.startAnimation(animationthoat);
                fragmentControlThuChiRight.setVisibility(View.GONE);
            }else
            if(fragmentControlThuChi.getVisibility()==View.VISIBLE){
                Toast.makeText(getApplicationContext(),"nó muốn thoát từ 1",Toast.LENGTH_SHORT).show();
                fragmentControlThuChi.startAnimation(animationthoat);
                fragmentControlThuChi.setVisibility(View.GONE);
            }else {
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

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }



}