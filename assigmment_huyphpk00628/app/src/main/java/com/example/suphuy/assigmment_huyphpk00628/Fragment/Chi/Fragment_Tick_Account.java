package com.example.suphuy.assigmment_huyphpk00628.Fragment.Chi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.Adapter.ListAccountTickedAdapter;
import com.example.suphuy.assigmment_huyphpk00628.Database.SQLite;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.TK;

import java.util.ArrayList;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class Fragment_Tick_Account extends Fragment {
    ListView listViewAccount;
    View view;
    ArrayList<TK> ar;
    ListAccountTickedAdapter adapterAccountMoney;
    FrameLayout fragmentControlThuChi;
    ImageView btnback;
    String po;
    TextView txtAccountName;
   public Fragment_Tick_Account(FrameLayout fl, TextView txt,String po){
        this.fragmentControlThuChi=fl;
       this.txtAccountName=txt;
       this.po=po;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.fragment_tick_account, container, false);
        listViewAccount=(ListView)view.findViewById(R.id.listViewTickAccount);
       ar=new ArrayList<TK>();
        try{

            SQLite database=new SQLite(getContext());
//            database.addTK(new TK("Tài khoản ngân 4hàng","ví","4000",""));
//            database.addTK(new TK("Tài khoản ngân 2hàng","ví","4000",""));
//            database.addTK(new TK("Tài khoản ngân hàng","ví","4000",""));
//            database.addTK(new TK("Tài khoản ngân 44hàng","ví","4000",""));
//            database.addTK(new TK("Tài khoản ngân1 hàng","ví","4000",""));
//            database.addTK(new TK("Tài khoản ngân3 hàng","ví","4000",""));

            ar=database.GetAllTK();
            SetList();
            btnback=(ImageView)view.findViewById(R.id.btnBack);
            btnback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    fragmentControlThuChi.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.right_out));
                    fragmentControlThuChi.setVisibility(View.GONE);
                }
            });
        }
        catch (Exception e){
            thongbao("lỗi"+e.getMessage().toString());
            System.out.println("=========================>"+e.getMessage().toString());
        }
                return view;
    }




    private  void SetList(){
        adapterAccountMoney=new ListAccountTickedAdapter(getContext(),R.layout.item_account_money_ticked,ar,po);
        listViewAccount.setAdapter(adapterAccountMoney);
        listViewAccount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txtAccountName.setText(ar.get(i).getTenTK());
                view.findViewById(R.id.imgTickedAccount).setVisibility(View.VISIBLE);
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.phongto));
                fragmentControlThuChi.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.right_out));
                fragmentControlThuChi.setVisibility(View.GONE);

            }
        });
    }
    private void thongbao(String nd){
        Toast.makeText(getContext(),nd,Toast.LENGTH_LONG).show();
    }



}
