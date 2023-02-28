package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {
    private SelenideElement buy = $x("// span [text()='Купить']");
    private SelenideElement credit = $x("// span [text()='Купить в кредит']");

    public void isDashboardPage() {
        buy.shouldBe(visible);
        credit.shouldBe(visible);
    }
    public void buyByCard() {
        buy.click();
    }
    public void buyByCredit() {
        credit.click();
    }
}
