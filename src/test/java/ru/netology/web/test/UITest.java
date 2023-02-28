package ru.netology.web.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class UITest {
    private String amount = "10000";
    private String amountZero = "0";
    private String amountOne = "1";
    private String amountOverLimit = "10001";

    private String amountPanny = "0.1";


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
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.paymentVisible();
        paymentByCardPage.setFromCardField(DataHelper.getFirstCard());
        paymentByCardPage.setMonth();
        paymentByCardPage.setYear();
        paymentByCardPage.setName();
        paymentByCardPage.setCvc();
        paymentByCardPage.pushButton();
        paymentByCardPage.getBuy();


    }


}
