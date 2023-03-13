package ru.netology.web.test.NegotiveTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.PaymentByCardPage;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class NegotivePaymentByCardTest {

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
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateEmptyForm());
        paymentByCardPage.checkWarningUnderAll();
    }
    @Test
    void shouldShowWarningUnderCardWithNumberOfSimbolsLess16() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedCard("444444444444444"));
        paymentByCardPage.checkWarningUnderCard("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderCardWithInvalidSimbols() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedCard("D-о"));
        paymentByCardPage.checkWarningUnderCard("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderMonth1Simbols() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedMonth("1"));
        paymentByCardPage.checkWarningUnderMonth("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderMonthWithInvalidSimbols() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedMonth("H-щ"));
        paymentByCardPage.checkWarningUnderMonth("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderInvalidMonth() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithInvalidMonth());
        paymentByCardPage.checkWarningUnderMonth("Неверно указан срок действия карты");
    }
    @Test
    void shouldShowWarningUnderMonth00() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedMonth("00"));
        paymentByCardPage.checkWarningUnderMonth("Неверный формат");
    }

    @Test
    void shouldShowWarningUnderInvalidYear() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithInvalidYear());
        paymentByCardPage.checkWarningUnderYear("Истёк срок действия карты");
    }
    @Test
    void shouldShowWarningUnderYear1() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedYear("1"));
        paymentByCardPage.checkWarningUnderYear("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderYearWithInvalidSimbols() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedYear("Р-o"));
        paymentByCardPage.checkWarningUnderYear("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderNameWithInvalidSimbols() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedCardName("4567"));
        paymentByCardPage.checkWarningUnderName("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderCVC1Simbol() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedCvc("4"));
        paymentByCardPage.checkWarningUnderCvc("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderCVC2Simbols() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedCvc("44"));
        paymentByCardPage.checkWarningUnderCvc("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderCVCWithInvalidSimbols() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedCvc("O-щ"));
        paymentByCardPage.checkWarningUnderCvc("Неверный формат");
    }

}
