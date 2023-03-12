package ru.netology.web.test.NegotiveTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.PaymentByCardPage;

import static com.codeborne.selenide.Selenide.open;

public class NegotivePaymentByCardTest {

    @BeforeEach
    public void setup() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
    }
    @Test
    void shouldShowWarning() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateEmptyForm());
        paymentByCardPage.checkWarningUnderAll();
    }
    @Test
    void shouldShowWarningUnderCard1() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedCard("444444444444444"));
        paymentByCardPage.checkWarningUnderCard("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderCard2() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedCard("D-о"));
        paymentByCardPage.checkWarningUnderCard("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderMonth1() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedMonth("1"));
        paymentByCardPage.checkWarningUnderMonth("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderMonth2() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedMonth("H-щ"));
        paymentByCardPage.checkWarningUnderMonth("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderMonth3() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithInvalidMonth());
        paymentByCardPage.checkWarningUnderMonth("Неверно указан срок действия карты");
    }

    @Test
    void shouldShowWarningUnderYear1() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithInvalidYear());
        paymentByCardPage.checkWarningUnderYear("Истёк срок действия карты");
    }
    @Test
    void shouldShowWarningUnderYear2() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedYear("1"));
        paymentByCardPage.checkWarningUnderYear("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderYear3() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedYear("Р-o"));
        paymentByCardPage.checkWarningUnderYear("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderName() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedCardName("4567"));
        paymentByCardPage.checkWarningUnderName("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderCVC1() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedCvc("4"));
        paymentByCardPage.checkWarningUnderCvc("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderCVC2() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedCvc("44"));
        paymentByCardPage.checkWarningUnderCvc("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderCVC3() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.validUser(DataHelper.generateUserWithParametrizedCvc("O-щ"));
        paymentByCardPage.checkWarningUnderCvc("Неверный формат");
    }
}
