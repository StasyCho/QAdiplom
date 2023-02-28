package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.*;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferTest {
    private String amount = "10000";
    private String amountZero = "0";
    private String amountOne = "1";
    private String amountOverLimit = "10001";

    private String amountPanny = "0.1";


    @BeforeEach
    public void setup() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val codeVerify = DataHelper.getVerificationCode();
        verificationPage.validVerify(codeVerify);
    }

    @Test
    void shouldTransferAmountFromFirstToSecondCard() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        int expected1 = dashboardPage.getCardBalance(0) + Integer.parseInt(amount);
        int expected2 = dashboardPage.getCardBalance(1) - Integer.parseInt(amount);
        dashboardPage.amountCards(0);
        TransferPage transferPage = new TransferPage();
        transferPage.paymentVisible();
        transferPage.setAmount(amount);
        transferPage.setFromCardField(DataHelper.getSecondCard());
        transferPage.getTransfer();
        assertEquals(expected1, dashboardPage.getCardBalance(0));
        assertEquals(expected2, dashboardPage.getCardBalance(1));
    }

    @Test
    void shouldTransferAmountFromSecondToFirstCard() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        int expected1 = dashboardPage.getCardBalance(1) + Integer.parseInt(amount);
        int expected2 = dashboardPage.getCardBalance(0) - Integer.parseInt(amount);
        dashboardPage.amountCards(1);
        TransferPage transferPage = new TransferPage();
        transferPage.paymentVisible();
        transferPage.setAmount(amount);
        transferPage.setFromCardField(DataHelper.getFirstCard());
        transferPage.getTransfer();
        assertEquals(expected1, dashboardPage.getCardBalance(1));
        assertEquals(expected2, dashboardPage.getCardBalance(0));
    }

    @Test
    void shouldErrorTransferWhenAmountZero() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        int expected1 = dashboardPage.getCardBalance(0) + Integer.parseInt(amountZero);
        int expected2 = dashboardPage.getCardBalance(1) - Integer.parseInt(amountZero);
        dashboardPage.amountCards(0);
        TransferPage transferPage = new TransferPage();
        transferPage.paymentVisible();
        transferPage.setAmount(amountZero);
        transferPage.setFromCardField(DataHelper.getSecondCard());
        transferPage.getTransfer();
        assertEquals(expected1, dashboardPage.getCardBalance(0));
        assertEquals(expected2, dashboardPage.getCardBalance(1));
    }

    @Test
    void shouldTransferOneRUB() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        int expected1 = dashboardPage.getCardBalance(0) + Integer.parseInt(amountOne);
        int expected2 = dashboardPage.getCardBalance(1) - Integer.parseInt(amountOne);
        dashboardPage.amountCards(0);
        TransferPage transferPage = new TransferPage();
        transferPage.paymentVisible();
        transferPage.setAmount(amountOne);
        transferPage.setFromCardField(DataHelper.getSecondCard());
        transferPage.getTransfer();
        assertEquals(expected1, dashboardPage.getCardBalance(0));
        assertEquals(expected2, dashboardPage.getCardBalance(1));
    }

    @Test
    void shouldErrorTransferWhenAmountOverLimit() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.amountCards(1);
        TransferPage transferPage = new TransferPage();
        transferPage.paymentVisible();
        transferPage.setAmount(amountOverLimit);
        transferPage.setFromCardField(DataHelper.getFirstCard());
        transferPage.getTransfer();
        //Должна быть ошибка с текстом: "Недостаточно средств для выполнения операции!"
        transferPage.invalidTransfer();
    }
    @Test
    void shouldTransferAmountPanny() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        double expected1 = dashboardPage.getCardBalance(0) + Double.parseDouble(amountPanny);
        double expected2 = dashboardPage.getCardBalance(1) - Double.parseDouble(amountPanny);
        dashboardPage.amountCards(0);
        TransferPage transferPage = new TransferPage();
        transferPage.paymentVisible();
        transferPage.setAmount(amountPanny);
        transferPage.setFromCardField(DataHelper.getSecondCard());
        transferPage.getTransfer();
        assertEquals(expected1, dashboardPage.getCardBalance(0));
        assertEquals(expected2, dashboardPage.getCardBalance(1));
    }

}
