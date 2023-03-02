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
        return new String ("4444 4444 4444 4441");
    }
   public static String getSecondCard() {
    return new String ( "4444 4444 4444 4442");
   }
    public static String getRandomCard() {
        return faker.finance().creditCard();
    }

    public static int generateRandomMonth() {
        return faker.number().numberBetween(10,12);
    }

    public static int generateRandomYear() {
        return faker.number().numberBetween(23, 28);
    }

    public static String generateRandomName() {
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static int generateRandomCVC() {
        return faker.number().numberBetween(100, 999);
    }

    public static AuthInfo generateRandomUserWithFirstCard() {
        return new AuthInfo(getFirstCard(), generateRandomMonth(), generateRandomYear(), generateRandomName(), generateRandomCVC());
    }
    public static AuthInfo generateRandomUserWithSecondCard() {
        return new AuthInfo(getSecondCard(), generateRandomMonth(), generateRandomYear(), generateRandomName(), generateRandomCVC());
    }
    public static AuthInfo generateRandomUserWithRandomCard() {
        return new AuthInfo(getRandomCard(), generateRandomMonth(), generateRandomYear(), generateRandomName(), generateRandomCVC());
    }
}
