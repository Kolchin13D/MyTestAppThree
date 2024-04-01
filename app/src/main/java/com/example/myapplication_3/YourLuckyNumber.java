package com.example.myapplication_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;


public class YourLuckyNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_lucky_number);

        TextView text3 = findViewById(R.id.text3);
        TextView text4 = findViewById(R.id.text4);

        //получение имени и числа

        Intent i = getIntent();
        String name = i.getStringExtra("name" );
        int random = luckyNumber();

        text3.setText(name + ", your lucky number is");
        text4.setText("" + random);

        //share result
        Button share = findViewById(R.id.Share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(name, random);
            }
        });

    }

    private int luckyNumber(){
        Random rnd = new Random();
        int number = rnd.nextInt(99) + 1;
        return number;
    }

    private void shareData(String name, int random){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, name + "got lucky number");
        i.putExtra(Intent.EXTRA_TEXT, "This is " + name + ". His lucky number is: " + random);

        startActivity(Intent.createChooser(i,"Choose a platform"));
    }
}