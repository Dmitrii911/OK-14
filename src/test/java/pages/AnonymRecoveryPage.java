package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonymRecoveryPage extends BasePage {
    private SelenideElement recoveryByPhoneButton = $("[data-l='t,phone']");
    private SelenideElement recoveryByEmailButton = $("[data-l='t,email']");
    private SelenideElement recoveryBySupportButton = $("[data-l='t,support']");


    {
        verifyPageElements();
    }

    @Step("Проверяем видимость элементов на странице восстановления пароля")
    private void verifyPageElements() {
        recoveryByPhoneButton.shouldBe(visible);
        recoveryByEmailButton.shouldBe(visible);
        recoveryBySupportButton.shouldBe(visible);
    }

    @Step("Нажимаем на кнопку восстановления через телефон")
    public void goToRecoveryByPhone() {
        recoveryByPhoneButton.shouldBe().click();
    }

    @Step("Нажимаем на кнопку восстановления через email")
    public void goToRecoveryByEmail() {
        recoveryByEmailButton.shouldBe().click();
    }

    @Step("Переходим в поддержку")
    public void goToRecoveryBySupport() {
        recoveryBySupportButton.shouldBe().click();
    }

}
