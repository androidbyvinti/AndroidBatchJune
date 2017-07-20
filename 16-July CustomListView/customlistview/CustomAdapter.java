package com.bmpl.customlistview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CustomAdapter extends BaseAdapter{

    int[] images;
    String[] array;

    CustomAdapter(){

    }

    CustomAdapter(MainActivity mainActivity, int[] images, String[] array){
        this.images = images;
        this.array = array;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
