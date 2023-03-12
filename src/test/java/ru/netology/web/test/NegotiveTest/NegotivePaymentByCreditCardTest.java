package ru.netology.web.test.NegotiveTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.PaymentByCreditPage;

import static com.codeborne.selenide.Selenide.open;

public class NegotivePaymentByCreditCardTest {

    @BeforeEach
    public void setup() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
    }
    @Test
    void shouldShowWarning() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateEmptyForm());
        paymentByCreditPage.checkWarningUnderAll();
    }
    @Test
    void shouldShowWarningUnderCard1() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedCard("444444444"));
        paymentByCreditPage.checkWarningUnderCard("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderCard2() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedCard("Л-s"));
        paymentByCreditPage.checkWarningUnderCard("Неверный формат");
    }

    @Test
    void shouldShowWarningUnderMont1() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedMonth("1"));
        paymentByCreditPage.checkWarningUnderMonth("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderMonth2() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedMonth("J-о"));
        paymentByCreditPage.checkWarningUnderMonth("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderMonth3() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithInvalidMonth());
        paymentByCreditPage.checkWarningUnderMonth("Неверно указан срок действия карты");
    }
    @Test
    void shouldShowWarningUnderYear1() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithInvalidYear());
        paymentByCreditPage.checkWarningUnderYear("Истёк срок действия карты");
    }
    @Test
    void shouldShowWarningUnderYear2() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedYear("1"));
        paymentByCreditPage.checkWarningUnderYear("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderYear3() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedYear("J-о"));
        paymentByCreditPage.checkWarningUnderYear("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderName() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedCardName("566"));
        paymentByCreditPage.checkWarningUnderName("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderCVC1() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedCvc("5"));
        paymentByCreditPage.checkWarningUnderCvc("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderCVC2() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedCvc("55"));
        paymentByCreditPage.checkWarningUnderCvc("Неверный формат");
    }
    @Test
    void shouldShowWarningUnderCVC3() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.paymentVisible();
        paymentByCreditPage.validUser(DataHelper.generateUserWithParametrizedCvc("O-о"));
        paymentByCreditPage.checkWarningUnderCvc("Неверный формат");
    }


}
