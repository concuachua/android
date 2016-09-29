package com.example.suphuy.assigmment_huyphpk00628.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.TK;

import java.util.List;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class ListAccountAdapter extends ArrayAdapter<TK>  {
    List<TK> mylist;
    public ListAccountAdapter(Context context, int resource, List<TK> objects) {
        super(context, resource, objects);
        mylist=objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view=convertView;
        LayoutInflater inflater=LayoutInflater.from(getContext());
        view= inflater.inflate(R.layout.item_account_money,null);
        TK tk=mylist.get(position);
        TextView txtAmount ,txtExchangeAmount;
        ImageView imgEditAccount,imageview_account;
        txtAmount=(TextView)view.findViewById(R.id.txtAmount);
        txtExchangeAmount=(TextView)view.findViewById(R.id.txtExchangeAmount);
        imgEditAccount =(ImageView)view.findViewById(R.id.imgEditAccount);
        imageview_account =(ImageView)view.findViewById(R.id.imageview_account);
        txtAmount.setText(tk.getTenTK());
        txtExchangeAmount.setText(tk.getSoTien());
        imgEditAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"huy vị trí"+position,Toast.LENGTH_SHORT).show();
            }
        });
        return view;

    }


}
