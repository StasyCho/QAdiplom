package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class PaymentByCreditPage {
    private SelenideElement paymentPage2 = $x("// h3[text() = 'Кредит по данным карты']");
    private SelenideElement card = $x("// span [text()='Номер карты']");
    private SelenideElement month = $x("// span [text()='Месяц']");
    private SelenideElement year = $x("// span [text()='Год']");
    private SelenideElement name = $x("// span [text()='Владелец']");
    private SelenideElement cvc = $x("// span [text()='CVC/CVV']");
    private SelenideElement transferButton = $("// span [text()='Продолжить']");

    private SelenideElement success = $x("// div [text()='Операция одобрена Банком.']");
    private SelenideElement error = $x("// div [text()='Ошибка! Банк отказал в проведении операции.']");


    public void paymentVisible() {
        paymentPage2.shouldBe(Condition.visible);
    }
    public void setFromCardField(String numberCard) {
        card.setValue(numberCard);
    }
    public void setMonth() {
        month.setValue(String.valueOf(DataHelper.generateRandomMonth()));
    }
    public void setYear() {
        year.setValue(String.valueOf(DataHelper.generateRandomYear()));
    }
    public void setName() {
        name.setValue(DataHelper.generateRandomName());
    }
    public void setCvc() {
        cvc.setValue(String.valueOf(DataHelper.generateRandomCVC()));
    }

    public void pushButton() {transferButton.click();}

    public DashboardPage getBuy() {
        transferButton.click();
        success.shouldBe(Condition.visible);
        return new DashboardPage();
    }

    public void errorBuy() {
        transferButton.click();
        error.shouldBe(Condition.visible);
    }
}
