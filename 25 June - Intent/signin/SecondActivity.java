package com.bmpl.signin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity{

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView)findViewById(R.id.textView);

        Intent intent = getIntent();
        String email = intent.getStringExtra("em");
        String password = intent.getStringExtra("pswrd");

        textView.setText("Welcome " + email + password);

    }


}
