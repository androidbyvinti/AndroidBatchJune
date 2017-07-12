package com.bmpl.foodlover;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    TextView seekBarTextView;
    SeekBar seekBar;
    CheckBox checkBoxGulab, checkBoxKaju, checkBoxJalebi;
    RadioButton radioButton;
    Button submitButton;
    RadioGroup radioGroup;
    String checkBox1 , checkBox2, checkBox3, radioValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBarTextView.setText( i +"/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        radioGroup.setOnCheckedChangeListener(this);

        checkBoxJalebi.setOnCheckedChangeListener(this);
        checkBoxKaju.setOnCheckedChangeListener(this);
        checkBoxGulab.setOnCheckedChangeListener(this);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("checkbox1", checkBox1);
                intent.putExtra("checkbox2", checkBox2);
                intent.putExtra("checkbox3", checkBox3);
                intent.putExtra("radioValue", radioValue);
                startActivity(intent);

            }
        });

    }

    void initialize(){

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);

        seekBarTextView = (TextView)findViewById(R.id.ratingTextView);
        seekBar = (SeekBar)findViewById(R.id.seekBar);

        submitButton = (Button)findViewById(R.id.submitButton);

        checkBoxGulab = (CheckBox)findViewById(R.id.checkBox1);
        checkBoxKaju = (CheckBox)findViewById(R.id.checkBox2);
        checkBoxJalebi = (CheckBox)findViewById(R.id.checkBox3);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

/*        if(checkBoxGulab.isChecked()){
            checkBox1 = checkBoxGulab.getText().toString();
        } else if(checkBoxJalebi.isChecked()){
            checkBox3 = checkBoxJalebi.getText().toString();
        } else if(checkBoxKaju.isChecked()){
            checkBox2 = checkBoxKaju.getText().toString();
        }
        else {
            checkBox1 = null;
            checkBox2 = null;
            checkBox3 = null;
        }*/


        if(b){
            int selectedID = compoundButton.getId();
            switch (selectedID){
                case R.id.checkBox1:
                    checkBox1 = checkBoxGulab.getText().toString();
                    break;

                case R.id.checkBox2:
                    checkBox2 = checkBoxKaju.getText().toString();
                    break;

                case R.id.checkBox3:
                    checkBox3 = checkBoxJalebi.getText().toString();
                    break;
            }
        } else if(!b){
            int selectedID = compoundButton.getId();
            switch (selectedID){
                case R.id.checkBox1:
                    checkBox1 = "";
                    break;

                case R.id.checkBox2:
                    checkBox2 = "";
                    break;

                case R.id.checkBox3:
                    checkBox3 = "";
                    break;
            }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

        radioButton = (RadioButton)findViewById(i);

        radioValue = radioButton.getText().toString();

    }
}
