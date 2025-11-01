package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public abstract class BasePage {
    protected SelenideElement headerLogo = Selenide.$("[tsid='toolbar_logo']");
    protected SelenideElement searchField = Selenide.$("[name='st.query']");
    protected SelenideElement vkServices = Selenide.$("[data-l='t,vk_ecosystem']");
    protected SelenideElement acceptPrivacyButton = Selenide.$(".cmptxt_btn_yes");
}

