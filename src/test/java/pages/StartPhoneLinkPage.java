package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class StartPhoneLinkPage extends BasePage {
    private SelenideElement fieldPhone = $("#field_phone");
    private SelenideElement fieldLocal = $(".isl_w");
    private SelenideElement recieveCodeButton = $("[data-l='t,submit']");
    private SelenideElement errorMessage = $(".js-ph-vl-hint");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость элементов на странице восстановления пароля по телефону")
    private void verifyPageElements() {
        fieldPhone.shouldBe(visible);
        fieldLocal.shouldBe(visible);
        recieveCodeButton.shouldBe(visible);
    }

    @Step("Выбираем код страны по названию: {countryName}")
    public String selectCountryByName(String countryName) {
        fieldLocal.click(); //Открываем список стран
        SelenideElement countryItem = $(String.format(".country-select_i[data-name='%s']", countryName));
        countryItem.scrollTo();
        String countryCode = countryItem.find(".country-select_code").text();
        countryItem.click();
        return countryCode;

    }

    @Step("Нажимаем на кнопку получить код")
    public void recieveCode() {
        recieveCodeButton.shouldBe(visible).click();
    }

    @Step("Наличие сообщения об ошибке")
    public String recieveMessage() {
        return errorMessage.shouldBe(visible).getText();
    }


}
