package ru.netology.web.data;

import lombok.Value;
import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {
    private static Faker faker = new Faker(new Locale("en"));

    private DataHelper() {
    }
    @Value
    public static class AuthInfo {
        String card;
        int month;
        int year;
        String name;
        int cvc;
    }
    public static String getFirstCard() {
        return new String("4444 4444 4444 4441");
    }

    public static String getSecondCard() {
        return new String("4444 4444 4444 4442");
    }
    public static int generateRandomMonth() {
        return faker.number().numberBetween(01, 12);
    }

    public static int generateRandomYear() {
        return faker.number().numberBetween(23, 33);
    }

    public static String generateRandomName() {
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static int generateRandomCVC() {
        return faker.number().numberBetween(001, 999);
    }


}
