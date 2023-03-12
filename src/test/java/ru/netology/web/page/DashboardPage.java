package ru.netology.web.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;

public class DashboardPage {

    private SelenideElement buyButton = Selenide.$x("//span[text()='Купить']");
    private SelenideElement creditButton = Selenide.$x("//span[text()='Купить в кредит']");

    public void isDashboardPage() {
        buyButton.shouldBe(appear);
        creditButton.shouldBe(appear);
    }
    public void buyByCard() {
        buyButton.click();
    }
    public void buyByCreditCard() {
        creditButton.click();
    }
}
