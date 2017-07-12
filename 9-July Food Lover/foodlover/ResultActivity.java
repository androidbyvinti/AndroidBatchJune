package com.bmpl.foodlover;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView = (TextView)findViewById(R.id.resultTextView);

        Intent intent = getIntent();

        String checkBox = intent.getStringExtra("checkbox1");
        if(!checkBox.equals("")){
            textView.setText(checkBox);
        }

        /*Log.d("check box 1",intent.getStringExtra("checkbox1"));
        Log.d("check box 2" ,intent.getStringExtra("checkbox2"));
        Log.d("check box 3",intent.getStringExtra("checkbox3"));
        Log.d("radio value",intent.getStringExtra("radioValue"));*/
    }
}
