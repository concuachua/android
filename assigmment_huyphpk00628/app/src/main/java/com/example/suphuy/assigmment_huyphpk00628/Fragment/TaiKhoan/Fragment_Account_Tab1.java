package com.example.suphuy.assigmment_huyphpk00628.Fragment.TaiKhoan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.Adapter.ListAccountAdapter;
import com.example.suphuy.assigmment_huyphpk00628.Database.SQLite;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.TK;

import java.util.ArrayList;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class Fragment_Account_Tab1 extends Fragment {
    ListView listViewAccount;
    View view;
    ListAccountAdapter adapterAccountMoney;
    SearchView shuyhuy;
   public  Fragment_Account_Tab1(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.fragment_account_tab1, container, false);
        listViewAccount=(ListView)view.findViewById(R.id.listViewAccount);
        ArrayList<TK> ar=new ArrayList<TK>();
        try{

            SQLite database=new SQLite(getContext());
//            database.addTK(new TK("Tài khoản ngân 4hàng","ví","4000",""));
//            database.addTK(new TK("Tài khoản ngân 2hàng","ví","4000",""));
//            database.addTK(new TK("Tài khoản ngân 3hàng","ví","4000",""));
//            database.addTK(new TK("Tài khoản ngân 44hàng","ví","4000",""));
//            database.addTK(new TK("Tài khoản ngân1 6hàng","ví","4000",""));
//            database.addTK(new TK("Tài khoản ngân3 hàng","ví","4000",""));

            ar=database.GetAllTK();
             adapterAccountMoney=new ListAccountAdapter(getContext(),R.layout.item_account_money,ar);
            listViewAccount.setAdapter(adapterAccountMoney);
        }
        catch (Exception e){
            thongbao("lỗi"+e.getMessage().toString());
            System.out.println("=========================>"+e.getMessage().toString());
        }
                return view;
    }
    private void thongbao(String nd){

        Toast.makeText(getContext(),nd,Toast.LENGTH_LONG).show();
    }


}
