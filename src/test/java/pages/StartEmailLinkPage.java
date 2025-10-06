package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class StartEmailLinkPage extends BasePage {
    private SelenideElement fieldEmail = $("#field_email");
    private SelenideElement recieveCodeButton = $("[data-l='t,submit']");
    {
        verifyPageElements();
    }
    @Step("Проверяем видимость элементов на странице восстановления пароля по почте")
    private void verifyPageElements(){
        fieldEmail.shouldBe(visible);

        recieveCodeButton.shouldBe(visible);
    }
}
