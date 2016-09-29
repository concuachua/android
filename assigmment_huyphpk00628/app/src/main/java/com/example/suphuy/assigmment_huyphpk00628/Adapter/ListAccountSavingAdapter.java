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
import com.example.suphuy.assigmment_huyphpk00628.model.SoTietKiem;

import java.util.List;

/**
 * Created by SUPHUY on 9/24/2016.
 */
public class ListAccountSavingAdapter extends ArrayAdapter<SoTietKiem> {
 List<SoTietKiem> mylist ;

    public ListAccountSavingAdapter(Context context, int resource, List<SoTietKiem> objects) {
        super(context, resource, objects);
        mylist=objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view=convertView;
        if(convertView==null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.item_accountsaving, null);
        }
        SoTietKiem soTietKiem=mylist.get(position);
        TextView txtAccountName,txtAmount ,txtT,txtExchangeAmount;
        ImageView imgEditAccount;
        txtAccountName=(TextView)view.findViewById(R.id.txtAccountName);
        txtT=(TextView)view.findViewById(R.id.txtT);
        txtAmount=(TextView)view.findViewById(R.id.txtAmount);
        txtExchangeAmount=(TextView)view.findViewById(R.id.txtExchangeAmount);
        imgEditAccount =(ImageView)view.findViewById(R.id.imgEditAccount);
        txtAccountName.setText(soTietKiem.getTenSoTK());
        txtAmount.setText(soTietKiem.getSoTienBanDau());
        txtExchangeAmount.setText(soTietKiem.getStringNgayHetHan());
        txtT.setText(String.valueOf(soTietKiem.getLaiXuat()*100+"%"));
        imgEditAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"huy vị trí"+position,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }


}
