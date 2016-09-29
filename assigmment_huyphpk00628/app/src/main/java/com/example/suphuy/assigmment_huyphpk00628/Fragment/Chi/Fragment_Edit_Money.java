package com.example.suphuy.assigmment_huyphpk00628.Fragment.Chi;

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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.R;

import java.util.ArrayList;

/**
 * Created by SUPHUY on 9/20/2016.
 */
public class Fragment_Edit_Money  extends Fragment implements View.OnClickListener {
    private static FragmentManager fragmentManager;
    View view;
    Animation animationthoat ,animation;
    ImageView imageViewBack;
    FrameLayout fragmentControlThuChi;
    int nho=0;
   static Button btnKey1,btnKey2,btnKey3,btnKey4,btnKey5,btnKey6,btnKey7,btnKey9,
            btnKey8,btnKeyDivide,btnKeyC,btnKeyEqual,btnKey0,btnKeyMulti,
            btnKeyNegative,btnKeyAdd,btnKeyMinus,btnKey000,btnKeyD;
    ImageButton btnKeyBack;
   TextView textViewMoney,txteditMoney;
    String money="",moneytext="",Do="Đồng";


    public Fragment_Edit_Money(FrameLayout fragmentControlThuChi,TextView txteditMoney) {
       this.fragmentControlThuChi=fragmentControlThuChi;
        // Required empty public constructor
       this.txteditMoney=txteditMoney;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_edit_money, container, false);
        anhxa();
        btnKey1.setOnClickListener(this);
        btnKey2.setOnClickListener(this);
        btnKey3.setOnClickListener(this);
        btnKey4.setOnClickListener(this);
        btnKey5.setOnClickListener(this);
        btnKey6.setOnClickListener(this);
        btnKey7.setOnClickListener(this);
        btnKey9.setOnClickListener(this);
        btnKey8.setOnClickListener(this);
        btnKeyDivide.setOnClickListener(this);
        btnKeyC.setOnClickListener(this);
        btnKeyBack.setOnClickListener(this);
        btnKeyEqual.setOnClickListener(this);
        btnKey0.setOnClickListener(this);
        btnKeyNegative.setOnClickListener(this);
        btnKeyAdd.setOnClickListener(this);
        btnKeyMinus.setOnClickListener(this);
        btnKey000.setOnClickListener(this);
        btnKeyD.setOnClickListener(this);
        imageViewBack.setOnClickListener(this);
        btnKeyMulti.setOnClickListener(this);
        return view ;

    }

    @Override
    public void onClick(View view) {
        String t="-";
        if(money.length()>0)
   t=  money.substring(money.length()-1,money.length());
        switch (view.getId()) {
            case R.id.btnKey0:{
                money=money+"0";
            } break;
            case R.id.btnKey1:{
                money=money+"1";
            } break;
            case R.id.btnKey2:{
                money=money+"2";
            } break;
            case R.id.btnKey3:{
                money=money+"3";
            } break;
            case R.id.btnKey4:{
                money=money+"4";
            } break;
            case R.id.btnKey5:{
                money=money+"5";
            } break; case R.id.btnKey6:{
                money=money+"6";
            } break; case R.id.btnKey7:{
                money=money+"7";
            } break; case R.id.btnKey8:{
                money=money+"8";
            } break; case R.id.btnKey9:{
                money=money+"9";
            } break; case R.id.btnKey000:{
                money=money+"000";
            } break; case R.id.btnKeyC:{
                money="";
            } break; case R.id.btnKeyD:{
                if(!t.equals("+") && !t.equals("/")&& !t.equals("-")&& !t.equals("*")&& !t.equals("."))
                money=money+".";
                else
                    thongbao("bạn chưa nhập đúng");
            } break; case R.id.btnKeyAdd:{
                if(!t.equals("+") && !t.equals("/")&& !t.equals("-")&& !t.equals("*")&& !t.equals("."))
                money=money+"+";
                else
                    thongbao("bạn chưa nhập đúng");
            } break;
            case R.id.btnKeyMinus:{
                if(!t.equals("+") && !t.equals("/")&& !t.equals("-")&& !t.equals("*")&& !t.equals("."))
                money=money+"-";
                else
                    thongbao("bạn chưa nhập đúng");
            } break;
            case R.id.btnKeyDivide:{
                if(!t.equals("+") && !t.equals("/")&& !t.equals("-")&& !t.equals("*")&& !t.equals("."))
                money=money+"/";
                else
                    thongbao("bạn chưa nhập đúng");
            } break;
            case R.id.btnKeyBack:{
                money=money.substring(0,money.length()-1);

            } break;
            case R.id.btnKeyEqual:{
                this.view.startAnimation(animationthoat);
                this.view.setVisibility(View.GONE);
                try{
                    txteditMoney.setText(Tinh(KhuNC(LayDuLieu())));
                }catch (Exception e){
                    Toast.makeText(getContext(),e.getMessage().toString(),Toast.LENGTH_LONG).show();
                }


            } break;
            case R.id.btnKeyMulti:{
                money+="*";
            } break;
            case R.id.btnKeyNegative:{
                money=Tinh(KhuNC(LayDuLieu()));
                textViewMoney.setText(money);
            } break;
            case R.id.imageViewBack:{
                fragmentControlThuChi.startAnimation(animationthoat);
                fragmentControlThuChi.setVisibility(View.GONE);
            } break;
        }

        textViewMoney.setText(money);
        
    }
    private void anhxa(){
        imageViewBack=(ImageView)this.view.findViewById(R.id.imageViewBack);
        btnKey1=(Button)this.view.findViewById(R.id.btnKey1);
        btnKey2=(Button)this.view.findViewById(R.id.btnKey2);
        btnKey3=(Button)this.view.findViewById(R.id.btnKey3);
        btnKey4=(Button)this.view.findViewById(R.id.btnKey4);
        btnKey5=(Button)this.view.findViewById(R.id.btnKey5);
        btnKey6=(Button)this.view.findViewById(R.id.btnKey6);
        btnKey7=(Button)this.view.findViewById(R.id.btnKey7);
        btnKey8=(Button)this.view.findViewById(R.id.btnKey8);
        btnKey9=(Button)this.view.findViewById(R.id.btnKey9);
        btnKey0=(Button)this.view.findViewById(R.id.btnKey0);
        btnKey000=(Button)this.view.findViewById(R.id.btnKey000);
        btnKeyC=(Button)this.view.findViewById(R.id.btnKeyC);
        btnKeyD=(Button)this.view.findViewById(R.id.btnKeyD);
        btnKeyDivide=(Button)this.view.findViewById(R.id.btnKeyDivide);
        btnKeyAdd=(Button)this.view.findViewById(R.id.btnKeyAdd);
        btnKeyNegative=(Button)this.view.findViewById(R.id.btnKeyNegative);
        btnKeyMinus=(Button)this.view.findViewById(R.id.btnKeyMinus);
        btnKeyEqual=(Button)this.view.findViewById(R.id.btnKeyEqual);
        btnKeyBack=(ImageButton)this.view.findViewById(R.id.btnKeyBack);
        textViewMoney=(TextView)view.findViewById(R.id.textViewMoney);
        animationthoat = AnimationUtils.loadAnimation(getContext(), R.anim.right_out);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.left_in);
        btnKeyMulti=(Button)this.view.findViewById(R.id.btnKeyMulti);
    }
    private ArrayList<String> LayDuLieu(){
        ArrayList<String> list=new ArrayList<String>();
        int vta=0,vtb=0,ram=0,kq=0;
        int soa=0,sob=0;
        char[] ar =money.toCharArray();
            for(int i=0;i<ar.length;i++){
                if(ar[i]=='+'||ar[i]=='-'||ar[i]=='*'||ar[i]=='/'||i==ar.length-1){
                    ram++;
                    if(i==ar.length-1){
                        vtb = i+1 ;
                    }else
                        vtb = i ;
                            sob = Integer.valueOf(money.substring(vta, vtb));
                    list.add(String.valueOf(sob));
                    if(ar[i]=='+'){
                        list.add(String.valueOf("+"));
                    }else
                    if(ar[i]=='-'){
                        list.add(String.valueOf("-"));
                    }else
                    if(ar[i]=='*'){
                        list.add(String.valueOf("*"));
                    }else
                    if(ar[i]=='/'){
                        list.add(String.valueOf("/"));
                    }
                       vta = vtb + 1;
                }
            }
        return  list;
    }
    private ArrayList<String> LayDuLieuht(){
        ArrayList<String> list=new ArrayList<String>();
        int vta=0,vtb=0,ram=0,kq=0;
        int soa=0,sob=0;
        char[] ar =money.toCharArray();
        for(int i=0;i<ar.length;i++){
            if(ar[i]=='+'||ar[i]=='-'||ar[i]=='*'||ar[i]=='/'||i==ar.length-1){
                ram++;

                    vtb = i ;
                sob = Integer.valueOf(money.substring(vta, vtb));
                list.add(String.valueOf(sob));
                if(ar[i]=='+'){
                    list.add(String.valueOf("+"));
                }else
                if(ar[i]=='-'){
                    list.add(String.valueOf("-"));
                }else
                if(ar[i]=='*'){
                    list.add(String.valueOf("*"));
                }else
                if(ar[i]=='/'){
                    list.add(String.valueOf("/"));
                }
                vta = vtb + 1;
            }
        }
        return  list;
    }
    private String hienthi(ArrayList<String> a){
        String ht="";
        try{
            for (int i=0;i<a.size();i++){
                if(!a.get(i).equals("+")&&!a.get(i).equals("-")&&!a.get(i).equals("*")&&!a.get(i).equals("/"))
                    ht+=a.get(i)+"000";
                else ht+=a.get(i);
            }
        }catch (Exception e){

        }

        return  ht;
    }
    private ArrayList<String> KhuNC(ArrayList<String> arl){
        int a,b;
        ArrayList<String> arl1=arl;
        ArrayList<String> q = new ArrayList<String>();
        for(int i=0;i<arl.size();i++){
            if(arl.get(i)=="*"||arl.get(i)=="/"){
                a=Integer.valueOf(arl.get(i-1));
                b=Integer.valueOf(arl.get(i+1));
                if(arl.get(i)=="*"){
                    arl.set(i+1,String.valueOf((a*b)));
                }else
                    arl.set(i+1,String.valueOf((a/b)));
                arl.set(i,"h");
                arl.set(i-1,"h");
            }
        }
        String kq2="";
        for (int i=0;i<arl.size();i++){
            if(!arl1.get(i).equals("h"))
            q.add(arl.get(i));
        }
        return  q;
    }
    private String Tinh(ArrayList<String> arl){
        int a,b;
        ArrayList<String> arl1=arl;
        for(int i=0;i<arl.size();i++){
            if(arl.get(i)=="+"||arl.get(i)=="-"){
                a=Integer.valueOf(arl.get(i-1));
                b=Integer.valueOf(arl.get(i+1));
                if(arl.get(i)=="+"){
                    arl1.set(i+1,String.valueOf((a+b)));
                }else
                    arl1.set(i+1,String.valueOf((a-b)));
                arl1.set(i,"h");
                arl1.set(i-1,"h");
            }
        }

        return  arl1.get(arl1.size()-1);
    }
    private void thongbao(String nd){
        Toast.makeText(getContext(),nd,Toast.LENGTH_LONG).show();

    }
}