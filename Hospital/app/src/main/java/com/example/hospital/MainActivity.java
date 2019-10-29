package com.example.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageButton b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (ImageButton)findViewById(R.id.imgB1);
        b2 = (ImageButton)findViewById(R.id.imgB2);

        b1.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(),HospitalsActivity.class);
                startActivityForResult(intent,0);
            }
        });


    }
}
