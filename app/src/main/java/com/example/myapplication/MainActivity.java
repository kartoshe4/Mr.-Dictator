package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.view.WindowManager;
import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout health;
    private View[] divisions_health;
    TextView mainText;
    Button mainButton;
    long seed;

    private View[] addRectangles(int count, LinearLayout linearLayout) {
        View[] rectangles = new View[count]; // Инициализируем массив

        for (int i = 0; i < count; i++) {
            View rectangle = new View(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.width = 100; // Ширина
            params.height = 30; // Высота
            params.topMargin = 10; // Верхний отступ
            rectangle.setLayoutParams(params);
            linearLayout.addView(rectangle);
            rectangles[i] = rectangle; // Сохраняем ссылку на прямоугольник в массиве
        }
        return rectangles;
    }

    private void changeRectangleColor(int index, int color, View[] rectangles) {
        if (index >= 0 && index < rectangles.length) {
            rectangles[index].setBackgroundColor(color);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(Color.parseColor("#0A1F32"));


        health = findViewById(R.id.health);

        divisions_health = addRectangles(5, health);
        for (int i = 0; i < divisions_health.length; i++) {
            changeRectangleColor(i, Color.argb(255, 255, 255, 255), divisions_health);
        }

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
                mainText.setText(person.toString());
            }
        });
    }
}