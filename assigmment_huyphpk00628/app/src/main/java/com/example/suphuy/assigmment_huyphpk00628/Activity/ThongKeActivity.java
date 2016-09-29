package com.example.suphuy.assigmment_huyphpk00628.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.example.suphuy.assigmment_huyphpk00628.R;

public class ThongKeActivity extends AppCompatActivity {

    private static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_thong_ke);
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent intent = new Intent(getApplicationContext(), Login_Design_Activity.class);
            startActivity(intent);

            // Tao su kien ket thuc app
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startActivity(startMain);
            finish();

            return true;
        } else if ((keyCode == KeyEvent.KEYCODE_MENU)) {

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
