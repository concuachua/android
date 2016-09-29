package com.example.suphuy.assigmment_huyphpk00628.Custom;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.R;

/**
 * Created by SUPHUY on 9/29/2016.
 */
public class DiaLog_Date  extends Dialog implements DatePicker.OnDateChangedListener{
    TextView tvDate,tvTime;
    DatePicker datePicker;
    TimePicker timePicker;
    Button buttonoke;
    public DiaLog_Date(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_date_time);
        setTitle("Set Date");
        tvDate=(TextView)findViewById(R.id.tvDate);
        tvTime=(TextView)findViewById(R.id.tvTime);
        datePicker=(DatePicker)findViewById(R.id.datePickertab1);
        timePicker=(TimePicker)findViewById(R.id.timePickertab2);
        buttonoke=(Button)findViewById(R.id.buttonoke);
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.GONE);
                datePicker.setVisibility(View.VISIBLE);
            }
        });
        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.VISIBLE);
                datePicker.setVisibility(View.GONE);
            }
        });

        buttonoke.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"huy",Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
        Toast.makeText(getContext(),i+"fdg",Toast.LENGTH_LONG).show();
    }
}
