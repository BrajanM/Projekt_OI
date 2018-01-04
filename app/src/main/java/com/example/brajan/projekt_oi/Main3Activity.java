package com.example.brajan.projekt_oi;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.io.OutputStreamWriter;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Main3Activity extends AppCompatActivity {
    private TextView txtOutput2;
    private String text2="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);
        txtOutput2 = (TextView) findViewById(R.id.txt_output2);
        Odczytaj();

    }
    public void Odczytaj(){
        try{
            FileInputStream filein=openFileInput("mojtekst.txt");
            InputStreamReader inputread=new InputStreamReader(filein);
            char[] inputBuffer=new char[500];
            int charRead;
            while((charRead=inputread.read(inputBuffer))>0){
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                text2+=readstring;
            }
            inputread.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        txtOutput2.setText(text2);
    }



}
