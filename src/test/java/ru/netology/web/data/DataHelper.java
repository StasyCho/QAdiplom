package ru.netology.web.data;

import lombok.Value;
import com.github.javafaker.Faker;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    private static Faker faker = new Faker(new Locale("en"));

    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        String card;
        String month;
        String year;
        String name;
        String cvc;
    }
    private static int validYear = Integer.parseInt(getCurrentYear()) + 1;

    public static String FirstCard = "4444 4444 4444 4441";

    public static String SecondCard = "4444 4444 4444 4442";

    public static String getCurrentMonth() {
        LocalDate date = LocalDate.now();
        String currentMonth = date.format(DateTimeFormatter.ofPattern("MM"));
        return currentMonth;
    }

    public static String getCurrentYear() {
        LocalDate date = LocalDate.now();
        String currentYear = date.format(DateTimeFormatter.ofPattern("yy"));
        return currentYear;
    }

    public static String getRandomCard() {
        return faker.number().digits(16);
    }

    public static String generateRandomName() {
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generateRandomCVC() { return faker.number().digits(3);}

    public static AuthInfo generateRandomUserWithFirstCard() {
        return new AuthInfo(FirstCard, getCurrentMonth(), String.valueOf(validYear), generateRandomName(), generateRandomCVC());
    }

    public static AuthInfo generateRandomUserWithSecondCard() {
        return new AuthInfo(SecondCard, getCurrentMonth(), String.valueOf(validYear), generateRandomName(), generateRandomCVC());
    }
    public static AuthInfo generateEmptyForm() {
        var card = "";
        var month = "";
        var year = "";
        var name = "";
        var cvc = "";
        return new AuthInfo(card, month, year, name, cvc);
    }

    public static AuthInfo generateRandomUserWithRandomCard() {
        return new AuthInfo(getRandomCard(), getCurrentMonth(), String.valueOf(validYear), generateRandomName(), generateRandomCVC());
    }
    public static AuthInfo generateUserWithParametrizedLengthCardName(int length) {
        var randomName = faker.lorem().fixedString(length);
        return new AuthInfo(FirstCard, getCurrentMonth(), String.valueOf(validYear), randomName, generateRandomCVC());
    }

    public static AuthInfo generateUserWithParametrizedCardName(String name) {
        return new AuthInfo(FirstCard, getCurrentMonth(), String.valueOf(validYear), name, generateRandomCVC());
    }
    public static AuthInfo generateUserWithParametrizedCard(String card) {
        return new AuthInfo(card, getCurrentMonth(), String.valueOf(validYear), generateRandomName(), generateRandomCVC());
    }
    public static AuthInfo generateUserWithParametrizedMonth(String month) {
        return new AuthInfo(FirstCard, month, String.valueOf(validYear), generateRandomName(), generateRandomCVC());
    }
    public static AuthInfo generateUserWithParametrizedYear(String year) {
        return new AuthInfo(FirstCard, getCurrentMonth(), year, generateRandomName(), generateRandomCVC());
    }
    public static AuthInfo generateUserWithParametrizedCvc(String cvc) {
        return new AuthInfo(FirstCard, getCurrentMonth(), String.valueOf(validYear), generateRandomName(), cvc);
    }

    public static AuthInfo generateUserWithInvalidMonth() {
        var currentMonth = Integer.parseInt(getCurrentMonth());
        currentMonth = currentMonth - 1;

        String minusOneFromCurrentMonth = "";
        if (currentMonth < 10) {
            minusOneFromCurrentMonth = "0" + currentMonth;
        }
        return new AuthInfo(FirstCard, minusOneFromCurrentMonth, getCurrentYear(), generateRandomName(), generateRandomCVC());
    }
    public static AuthInfo generateUserWithInvalidYear() {
        var currentYear = Integer.parseInt(getCurrentYear());
        currentYear = currentYear - 1;
        String minusOneFromCurrentYear = String.valueOf(currentYear);

        return new AuthInfo(FirstCard, getCurrentMonth(), minusOneFromCurrentYear, generateRandomName(), generateRandomCVC());
    }
    public static AuthInfo generateUserWithMaxYear() {
        var currentYear = Integer.parseInt(getCurrentYear());
        currentYear = currentYear + 6;
        String maxYear = String.valueOf(currentYear);

        return new AuthInfo(FirstCard, getCurrentMonth(), maxYear, generateRandomName(), generateRandomCVC());
    }
    public static AuthInfo generateUserWithMinYear() {

        return new AuthInfo(FirstCard, getCurrentMonth(), getCurrentYear(), generateRandomName(), generateRandomCVC());
    }



    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreditCardData {
        private String id;
        private String bank_id;
        private String created;
        private String status;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PaymentCardData {
        private String id;
        private String amount;
        private String created;
        private String status;
        private String transaction_id;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TableOrderEntity {
        private String id;
        private String created;
        private String credit_id;
        private String payment_id;
    }
}
