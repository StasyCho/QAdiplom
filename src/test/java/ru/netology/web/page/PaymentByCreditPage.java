package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class PaymentByCreditPage {
    private SelenideElement paymentPageByCredit = Selenide.$x("//h3[text()='Кредит по данным карты']");
    private SelenideElement card = Selenide.$x("//span[text()='Номер карты']" +
            "/following-sibling::span/input");
    private SelenideElement month = Selenide.$x("//span[text()='Месяц']" +
            "/following-sibling::span/input");
    private SelenideElement year = Selenide.$x("//span[text()='Год']" +
            "/following-sibling::span/input");
    private SelenideElement name = Selenide.$x("//span[text()='Владелец']" +
            "/following-sibling::span/input");
    private SelenideElement cvc = Selenide.$x("//span[text()='CVC/CVV']" +
            "/following-sibling::span/input");
    private SelenideElement transferButton = Selenide.$x("//span[text()='Продолжить']");
    private SelenideElement success = Selenide.$x("//div[text()='Операция одобрена Банком.']");
    private SelenideElement error = Selenide.$x("//div[text()='Ошибка!" +
            " Банк отказал в проведении операции.']");
    private SelenideElement warningCard = Selenide.$x("//span[text()='Номер карты']" +
            "/following-sibling::span[@class='input__sub']");
    private SelenideElement warningMonth = Selenide.$x("//span[text()='Месяц']" +
            "/following-sibling::span[@class='input__sub']");
    private SelenideElement warningYear = Selenide.$x("//span[text()='Год']" +
            "/following-sibling::span[@class='input__sub']");
    private SelenideElement warningName = Selenide.$x("//span[text()='Владелец']" +
            "/following-sibling::span[@class='input__sub']");
    private SelenideElement warningCvc = Selenide.$x("//span[text()='CVC/CVV']" +
            "/following-sibling::span[@class='input__sub']");

    public void paymentVisible() {
        paymentPageByCredit.shouldBe(Condition.visible);
    }

    public void pushButton() {
        transferButton.click();
    }

    public void setSuccess() {
        success.waitUntil(Condition.visible, 10000);
    }

    public void successNotVisible() {
        success.shouldNotBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void setError() {
        error.waitUntil(Condition.visible, 10000);
    }

    public void errorNotVisible() {
        error.shouldNotBe(Condition.visible, Duration.ofSeconds(10));
    }

    public DashboardPage validUser(DataHelper.AuthInfo info) {
        card.setValue(info.getCard());
        month.setValue(String.valueOf(info.getMonth()));
        year.setValue(String.valueOf(info.getYear()));
        name.setValue(info.getName());
        cvc.setValue(String.valueOf(info.getCvc()));
        transferButton.click();
        return new DashboardPage();
    }

    public void checkWarningUnderCard(String warningText) {
        warningCard.shouldBe(visible);
        warningCard.shouldHave(text(warningText));
    }

    public void checkWarningUnderMonth(String warningText) {
        warningMonth.shouldBe(visible);
        warningMonth.shouldHave(text(warningText));
    }

    public void checkWarningUnderYear(String warningText) {
        warningYear.shouldBe(visible);
        warningYear.shouldHave(text(warningText));
    }

    public void checkWarningUnderName(String warningText) {
        warningName.shouldBe(visible);
        warningName.shouldHave(text(warningText));
    }

    public void checkWarningUnderCvc(String warningText) {
        warningCvc.shouldBe(visible);
        warningCvc.shouldHave(text(warningText));
    }

    public void checkWarningUnderAll() {
        warningCard.shouldBe(visible);
        warningMonth.shouldBe(visible);
        warningYear.shouldBe(visible);
        warningName.shouldBe(visible);
        warningCvc.shouldBe(visible);
    }

    public void notCheckWarningUnderAll() {
        warningCard.shouldNotBe(visible);
        warningMonth.shouldNotBe(visible);
        warningYear.shouldNotBe(visible);
        warningName.shouldNotBe(visible);
        warningCvc.shouldNotBe(visible);
    }
}
