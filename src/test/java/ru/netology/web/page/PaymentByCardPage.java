package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static java.awt.SystemColor.info;

public class PaymentByCardPage {
    private SelenideElement paymentPage1 = $x("//*[@id=\"root\"]/div/h3");
    private SelenideElement card = $x("//*[@id=\"root\"]/div/form/fieldset/div[1]/span/span/span[2]/input");
    private SelenideElement month = $x("//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span[1]/span/span/span[2]/input");
    private SelenideElement year = $x("//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span[2]/span/span/span[2]/input");
    private SelenideElement name = $x("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[1]/span/span/span[2]/input");
    private SelenideElement cvc = $x("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[2]/span/span/span[2]/input");
    private SelenideElement transferButton = $x("//*[@id=\"root\"]/div/form/fieldset/div[4]/button");

    private SelenideElement success = $x("//*[@id=\"root\"]/div/div[2]/div[3]");
    private SelenideElement error = $x("//*[@id=\"root\"]/div/div[3]/div[3]");

    public void paymentVisible() {
        paymentPage1.shouldBe(Condition.visible);
    }

    public void setFirstCard(String numberCard) {
        card.setValue(numberCard);
    }
    //public void setSecondCard() { card.setValue(String.valueOf(DataHelper.getSecondCard())); }
    public void setMonth(String numberMonth) {
        month.setValue(numberMonth);
    //month.setValue(String.valueOf(DataHelper.generateRandomMonth()));
    }
    public void setYear(String numberYear) {
    year.setValue(numberYear);
    }
    public void setName(String user) {
    name.setValue(user);
    }
    public void setCvc(String numberCvc) {
        cvc.setValue(numberCvc);
    //  cvc.setValue(String.valueOf(DataHelper.generateRandomCVC()));
    }
    public void pushButton() {transferButton.click();}

    public void setSuccess() {success.shouldBe(Condition.appear);}

    public DashboardPage validUser(DataHelper.AuthInfo info) {
        //card.setValue(info.getCard());
        month.setValue(String.valueOf(info.getMonth()));
        year.setValue(String.valueOf(info.getYear()));
        name.setValue(info.getName());
        cvc.setValue(String.valueOf(info.getCvc()));
        transferButton.click();
        return new DashboardPage();
    }

    public DashboardPage getBuy() {
        success.shouldBe(Condition.visible);
        return new DashboardPage();
    }

    public void errorBuy() {
        transferButton.click();
        error.shouldBe(Condition.visible);
    }
}