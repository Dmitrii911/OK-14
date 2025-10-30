package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    //Примеры общих элементов, которые могут использоваться на различных страницах
    protected SelenideElement headerLogo = Selenide.$("[tsid='toolbar_logo']");
    protected SelenideElement searchField = Selenide.$("[name='st.query']");
    protected SelenideElement vkServices = Selenide.$("[data-l='t,vk_ecosystem']");
    protected SelenideElement acceptPrivacyButton = Selenide.$(".cmptxt_btn_yes");

    @Step("Метод поиска по сайту")
    public void search(String query) {
        searchField.shouldBe(Condition.visible).setValue(query).pressEnter();
    }

    @Step("Открываем VK Services")
    public void openVkServices() {
        vkServices.shouldBe(Condition.visible).click();
    }

    @Step("Клик на логотип ОК")
    public void clickLogo() {
        headerLogo.shouldBe(Condition.visible).click();

    }

    @Step("Принимаем конфиденциальности")
    public void acceptPrivacyButton() {
        acceptPrivacyButton.shouldBe(Condition.visible).click();

    }
}

