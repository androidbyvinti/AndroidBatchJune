package com.bmpl.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] array = {"Data1", "Data2", "Data3", "Data4",
                      "Data5", "Data6", "Data7", "Data8",
                      "Data9", "Data10", "Data11", "Data12"};

    int[] images = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                    R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                    R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                    R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);

        //Container--> collection of data

        listView.setAdapter(new CustomAdapter(this, images, array));

    }
}
