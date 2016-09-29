package com.example.suphuy.assigmment_huyphpk00628.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.TK;

import java.util.List;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class ListAccountTickedAdapter extends ArrayAdapter<TK>  {
    List<TK> mylist;
    int r;
    String po;
    public ListAccountTickedAdapter(Context context, int resource, List<TK> objects,String po) {
        super(context, resource, objects);
        mylist=objects;
        this.r=resource;
        this.po=po;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view=convertView;
        if(convertView==null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(r, null);
        }
        TK tk=mylist.get(position);
        TextView txtAmount ,txtExchangeAmount;
        final ImageView imgTickedAccount,imageview_account;
        txtAmount=(TextView)view.findViewById(R.id.txtAmount);
        txtExchangeAmount=(TextView)view.findViewById(R.id.txtExchangeAmount);
        imgTickedAccount =(ImageView)view.findViewById(R.id.imgTickedAccount);
        imageview_account =(ImageView)view.findViewById(R.id.imageview_account);
        txtAmount.setText(tk.getTenTK());
        txtExchangeAmount.setText(tk.getSoTien());
        if(tk.getTenTK().equals(this.po)){
            imgTickedAccount.setVisibility(View.VISIBLE);
        }else
        imgTickedAccount.setVisibility(View.GONE);

        return view;


    }


}
