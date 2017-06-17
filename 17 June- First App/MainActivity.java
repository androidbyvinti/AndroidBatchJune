package vinti.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int value;//

    //globally
    EditText editText;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //R--> pre-defined class--> automatically generated class
        // for each project

        editText = (EditText) findViewById(R.id.nameEditText);

        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(this);//attached listener
    }

    // event handler
    @Override
    public void onClick(View view) {

        String name = editText.getText().toString();

        Toast.makeText(this, "Your name is= "+name, Toast.LENGTH_LONG).show();

    }
}
