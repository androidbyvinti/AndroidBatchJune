package com.bmpl.greetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Declare
    EditText nameEditText, salaryEditText;
    Button submitButton, cancelButton;
    TextView resultTextView;

    //initialization inside onCreate()

    //method predefined
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//binding of xml file with java file

        //R--> R.java--> R is java file--> automatically created file--> android studio
       //hexa

        //step-1 downcasting
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        salaryEditText = (EditText) findViewById(R.id.salaryEditText);

        submitButton = (Button)findViewById(R.id.submitButton);

        cancelButton = (Button)findViewById(R.id.cancelButton);

        resultTextView = (TextView)findViewById(R.id.resultTextView);

        //step-2: listener attached
        submitButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }

    //handler
    @Override
    public void onClick(View view) {
        String name = nameEditText.getText().toString();
        String salary = salaryEditText.getText().toString();

        resultTextView.setText("Welcome " + name + "\n" +salary);
    }
}