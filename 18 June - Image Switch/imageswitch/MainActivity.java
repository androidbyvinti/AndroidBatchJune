package com.bmpl.imageswitch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button imageButtonOne, imageButtonTwo;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButtonOne = (Button)findViewById(R.id.imageOneButton);
        imageButtonTwo = (Button)findViewById(R.id.imageSecondButton);

        imageView = (ImageView)findViewById(R.id.imageView);

        //Hello hello = new Hello();
        //object created internally--> class
        //compiler--> create a class--> assign name--> object
        //anonymous declaration--> object

        imageButtonOne.setOnClickListener(new View.OnClickListener() {
            //handler
            @Override
            public void onClick(View view) {

                if(imageButtonOne.getText().toString().equals("Image1")){
                    imageButtonOne.setText("Image2");
                }
                else {
                    imageButtonOne.setText("Image1");
                }
                //imageView.setImageResource(R.drawable.images1);
            }
        });
        imageButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //imageView.setVisibility(View.INVISIBLE);
                imageView.setImageResource(R.drawable.images2);
            }
        });

    }

}
