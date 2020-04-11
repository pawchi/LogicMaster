package com.example.logicmaster;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CustomAdapter_GridView_ex_33 extends BaseAdapter {

    Context context;
    int cubes[];
    LayoutInflater inflater;

    public CustomAdapter_GridView_ex_33(Context applicationContext, int[] cubes) {
        this.context = applicationContext;
        this.cubes = cubes;
        inflater = LayoutInflater.from(applicationContext);
    }

    @Override
    public int getCount() {
        return cubes.length;
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
        convertView = inflater.inflate(R.layout.my_image_view_ex_33, null);
        ImageView icon = convertView.findViewById(R.id.icon_33);
        icon.setImageResource(cubes[position]);
        return convertView;
    }
}
