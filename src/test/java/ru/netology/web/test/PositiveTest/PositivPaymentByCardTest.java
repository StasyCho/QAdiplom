package ru.netology.web.test.PositiveTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.PaymentByCardPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.closeWindow;


public class PositivPaymentByCardTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setup() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @AfterEach
    void tearDown() {
        closeWindow();
    }

    @Test
    void shouldBuyByFirstCard() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateRandomUserWithFirstCard());
        paymentByCardPage.setSuccess();
        paymentByCardPage.errorNotVisible();
    }

    @Test
    void shouldBuyByFirstCardWithBoundaryValuesName1() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedLengthCardName(1));
        paymentByCardPage.setSuccess();
        paymentByCardPage.errorNotVisible();
    }

    @Test
    void shouldBuyByFirstCardWithBoundaryValuesName64() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedLengthCardName(64));
        paymentByCardPage.setSuccess();
        paymentByCardPage.errorNotVisible();
    }

    @Test
    void shouldBuyByFirstCardWithValidName() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedCardName("Petrov-Ivanov Ivan"));
        paymentByCardPage.setSuccess();
        paymentByCardPage.errorNotVisible();
    }

    @Test
    void shouldBuyByFirstCardWithMaxYear() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithMaxYear());
        paymentByCardPage.setSuccess();
        paymentByCardPage.errorNotVisible();
    }

    @Test
    void shouldBuyByFirstCardWithMinYear() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithMinYear());
        paymentByCardPage.setSuccess();
        paymentByCardPage.errorNotVisible();
    }

    @Test
    void shouldNotBuyBySecondCard() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateRandomUserWithSecondCard());
        paymentByCardPage.setError();
        paymentByCardPage.successNotVisible();
    }

    @Test
    void shouldNotBuyByRandomCard() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateRandomUserWithRandomCard());
        paymentByCardPage.setError();
        paymentByCardPage.successNotVisible();
    }


}
