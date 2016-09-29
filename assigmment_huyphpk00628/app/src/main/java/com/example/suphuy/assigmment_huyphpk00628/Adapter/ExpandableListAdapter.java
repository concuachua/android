package com.example.suphuy.assigmment_huyphpk00628.Adapter;

/**
 * Created by SUPHUY on 9/23/2016.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.suphuy.assigmment_huyphpk00628.R;

import java.util.HashMap;
import java.util.List;

//For expandable list view use BaseExpandableListAdapter
public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<String> header; // header titles
    // Child data in format of header title, child title
    private HashMap<String, List<String>> child;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;
        this.header = listDataHeader;
        this.child = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {

        // This will return the child
        return this.child.get(this.header.get(groupPosition)).get(
                childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        // Getting child text
        final String childText = (String) getChild(groupPosition, childPosition);

        // Inflating child layout and setting textview
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_category_list_child, parent, false);
        }
        ImageView imgCheckedIncomeCatagory=(ImageView)convertView.findViewById(R.id.imgCheckedIncomeCatagory);
        imgCheckedIncomeCatagory.setVisibility(View.GONE);
        TextView child_text = (TextView) convertView.findViewById(R.id.txtChild);
        child_text.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        // return children count
        return this.child.get(this.header.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {

        // Get header position
        return this.header.get(groupPosition);
    }

    @Override
    public int getGroupCount() {

        // Get header size
        return this.header.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, final boolean isExpanded,
                             View convertView, ViewGroup parent) {

        // Getting header title
        String headerTitle = (String) getGroup(groupPosition);

        // Inflating header layout and setting text
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_category_group, parent, false);
        }
        final  LinearLayout LinearLayoutchecked=(LinearLayout)convertView.findViewById(R.id.LinearLayoutchecked);
        final ImageView imgIndicator=(ImageView)convertView.findViewById(R.id.imgIndicator);
        final TextView header_text = (TextView) convertView.findViewById(R.id.header);
        imgIndicator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (LinearLayoutchecked.getVisibility()==View.GONE) {
                    LinearLayoutchecked.setVisibility(View.VISIBLE);
                    imgIndicator.setImageResource(R.drawable.group_collapse);
                    header_text.setTypeface(null, Typeface.BOLD);

                } else {
                    LinearLayoutchecked.setVisibility(View.GONE);
                    imgIndicator.setImageResource(R.drawable.group_expand);
                    header_text.setTypeface(null, Typeface.NORMAL);

                }
            }
        });
        header_text.setText(headerTitle);

        // If group is expanded then change the text into bold and change the
        // icon
        if (isExpanded) {
            LinearLayoutchecked.setVisibility(View.VISIBLE);
            imgIndicator.setImageResource(R.drawable.group_collapse);
            header_text.setTypeface(null, Typeface.BOLD);

        } else {
            LinearLayoutchecked.setVisibility(View.GONE);
            // If group is not expanded then change the text back into normal
            // and change the icon
            imgIndicator.setImageResource(R.drawable.group_expand);
            header_text.setTypeface(null, Typeface.NORMAL);

        }

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}