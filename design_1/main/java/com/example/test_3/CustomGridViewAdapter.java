package com.example.test_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomGridViewAdapter extends BaseAdapter {
    private Context context;
    private List<MainActivity.MenuItem> menuItem;

    public CustomGridViewAdapter(Context context, List<MainActivity.MenuItem> menuItem) {
        this.context = context;
        this.menuItem = menuItem;
    }

    @Override
    public int getCount() {
        return this.menuItem.size();
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
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.gridview_item, null, false);
            TextView vText = view.findViewById(R.id.text);
            ImageView vImage = view.findViewById(R.id.image);

            vText.setText(menuItem.get(position).getLabel());
            vImage.setImageResource(menuItem.get(position).getImageId());
        }else{
            view = convertView;
        }
        return view;
    }
}
