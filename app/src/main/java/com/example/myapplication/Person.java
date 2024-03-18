package com.example.myapplication;


import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
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
        new APITask().execute();
    }

    private class APITask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            String URL = "https://api.randomdatatools.ru/";
            HttpURLConnection connection = null;
            StringBuilder stringBuilder = new StringBuilder();
            try {
                connection = (HttpURLConnection) new URL(URL).openConnection();
                connection.setRequestMethod("GET");
                connection.setUseCaches(false);
                connection.setConnectTimeout(250);
                connection.setReadTimeout(250);
                connection.connect();

                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    String line;
                    while ((line = in.readLine()) != null) {
                        stringBuilder.append(line);
                        stringBuilder.append("\n");
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }

            return stringBuilder.toString();
        }

        @Override
        protected void onPostExecute(String result) {
            name = result;
        }
    }
}
