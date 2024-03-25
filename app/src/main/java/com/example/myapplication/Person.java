package com.example.myapplication;


import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class Person {

    private static final String[] manName = {"Иван", "Максим", "Даниил", "Артем",
        "Михаил", "Александр", "Дмитрий", "Кирилл", "Егор", "Никита", "Алексей",
        "Денис", "Илья", "Сергей", "Тимофей", "Павел", "Андрей", "Владимир", "Станислав",
        "Глеб", "Владислав", "Василий", "Роман", "Георгий", "Ярослав"};
    private static final String[] manSurname = {"Иванов", "Петров", "Сидоров", "Кузнецов",
            "Смирнов", "Васильев", "Попов", "Алексеев", "Егоров", "Лебедев", "Семенов",
            "Ефимов", "Морозов", "Дмитриев", "Калинин", "Захаров", "Григорьев", "Исаев",
            "Поляков", "Тимофеев", "Федоров", "Жуков", "Фролов", "Щербаков"};
    private static final String[] womanName = {"София", "Анна", "Елизавета", "Мария",
            "Виктория", "Анастасия", "Полина", "Екатерина", "Алиса", "Валерия",
            "Вероника", "Ксения", "Арина", "Юлия", "Ольга", "Евгения", "Татьяна",
            "Надежда", "Маргарита", "Ульяна", "Дарья", "Милана", "Алёна", "Ариадна", "Софья"};
    private static final String[] womanSurname = {"Иванова", "Петрова", "Сидорова",
            "Кузнецова", "Смирнова", "Васильева", "Попова", "Алексеева", "Егорова",
            "Лебедева", "Семенова", "Ефимова", "Морозова", "Дмитриева", "Калинина",
            "Захарова", "Григорьева", "Исаева", "Полякова", "Тимофеева", "Федорова",
            "Жукова", "Фролова", "Щербакова"};

    private long seed;
    private Random random;
    private String name;
    private String surname;
    private String gender;
    private String race;
    private String[] trait;
    private int loyalty;
    private int age;

    public String getName() {
        return name + " " + surname;
    }

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

    public String[] getTrait() {
        return trait;
    }

    public int getLoyalty() {
        return loyalty;
    }

    public int getAge() {
        return age;
    }

    public Person(long seed) {
        this.seed = seed;
        random = new Random(seed);

        if (random.nextInt(2) == 0)
            gender = "man";
        else
            gender = "woman";

        if (gender == "man")
        {
            name = manName[random.nextInt(25)];
            surname = manSurname[random.nextInt(25)];
        } else
        {
            name = womanName[random.nextInt(25)];
            surname = womanSurname[random.nextInt(25)];
        }
    }
}
