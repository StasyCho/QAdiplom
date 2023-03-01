package ru.netology.web.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.PaymentByCardPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;


public class UITest {

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
        paymentByCardPage.setFirstCard(DataHelper.getFirstCard());
        paymentByCardPage.setMonth("03");
        paymentByCardPage.setYear("23");
        paymentByCardPage.setName(DataHelper.generateRandomName());
        paymentByCardPage.setCvc("999");
        paymentByCardPage.pushButton();
        //paymentByCardPage.setFirstCard(String.valueOf(DataHelper.generateRandomUserWithFirstCard()));
        paymentByCardPage.setSuccess();


    }


}
