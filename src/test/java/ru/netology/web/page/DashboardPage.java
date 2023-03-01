package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class DashboardPage {

    private SelenideElement buy = $x("//*[@class='button button_size_m button_theme_alfa-on-white']");
    private SelenideElement credit = $x("//*[@class='button button_view_extra button_size_m button_theme_alfa-on-white']");

    public void isDashboardPage() {
        buy.shouldBe(appear);
        credit.shouldBe(appear);
    }
    public void buyByCard() {
        buy.click();
    }
    public void buyByCredit() {
        credit.click();
    }
}
