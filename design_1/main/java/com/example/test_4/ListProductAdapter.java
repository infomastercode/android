package com.example.test_4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListProductAdapter extends BaseAdapter {
    Context context;

    ListProductAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

      //  final View result;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_product_item, parent, false);

//            viewHolder.txtName = (TextView) convertView.findViewById(R.id.aNametxt);
//            viewHolder.txtVersion = (TextView) convertView.findViewById(R.id.aVersiontxt);
//            viewHolder.icon = (ImageView) convertView.findViewById(R.id.appIconIV);
//
//            result=convertView;
//
//            convertView.setTag(viewHolder);
        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//            result=convertView;
        }

//        viewHolder.txtName.setText(values[position]);
//        viewHolder.txtVersion.setText("Version: "+numbers[position]);
//        viewHolder.icon.setImageResource(images[position]);

        return convertView;
    }
}
