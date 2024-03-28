package com.example.myapplication;


import java.util.Arrays;
import java.util.Random;

public class Person {

    private static final String[] MAN_NAME = {"Иван", "Максим", "Даниил", "Артем",
        "Михаил", "Александр", "Дмитрий", "Кирилл", "Егор", "Никита", "Алексей",
        "Денис", "Илья", "Сергей", "Тимофей", "Павел", "Андрей", "Владимир", "Станислав",
        "Глеб", "Владислав", "Василий", "Роман", "Георгий", "Ярослав"};
    private static final String[] MAN_SURNAME = {"Иванов", "Петров", "Сидоров", "Кузнецов",
            "Смирнов", "Васильев", "Попов", "Алексеев", "Егоров", "Лебедев", "Семенов",
            "Ефимов", "Морозов", "Дмитриев", "Калинин", "Захаров", "Григорьев", "Исаев",
            "Поляков", "Тимофеев", "Федоров", "Жуков", "Фролов", "Щербаков"};
    private static final String[] WOMAN_NAME = {"София", "Анна", "Елизавета", "Мария",
            "Виктория", "Анастасия", "Полина", "Екатерина", "Алиса", "Валерия",
            "Вероника", "Ксения", "Арина", "Юлия", "Ольга", "Евгения", "Татьяна",
            "Надежда", "Маргарита", "Ульяна", "Дарья", "Милана", "Алёна", "Ариадна", "Софья"};
    private static final String[] WOMAN_SURNAME = {"Иванова", "Петрова", "Сидорова",
            "Кузнецова", "Смирнова", "Васильева", "Попова", "Алексеева", "Егорова",
            "Лебедева", "Семенова", "Ефимова", "Морозова", "Дмитриева", "Калинина",
            "Захарова", "Григорьева", "Исаева", "Полякова", "Тимофеева", "Федорова",
            "Жукова", "Фролова", "Щербакова"};

    private static final String[] RACE = {"Европеоид", "Монголоид",
            "Негроид", "Австралоид", "Америндоид"};

    private static final String[] TRAIT = {"Образованность", "Толерантность", "Настойчивость",
            "Догматичность", "Ксенофобия", "Коррупция",
            "Безразличие", "Агрессивность", "Непримиримость"};

    private Random random;
    private String name;
    private String surname;
    private String gender;
    private String race;
    private String[] trait;
    private int activity;
    private int loyalty;
    private int popularity;
    private int age;

    @Override
    public String toString() {
        return  "\nname=" + name +
                "\nsurname=" + surname + "\n";
    }

    public Person(long seed) {
        random = new Random(seed);

        if (random.nextInt(2) == 0)
            gender = "man";
        else
            gender = "woman";

        if (gender == "man")
        {
            name = MAN_NAME[random.nextInt(25)];
            surname = MAN_SURNAME[random.nextInt(25)];
        } else
        {
            name = WOMAN_NAME[random.nextInt(25)];
            surname = WOMAN_SURNAME[random.nextInt(25)];
        }

        race = RACE[random.nextInt(5)];

        age = random.nextInt(60) + 21;
        activity = random.nextInt(51);
        loyalty = random.nextInt(101);
        popularity = random.nextInt(101);

        trait = new String[2];

        for (int i = 0; i < trait.length; i++)
        {
            trait[i] = TRAIT[random.nextInt(TRAIT.length)];
        }
    }
}
