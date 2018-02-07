package com.example.brajan.projekt_oi;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.DayOfWeek;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Calendar;
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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import butterknife.BindView;
import butterknife.ButterKnife;


public class Main2Activity extends AppCompatActivity {

    private final int SPEECH_RECOGNITION_CODE = 1;
    private TextView txtOutput;
    private Button  zapisz;
    private Button odczytaj;
    public String text="";
   public String data="data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss");
        data= simpleDateFormat.format(new Date());

        startSpeechToText();
        txtOutput = (TextView) findViewById(R.id.txt_output);

        zapisz=(Button)findViewById(R.id.Zapisz);
        zapisz.setOnClickListener(onClick2);




    }
    private View.OnClickListener onClick2=new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {

            Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
            intent.putExtra("data",data);

            intent.putExtra("text",text);

            Main2Activity.this.startActivity(intent);



        }
    };

    private void startSpeechToText() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"pl_PL");
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Powiedz coś do mikrofonu...");

        try {
            startActivityForResult(intent, SPEECH_RECOGNITION_CODE);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    "Przepraszamy! Twój telefon nie obsługuje rozpoznawania mowy.",
                    Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SPEECH_RECOGNITION_CODE: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    text += " "+result.get(0);

                    txtOutput.setText(text);

                    startSpeechToText();


                }
                break;
            }
        }
    }



}