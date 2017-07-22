package com.bmpl.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter arrayAdapter;

    ListView listView;

    String[] array = {"Data1", "Data2", "Data3", "Data4",
                      "Data5", "Data6", "Data7", "Data8",
                      "Data9", "Data10", "Data11", "Data12"};

    int[] images = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                    R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                    R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                    R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);

        //Container--> collection of data

        //arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, array, images);

        listView.setAdapter(new CustomAdapter(this, images, array));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, "Clicked " + array[i], Toast.LENGTH_SHORT).show();

            }
        });

    }
}
