package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mainText;
    Button mainButton;

    long seed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Генерация сида
        Random random = new Random();
        seed = random.nextInt();

        Person person = new Person(seed);

        // Подключение элементов окна
        mainButton = findViewById(R.id.mainButton);
        mainText = findViewById(R.id.mainText);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText(person.getName());
            }
        });
    }
}