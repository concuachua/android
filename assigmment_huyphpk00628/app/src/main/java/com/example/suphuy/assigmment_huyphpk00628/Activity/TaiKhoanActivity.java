package com.example.suphuy.assigmment_huyphpk00628.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.Adapter.Page_Adapter;
import com.example.suphuy.assigmment_huyphpk00628.R;

@SuppressWarnings("deprecation")
public class TaiKhoanActivity extends AppCompatActivity implements View.OnClickListener{
    ViewPager pager;
    TabLayout tabLayout;
    ImageView imgAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_tai_khoan);
//        getSupportActionBar().hide();
        AddPager();
//       imgAdd.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
//    private void anhxa(){
//        imgAdd=(ImageView)findViewById(R.id.imgAdd);
//    }
    private void AddPager(){
        try{
            pager = (ViewPager) findViewById(R.id.view_pager);
            tabLayout = (TabLayout) findViewById(R.id.tab_layout);
            FragmentManager manager = getSupportFragmentManager();
            Page_Adapter adapter = new Page_Adapter(manager);
            pager.setAdapter(adapter);
            tabLayout.setupWithViewPager(pager);
            pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.setTabsFromPagerAdapter(adapter);
        }catch (Exception e){
            Toast.makeText(getParent(),"lỗi"+e.getMessage().toString(),Toast.LENGTH_SHORT).show();
        }
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
