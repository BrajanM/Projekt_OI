package com.example.brajan.projekt_oi;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.io.OutputStreamWriter;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Main3Activity extends AppCompatActivity {


    private EditText edit;
    private ImageButton zapis;
    private TextView nazwa;
    private Button zatwierdz;
    private String tekst="";
    private String data="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);


        edit = (EditText)findViewById(R.id.plik);
        zapis=(ImageButton)findViewById(R.id.save);
        zapis.setOnClickListener(onClick4);
        nazwa=(TextView)findViewById(R.id.wypisz);

        zatwierdz=(Button)findViewById(R.id.z);
        zatwierdz.setOnClickListener(onClick5);

        Intent intent2= getIntent();
        Intent intent3=getIntent();
        tekst=intent2.getStringExtra("text");
        data=intent3.getStringExtra("data");
        nazwa.setText(data+".txt");
    }
    private View.OnClickListener onClick5 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            nazwa.setText(edit.getText()+".txt");

        }
    };
    private View.OnClickListener onClick4 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Zapis();
            Folder();

        }
    };
    public void Folder()
    {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()
                + "/sdcard/mojanotatka.txt");
        intent.setDataAndType(uri, "*/*");
        startActivity(Intent.createChooser(intent, "Open"));
    }

    public void Zapis(){



        try {
            String sp=data+edit.getText();
            File myFile = new File("/sdcard/"+nazwa.getText());
            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter =
                    new OutputStreamWriter(fOut);
            myOutWriter.append(tekst);
            myOutWriter.close();
            fOut.close();
            Toast.makeText(getBaseContext(),
                    "Zapisano plik '"+nazwa.getText()+".txt'",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }


    }


}
