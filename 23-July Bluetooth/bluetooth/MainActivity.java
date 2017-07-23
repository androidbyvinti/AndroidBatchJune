package com.bmpl.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Switch aSwitch;
    Button visible, pairedDevices;
    ListView listView;

    //Set is a predefined interface
    //unique values--> duplicate values will not be added
    Set<BluetoothDevice> bluetoothDevice;

    //BluetoothAdapter

    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch = (Switch)findViewById(R.id.bluetoothSwitch);
        visible  = (Button)findViewById(R.id.visibleButton);
        pairedDevices = (Button)findViewById(R.id.pairedDevices);
        listView = (ListView)findViewById(R.id.listView);

        //initialize and get bluetooth driver info
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        visible.setOnClickListener(this);
        pairedDevices.setOnClickListener(this);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(bluetoothAdapter == null){
                    //Bluetooth Driver not available
                    Toast.makeText(MainActivity.this,"Bluetooth Driver is not Available", Toast.LENGTH_LONG).show();
                } else if(!bluetoothAdapter.isEnabled())
                {
                    //bluetoothAdapter.enable();
                    //implicit intent
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Turned On", Toast.LENGTH_SHORT).show();

                } else {

                    bluetoothAdapter.disable();
                    Toast.makeText(MainActivity.this, "Turned On", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.visibleButton:

                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                intent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 2000);
                startActivity(intent);
                break;

            case R.id.pairedDevices:

                //predefined methods-->
                ArrayList arrayList = new ArrayList();

                //paired device information--> name, address, uuid, etc.
                bluetoothDevice = bluetoothAdapter.getBondedDevices();

                //Enhanced for loop
                for(BluetoothDevice bluetoothDevice1: bluetoothDevice)
                {
                    arrayList.add(bluetoothDevice1.getName());
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arrayList);

                listView.setAdapter(arrayAdapter);

                break;

        }
    }
}