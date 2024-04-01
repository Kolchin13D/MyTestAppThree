package com.example.myapplication_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //данное приложение получает имя пользователя и при нажатии на кнопку - генерирует его счастливое число
    //далее пользователь может поделиться этим числом

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button getNumber = findViewById(R.id.getNumber);
        EditText enterName = findViewById(R.id.name);

        getNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = enterName.getText().toString();

                Intent goPage2 = new Intent(getApplicationContext(), YourLuckyNumber.class);

                goPage2.putExtra("name", name);
                startActivity(goPage2);
            }
        });
    }
}