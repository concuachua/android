package com.example.suphuy.assigmment_huyphpk00628.Fragment.Chi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.Adapter.ExpandableListAdapter;
import com.example.suphuy.assigmment_huyphpk00628.Database.SQLite;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.MucChiCha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by SUPHUY on 9/19/2016.
 */

public class Fragment_Category extends Fragment implements View.OnClickListener {
    ImageView editChuThich;
    ImageView btnBack,imageViewAdd;
    Animation animationthoat ,animation;
    FrameLayout fragmentControlThuChi,fragmentControlThuChiRight;
    FragmentManager fragmentManager;
    View view;
    private static ExpandableListView expandableListView;
    private static ExpandableListAdapter adapter;
    SQLite database;
    ArrayList<ArrayList<String>> MapList;
    ArrayList<Integer > idgroup;
    ArrayList<String> listchild,listGroup;
    ArrayList<MucChiCha> listmuccha;
    TextView text;
    public Fragment_Category(FragmentManager fragmentManager,FrameLayout fl, FrameLayout flRight,TextView t) {
        fragmentControlThuChi=fl;
        this.fragmentManager=fragmentManager;
        fragmentControlThuChiRight=flRight;
        this.text=t;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_category, container, false);
        expandableListView = (ExpandableListView) view.findViewById(R.id.simple_expandable_listview);
        // Setting group indicator null for custom indicator
        expandableListView.setGroupIndicator(null);
        database=new SQLite(getContext());
        idgroup=new ArrayList<Integer>();
        listchild=new ArrayList<String>();
        listGroup=new ArrayList<String>();
        MapList=new ArrayList<ArrayList<String>>();
//      database.addMucChiCha(new MucChiCha("ăn uống","chưa có"));
//        database.addMucChiCha(new MucChiCha("sinh hoạt","chưa có"));
//        database.addMucChiCha(new MucChiCha("đi lại","chưa có"));
//        database.addMucChiCha(new MucChiCha("vui chơi","chưa có"));
//        database.addMucChiCon(new MucChiCon("kẹo",1,""));
//        database.addMucChiCon(new MucChiCon("bánh",1,""));
//        database.addMucChiCon(new MucChiCon("mức",1,""));
//        database.addMucChiCon(new MucChiCon("sữa",1,""));
//        database.addMucChiCon(new MucChiCon("rau",1,""));
//        database.addMucChiCon(new MucChiCon("má",1,""));
//        database.addMucChiCon(new MucChiCon("tiền điện",2,""));
//        database.addMucChiCon(new MucChiCon("tiền phòng",2,""));
//        database.addMucChiCon(new MucChiCon("tiền nước",2,""));
//        database.addMucChiCon(new MucChiCon("xe bus",3,""));
//        database.addMucChiCon(new MucChiCon("xăng",3,""));
//        database.addMucChiCon(new MucChiCon("đi công viên",4,""));
//        database.addMucChiCon(new MucChiCon("xem phim",4,""));
        listmuccha=database.GetAllMucChiCha();
        listGroup=database.GetAllTenMucChiCha();
        idgroup=database.GetAllIDMucChiCha();
        try{
            listchild=database.GetAllTenMucChiConInCha(database.GetMucChiCha(1).getID());
            thongbao(listGroup.get(1)+" huy"+listchild.get(1));
        }catch (Exception e){
            thongbao(e.getMessage().toString());

        }

        setItems();
        setListener();
        anhxa();
        btnBack.setOnClickListener(this);
        imageViewAdd.setOnClickListener(this);
        return view ;
    }
    void setItems() {
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        for(int i=0;i<listGroup.size();i++){
            hashMap.put(listGroup.get(i), database.GetAllTenMucChiConInCha(idgroup.get(i)));
        }
        adapter = new ExpandableListAdapter(getContext(), listGroup, hashMap);
        expandableListView.setAdapter(adapter);
    }
    void setListener() {
        // This listener will show toast on group click
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView listview, View view,
                                        int group_pos, long id) {
                Toast.makeText(getContext(),
                        "You clicked : " + adapter.getGroup(group_pos),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // This listener will expand one group at one time
        // You can remove this listener for expanding all groups
        expandableListView
                .setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                    // Default position
                    int previousGroup = -1;
                    @Override
                    public void onGroupExpand(int groupPosition) {
                        if (groupPosition != previousGroup)
                            expandableListView.collapseGroup(previousGroup);
                        previousGroup = groupPosition;
                    }
                });

        // This listener will show toast on child click
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView listview, View view,
                                        int groupPos, int childPos, long id) {
                Toast.makeText(
                        getContext(),
                        "You clicked : " + adapter.getChild(groupPos, childPos),
                        Toast.LENGTH_SHORT).show();
                        text.setText(adapter.getChild(groupPos, childPos).toString());
               ImageView imgCheckedIncomeCatagory  = (ImageView)  view.findViewById(R.id.imgCheckedIncomeCatagory);
                imgCheckedIncomeCatagory.setVisibility(View.VISIBLE);
                fragmentControlThuChi.startAnimation(animationthoat);
                fragmentControlThuChi.setVisibility(View.GONE);
                return false;
            }
        });
    }
    @Override
    public void onClick(View view) {
         if(view==btnBack){
             fragmentControlThuChi.startAnimation(animationthoat);
             fragmentControlThuChi.setVisibility(View.GONE);

         }else if(view==imageViewAdd){
             fragmentControlThuChiRight.setVisibility(View.VISIBLE);
             fragmentManager.beginTransaction().replace(fragmentControlThuChiRight.getId(),
                     new Fragment_Add_Category_Sub(fragmentManager,fragmentControlThuChiRight)).commit();
             fragmentControlThuChiRight.startAnimation(animation);

         }
    }
    private void anhxa(){
        imageViewAdd=(ImageView)this.view.findViewById(R.id.imageViewAdd);
        btnBack=(ImageView)this.view.findViewById(R.id.btnBack);
        animationthoat = AnimationUtils.loadAnimation(getContext(), R.anim.right_out);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.right_in);
    }
    private void thongbao(String nd){
        Toast.makeText(getContext(),nd,Toast.LENGTH_LONG).show();
    }
}