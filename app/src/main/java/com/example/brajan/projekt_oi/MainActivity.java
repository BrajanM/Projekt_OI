package com.example.brajan.projekt_oi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.content.Intent;

import android.view.View;
import android.widget.ImageButton;


import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnMicrophone;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnMicrophone = (ImageButton) findViewById(R.id.btn_mic);
        btnMicrophone.setOnClickListener(onClick);

    }

    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            MainActivity.this.startActivity(intent);





        }
    };


}
