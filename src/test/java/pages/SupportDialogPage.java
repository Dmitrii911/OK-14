package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SupportDialogPage extends BasePage {
    private SelenideElement supportChat = $(".chat__n9ga2");
    private SelenideElement buttonClose = $(".button__tndfc.button-icon__tndfc");
    private SelenideElement buttonYes = $x("//span[text()='Да']");


    {
        verifyPageElements();
    }

    @Step("Проверяем видимость диалогового окна")
    private void verifyPageElements() {
        supportChat.shouldBe(visible);
        buttonClose.shouldBe(visible);

    }
    @Step("Проверяем видимость кнопки закрытия и кликаем на нее")
    public void clickbuttonClose() {
        buttonClose.shouldBe(visible).click();
    }


    @Step("ппроверяем наличие кнопки ДА и кликаем на нее")
    public void clickButtonYes() {
        buttonYes.shouldBe(visible).click();

    }
}

