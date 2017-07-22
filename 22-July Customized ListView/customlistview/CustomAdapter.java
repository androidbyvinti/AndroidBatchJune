package com.bmpl.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{

    MainActivity mainActivity1; //

    int[] images;
    String[] array;

    LayoutInflater layoutInflater;// Adapter class or Fragments

    CustomAdapter(){

    }
    CustomAdapter(MainActivity mainActivity, int[] images, String[] array){
        mainActivity1 = mainActivity;
        this.images = images;
        this.array = array;

        layoutInflater = (LayoutInflater) mainActivity1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.length;//
    }

    @Override
    public Object getItem(int i) {
        return images[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        view = layoutInflater.inflate(R.layout.custom_adapter, viewGroup, false);

        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);

        TextView textView = (TextView)view.findViewById(R.id.textView);

        imageView.setImageResource(images[position]);
        textView.setText(array[position]);

        return view;
    }
}
