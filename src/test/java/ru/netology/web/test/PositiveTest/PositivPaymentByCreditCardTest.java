package ru.netology.web.test.PositiveTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.PaymentByCreditPage;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class PositivPaymentByCreditCardTest {

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
    void shouldBuyByFirstCreditCard() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateRandomUserWithFirstCard());
        paymentByCreditPage.setSuccess();
        paymentByCreditPage.errorNotVisible();
    }

    @Test
    void shouldBuyByFirstCreditCardWithBoundaryValuesName1() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedLengthCardName(1));
        paymentByCreditPage.setSuccess();
        paymentByCreditPage.errorNotVisible();
    }

    @Test
    void shouldBuyByFirstCreditCardWithBoundaryValuesName64() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedLengthCardName(64));
        paymentByCreditPage.setSuccess();
        paymentByCreditPage.errorNotVisible();
    }

    @Test
    void shouldBuyByFirstCreditCardWithValidName() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedCardName("Petrov-Ivanov Ivan"));
        paymentByCreditPage.setSuccess();
        paymentByCreditPage.errorNotVisible();
    }

    @Test
    void shouldBuyByFirstCreditCardWithMaxYear() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithMaxYear());
        paymentByCreditPage.setSuccess();
        paymentByCreditPage.errorNotVisible();
    }

    @Test
    void shouldBuyByFirstCreditCardWithMinYear() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithMinYear());
        paymentByCreditPage.setSuccess();
        paymentByCreditPage.errorNotVisible();
    }

    @Test
    void shouldNotBuyBySecondCreditCard() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateRandomUserWithSecondCard());
        paymentByCreditPage.setError();
        paymentByCreditPage.successNotVisible();

    }

    @Test
    void shouldNotBuyByRandomCreditCard() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateRandomUserWithRandomCard());
        paymentByCreditPage.setError();
        paymentByCreditPage.successNotVisible();

    }
}
