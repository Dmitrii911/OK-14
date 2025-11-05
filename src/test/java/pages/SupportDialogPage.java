package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SupportDialogPage {
    private SelenideElement supportChat = $(".portlet_h");
    private SelenideElement buttonCancel = $("[tsid='feedback-form_button_953b97']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость окна")
    private void verifyPageElements() {
        supportChat.shouldBe(visible);
        buttonCancel.shouldBe(visible);
    }

    @Step("Проверяем видимость кнопки закрытия и кликаем на нее")
    public void clickbuttonCancel() {
        buttonCancel.shouldBe(visible).click();
    }
}


