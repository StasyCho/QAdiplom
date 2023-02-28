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
    public static String generateRandomMonth() {
        return faker.number().numberBetween(01, 12);
    }

    public static String generateRandomYear() {
        return faker.number().numberBetween(23, 33);
    }

    public static String generateRandomName() {
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generateRandomCVC() {
        return faker.number().numberBetween(001, 999);
    }

    public static AuthInfo generateValidUserWithFirstCard() {
        return new AuthInfo(getFirstCard(), generateRandomMonth(), generateRandomYear(), generateRandomName(), generateRandomCVC());
    }

    public static AuthInfo generateValidUserWithSecondCard() {
        return new AuthInfo(getSecondCard(), generateRandomMonth(), generateRandomYear(), generateRandomName(), generateRandomCVC());
    }

    public static AuthInfo generateInvalidUser1() {
        return new AuthInfo("4444 4444 4444 444", generateRandomMonth(), generateRandomYear(), generateRandomName(), generateRandomCVC());
    }

}
