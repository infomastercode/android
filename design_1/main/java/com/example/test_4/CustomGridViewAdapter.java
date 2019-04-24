package com.example.test_4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomGridViewAdapter extends BaseAdapter {
    private Context context;
    private String[] text;
    private int[] image;

    CustomGridViewAdapter(Context context, String[] text, int[] image){
        this.context = context;
        this.text = text;
        this.image = image;
    }

    @Override
    public int getCount() {
        return text.length;
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            view = inflater.inflate(R.layout.gridview_layout, null, false);
            TextView vText = view.findViewById(R.id.text);
            ImageView vImage = view.findViewById(R.id.image);
            vText.setText(text[position]);
            vImage.setImageResource(image[position]);
        }else{
            view = convertView;
        }

        return view;
    }
}
