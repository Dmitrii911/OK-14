package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RestorePage extends BasePage {
    private SelenideElement supportLink = $(".support-link_item-icon");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость кнопки и вызов службы поддержки")
    private void verifyPageElements() {
        supportLink.shouldBe(visible);
    }

    @Step("нажимаем на ссылку службы поддержки")
    public void clickSupport() {
        supportLink.shouldBe(visible).click();
    }
}
