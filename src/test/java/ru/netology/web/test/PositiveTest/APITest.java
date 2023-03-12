package ru.netology.web.test.PositiveTest;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataAPIHelper;
import ru.netology.web.data.DataHelper;

public class APITest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldSuccessTransactionWithFirstCardVia() {
        var cardInfo = DataHelper.generateRandomUserWithFirstCard();
        DataAPIHelper.createPayment(cardInfo);
    }

    @Test

    void shouldSuccessTransactionWithFirstCreditCard() {
        var cardInfo = DataHelper.generateRandomUserWithFirstCard();
        DataAPIHelper.createCredit(cardInfo);

    }
    @Test
    void shouldSuccessTransactionWithSecondCard() {
        var cardInfo = DataHelper.generateRandomUserWithSecondCard();
        DataAPIHelper.createPayment(cardInfo);

    }

    @Test
    void shouldSuccessTransactionWithSecondCreditCard() {
        var cardInfo = DataHelper.generateRandomUserWithSecondCard();
        DataAPIHelper.createCredit(cardInfo);

    }
}
