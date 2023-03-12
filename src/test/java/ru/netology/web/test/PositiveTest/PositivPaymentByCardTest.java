package ru.netology.web.test.PositiveTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.PaymentByCardPage;

import static com.codeborne.selenide.Selenide.open;


public class PositivPaymentByCardTest {

    @BeforeEach
    public void setup() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
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
