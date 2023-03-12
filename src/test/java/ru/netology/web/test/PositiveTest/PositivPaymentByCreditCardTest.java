package ru.netology.web.test.PositiveTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.PaymentByCreditPage;

import static com.codeborne.selenide.Selenide.open;

public class PositivPaymentByCreditCardTest {

    @BeforeEach
    public void setup() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
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
