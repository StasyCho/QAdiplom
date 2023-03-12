package ru.netology.web.test.PositiveTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.web.data.DataHelper;
import ru.netology.web.data.DataSQLHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.PaymentByCardPage;
import ru.netology.web.page.PaymentByCreditPage;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SQLTest {

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
    void shouldSuccessAddWithApprovedPaymentCard() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.validUser(DataHelper.generateRandomUserWithFirstCard());
        var paymentCardData = DataSQLHelper.getPaymentCardData();
        assertEquals("APPROVED", paymentCardData.getStatus());

    }

    @Test
    void shouldSuccessAddWithApprovedCreditCard() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.validUser(DataHelper.generateRandomUserWithFirstCard());
        var creditCardData = DataSQLHelper.getCreditCardData();
        assertEquals("APPROVED", creditCardData.getStatus());

    }

    @Test
    void shouldSuccessTransactionWithDeclinedPaymentCardViaAPI() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.validUser(DataHelper.generateRandomUserWithSecondCard());
        var paymentCardData = DataSQLHelper.getPaymentCardData();
        assertEquals("DECLINED", paymentCardData.getStatus());

    }

    @Test
    void shouldSuccessTransactionWithDeclinedCreditCard() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.validUser(DataHelper.generateRandomUserWithSecondCard());
        var creditCardData = DataSQLHelper.getCreditCardData();
        assertEquals("DECLINED", creditCardData.getStatus());

    }

    @Test
    void shouldAddCorrectPaymentDataInOrderTable() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCard();
        PaymentByCardPage paymentByCardPage = new PaymentByCardPage();
        paymentByCardPage.validUser(DataHelper.generateRandomUserWithFirstCard());
        var cardDataFromPaymentTable = DataSQLHelper.getPaymentCardData();
        var cardDataFromOrderTable = DataSQLHelper.getTableOrderEntity();
        assertEquals(cardDataFromPaymentTable.getTransaction_id(), cardDataFromOrderTable.getPayment_id());
    }

    @Test
    void shouldAddCorrectCreditDataInOrderTable() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDashboardPage();
        dashboardPage.buyByCreditCard();
        PaymentByCreditPage paymentByCreditPage = new PaymentByCreditPage();
        paymentByCreditPage.validUser(DataHelper.generateRandomUserWithFirstCard());
        var cardDataFromCreditTable = DataSQLHelper.getCreditCardData();
        var cardDataFromOrderTable = DataSQLHelper.getTableOrderEntity();
        assertEquals(cardDataFromCreditTable.getBank_id(), cardDataFromOrderTable.getCredit_id());
    }


}
