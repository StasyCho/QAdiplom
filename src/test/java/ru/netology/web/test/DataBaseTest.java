package ru.netology.web.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataAPIHelper;
import ru.netology.web.data.DataHelper;
import ru.netology.web.data.DataSQLHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class DataBaseTest {


    @Test
    @DisplayName("Should add the payment data to the database with APPROVAL via the API")
    void shouldSuccessTransactionWithApprovedPaymentCardViaAPI() {
        var cardInfo = DataHelper.generateRandomUserWithFirstCard();
        DataAPIHelper.createPayment(cardInfo);
        var paymentCardData = DataSQLHelper.getPaymentCardData();
        assertEquals("APPROVED", paymentCardData.getStatus());

    }
    @Test
    @DisplayName("Should add the credit data to the database with APPROVAL via the API")
    void shouldSuccessTransactionWithApprovedCreditCardViaAPI() {
        var cardInfo = DataHelper.generateRandomUserWithFirstCard();
        DataAPIHelper.createCredit(cardInfo);
        var creditCardData = DataSQLHelper.getCreditCardData();
        assertEquals("APPROVED", creditCardData.getStatus());

    }

    @Test
    @DisplayName("Should add the payment data to the database with a DECLINED via the API")
    void shouldSuccessTransactionWithDeclinedPaymentCardViaAPI() {
        var cardInfo = DataHelper.generateRandomUserWithSecondCard();
        DataAPIHelper.createPayment(cardInfo);
        var paymentCardData = DataSQLHelper.getPaymentCardData();
        assertEquals("DECLINED", paymentCardData.getStatus());

    }

    @Test
    @DisplayName("Should add the credit data to the database with a DECLINED via the API")
    void shouldSuccessTransactionWithDeclinedCreditCardViaAPI() {
        var cardInfo = DataHelper.generateRandomUserWithSecondCard();
        DataAPIHelper.createCredit(cardInfo);
        var creditCardData = DataSQLHelper.getCreditCardData();
        assertEquals("DECLINED", creditCardData.getStatus());

    }

}
