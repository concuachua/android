package com.example.suphuy.assigmment_huyphpk00628.Receiver;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.suphuy.assigmment_huyphpk00628.R;

public class noidungthongbaoActivity extends AppCompatActivity {
    TextView txtThongBao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.noiungthongbao);
        txtThongBao = (TextView) findViewById(R.id.txtThongBao);
        int requestCode = getIntent().getExtras().getInt("requestCode");
        DongNotification(requestCode);
        txtThongBao.setText( requestCode + "\n nội dung thông báo nằm ở đây ");

    }

    protected void DongNotification(int notiId) {
        NotificationManager notiMa = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notiMa.cancel(notiId);
    }
}
