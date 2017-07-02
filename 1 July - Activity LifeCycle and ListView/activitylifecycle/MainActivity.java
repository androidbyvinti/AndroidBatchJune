package com.bmpl.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter arrayAdapter;

    ListView listView;
    String data[] = {"Froyo", "Gingerbread", "HoneyComb",
            "IceCream Sandwich", "JellyBean", "Kitkat",
            "IceCream Sandwich", "JellyBean", "Kitkat",
            "IceCream Sandwich", "JellyBean", "Kitkat",
            "IceCream Sandwich", "JellyBean", "Kitkat",
            "IceCream Sandwich", "JellyBean", "Kitkat"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "inside onCreate()");

        listView = (ListView)findViewById(R.id.listView);

        //
        arrayAdapter = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, data);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Toast.makeText(MainActivity.this, "You clicked on "+ data[position], Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "inside onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "inside onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "inside onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("MainActivity", "inside onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("MainActivity", "inside onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("MainActivity", "inside onRestart()");
    }
}
