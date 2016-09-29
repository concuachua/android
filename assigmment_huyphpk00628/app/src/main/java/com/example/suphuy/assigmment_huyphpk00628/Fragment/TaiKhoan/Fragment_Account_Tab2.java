package com.example.suphuy.assigmment_huyphpk00628.Fragment.TaiKhoan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.Adapter.ListAccountSavingAdapter;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.SoTietKiem;
import com.example.suphuy.assigmment_huyphpk00628.Database.SQLite;

import java.util.ArrayList;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class Fragment_Account_Tab2 extends Fragment {
    ListView lv;
    ArrayList<SoTietKiem> ar;
    View view;
    ListAccountSavingAdapter accountSavingAdapter;
   public  Fragment_Account_Tab2(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_account_tab2, container, false);
        anhxa();
        try {
            SQLite database=new SQLite(getContext());

            ar=new ArrayList<SoTietKiem>();
           SoTietKiem s= new SoTietKiem("stk 1","agribank","2999999d","2016-12-12","2018-12-12",0.2,"vi1","chưa có","2018-12-12");
//            database.addSoTietKiem(s);
//            database.addSoTietKiem(new SoTietKiem("stk 1","agribank","65434345","2016-12-12","2018-12-12",0.2,"vi1","chưa có","2018-12-12"));
//            database.addSoTietKiem(new SoTietKiem("stk 1","agribank","2999999d","2016-12-12","2018-12-12",0.2,"vi1","chưa có","2018-12-12"));
//            database.addSoTietKiem(new SoTietKiem("stk 1","agribank","2999999d","2016-12-12","2018-12-12",0.2,"vi1","chưa có","2018-12-12"));
            ar=database.GetAllSoTietKiem();
            accountSavingAdapter=new ListAccountSavingAdapter(getContext(),R.layout.item_accountsaving,ar);
            lv.setAdapter(accountSavingAdapter);
        }catch (Exception e){
            thongbao(e.getMessage().toString());

        }

        return view;
    }
        private void anhxa(){
        lv=(ListView)view.findViewById(R.id.listViewAccountSaving);
    }
    private void thongbao(String nd){

        Toast.makeText(getContext(),nd,Toast.LENGTH_LONG).show();
    }
}
