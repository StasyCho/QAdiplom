package ru.netology.web.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.PaymentByCardPage;
import ru.netology.web.page.PaymentByCreditPage;

import static com.codeborne.selenide.Selenide.open;


public class PositivPaymentByCardTest {

    @BeforeEach
    public void setup() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
    }

    @Test
    void shouldBuyByCard() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        //DataHelper dataHelper = new DataHelper();
        //DataHelper.generateRandomUserWithFirstCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        //paymentByCardPage.setFirstCard(DataHelper.getFirstCard());
        //paymentByCardPage.setMonth(String.valueOf(DataHelper.generateRandomMonth()));
        //paymentByCardPage.setYear(String.valueOf(DataHelper.generateRandomYear()));
        //paymentByCardPage.setName(DataHelper.generateRandomName());
        //paymentByCardPage.setCvc(String.valueOf(DataHelper.generateRandomCVC()));
        paymentByCardPage.validUser(DataHelper.generateRandomUserWithFirstCard());
        //paymentByCardPage.setFirstCard(String.valueOf(DataHelper.generateRandomUserWithFirstCard()));
        paymentByCardPage.pushButton();
        paymentByCardPage.setSuccess();
    }

}
