package com.example.suphuy.assigmment_huyphpk00628.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.TK;

import java.util.List;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class AccountAdapter extends ArrayAdapter<TK> {
    List<TK> mylist;
    public AccountAdapter(Context context, int resource, List<TK> objects) {
        super(context, resource, objects);
        mylist=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.item_account, null);
        }
        TK tk =mylist.get(position);

        return view;

    }
}
