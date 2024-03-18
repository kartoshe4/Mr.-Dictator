package com.example.myapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class Person {
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
    }

    public void APIPerson() {

        InputStream inputStream = null;

        try {
            URL url = new URL("https://api.randomdatatools.ru/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK)
            {
                inputStream = httpURLConnection.getInputStream();


            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
