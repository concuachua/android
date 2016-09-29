package com.example.suphuy.assigmment_huyphpk00628.Fragment.Chi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.R;

/**
 * Created by SUPHUY on 9/20/2016.
 */
public class Fragment_EditText extends Fragment  implements View.OnClickListener{
    LinearLayout layerAddChi;
    TextView txteditMoney,txtDone,txtCancel;
    EditText EditTextDescription;
    View view;
   FrameLayout  fragmentControlThuChi;
    Animation animationthoat ,animation;
    LinearLayout  LinearLayoutChiMain;
    Boolean close=true;
    TextView txt;
    String text;
    public Fragment_EditText(FrameLayout fm,TextView txt,String t) {
        fragmentControlThuChi=fm;
        this.txt=txt;
        this.text=t;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_edit_text, container, false);

        anhxa();
        EditTextDescription.setText(text+" ");
        txtCancel.setOnClickListener(this);
        txtDone.setOnClickListener(this);
        return view ;

    }

    @Override
    public void onClick(View view) {
        if(view==txtCancel ){
            fragmentControlThuChi.startAnimation(animation);
            fragmentControlThuChi.setVisibility(View.GONE);
        }else
            if(view==txtDone ){
                txt.setText(EditTextDescription.getText().toString());
                fragmentControlThuChi.startAnimation(animation);
                fragmentControlThuChi.setVisibility(View.GONE);
            }
    }
    private void anhxa(){
        txtDone =(TextView)view.findViewById(R.id.txtDone);
        txtCancel=(TextView)view.findViewById(R.id.txtCancel);
        layerAddChi=(LinearLayout)view.findViewById(R.id.layerAddChi);
        EditTextDescription=(EditText) this.view.findViewById(R.id.EditTextDescription);
        animationthoat = AnimationUtils.loadAnimation(getContext(), R.anim.left_in);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.right_out);
    }
    private void thongbao(String nd){
        Toast.makeText(getContext(),nd,Toast.LENGTH_SHORT).show();
    }
}