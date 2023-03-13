package ru.netology.web.test.NegotiveTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.PaymentByCreditPage;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class NegotivePaymentByCreditCardTest {

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
    void shouldShowWarningUnderEmptyFields() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateEmptyForm());
        paymentByCreditPage.checkWarningUnderAll();
    }

    @Test
    void shouldShowWarningUnderCardWithNumberOfSimbolsLess16() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedCard("444444444"));
        paymentByCreditPage.checkWarningUnderCard("Неверный формат");
    }

    @Test
    void shouldShowWarningUnderCardWithInvalidSimbols() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedCard("Л-s"));
        paymentByCreditPage.checkWarningUnderCard("Неверный формат");
    }

    @Test
    void shouldShowWarningUnderMont1Simbols() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedMonth("1"));
        paymentByCreditPage.checkWarningUnderMonth("Неверный формат");
    }

    @Test
    void shouldShowWarningUnderMonthWithInvalidSimbols() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedMonth("J-о"));
        paymentByCreditPage.checkWarningUnderMonth("Неверный формат");
    }

    @Test
    void shouldShowWarningUnderInvalidMonth() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithInvalidMonth());
        paymentByCreditPage.checkWarningUnderMonth("Неверно указан срок действия карты");
    }

    @Test
    void shouldShowWarningUnderMonth00() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedMonth("00"));
        paymentByCreditPage.checkWarningUnderMonth("Неверный формат");
    }

    @Test
    void shouldShowWarningUnderInvalidYear() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithInvalidYear());
        paymentByCreditPage.checkWarningUnderYear("Истёк срок действия карты");
    }

    @Test
    void shouldShowWarningUnderYear1Simbol() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedYear("1"));
        paymentByCreditPage.checkWarningUnderYear("Неверный формат");
    }

    @Test
    void shouldShowWarningUnderYearWithInvalidSimbols() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedYear("J-о"));
        paymentByCreditPage.checkWarningUnderYear("Неверный формат");
    }

    @Test
    void shouldShowWarningUnderNameWithInvalidSimbols() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedCardName("566"));
        paymentByCreditPage.checkWarningUnderName("Неверный формат");
    }

    @Test
    void shouldShowWarningUnderCVC1Simbol() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedCvc("5"));
        paymentByCreditPage.checkWarningUnderCvc("Неверный формат");
    }

    @Test
    void shouldShowWarningUnderCVC2Simbols() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedCvc("55"));
        paymentByCreditPage.checkWarningUnderCvc("Неверный формат");
    }

    @Test
    void shouldShowWarningUnderCVCWithInvalidSimbols() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedCvc("O-о"));
        paymentByCreditPage.checkWarningUnderCvc("Неверный формат");
    }


}
