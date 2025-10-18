package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private SelenideElement usernameField = $("[name = 'st.email']");
    private SelenideElement passwordField = $("[name = 'st.password']");
    private SelenideElement loginButton = $("[data-l = 't,sign_in']");
    private SelenideElement forgotPasswordLink = $("[data-l = 't,restore']");
    private SelenideElement registrationButton = $x("//div [@class='external-oauth-login-footer']/a[@data-l='t,register']");
    private SelenideElement qrCodeButton = $(".qr-code-button");
    private SelenideElement restoreButton = $(".lp");
    private SelenideElement inputSearch = $(".search-wrapper__4nym2");

    //Локаторы для кнопок соцсетей
    private SelenideElement vkButton = $("[data-l = 't,vkc']");
    private SelenideElement yandexButton = $(".social-icon");
    private SelenideElement mailRuButton = $("[data-l = 't,mailru']");

    //Локатор для элемента текста с ошибкой
    private SelenideElement errorMessage = $(".input-e.login_error");

    // Локатор для восстановления пароля
    private SelenideElement goToRecoveryButton = $("[tsid=\"restore\"]");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        yandexButton.shouldBe(visible);
        mailRuButton.shouldBe(visible);
        qrCodeButton.shouldBe(visible);
        restoreButton.shouldBe(visible);
        inputSearch.shouldBe(visible);


    }

    @Step("Проверяем видимость сообщение об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщение об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Входим на сайт с логином и паролем")
    public void login(String username, String password) {
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Клик на кнопку Войти")
    public void clickLogin() {
        loginButton.shouldBe(visible).click();
    }

    @Step("Нажимаем восстановить профиль")
    public void goToRecovery() {
        goToRecoveryButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт с логином")
    public void loginWithUsername(String username) {
        usernameField.shouldBe(visible).setValue(username);
        loginButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт с паролем")
    public void loginWithPassword(String password) {
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Переходим наа страницу восстановления пароля")
    public void openForgotPasswordPage() {
        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step("Переходим наа страницу регистрации")
    public void openRegistrationPage() {
        registrationButton.shouldBe(visible).click();
    }

    //Методы для перехода для регистрации через страницы соцсети
    @Step("Вход черещ ВК")
    public void openwithVK() {
        vkButton.shouldBe(visible).click();
    }

    @Step("Вход черещ google")
    public void openwithGoogle() {
        yandexButton.shouldBe(visible).click();
    }

    @Step("Вход черещ mail.ru")
    public void openwithMailRu() {
        mailRuButton.shouldBe(visible).click();
    }

    @Step("Кликаем на вход по кр-коду")
    public void clickQrCode() {
        qrCodeButton.shouldBe(visible).click();
    }

    @Step("Кликаем на Не получается войти")
    public void clickRestoreButton() {
        restoreButton.shouldBe(visible).click();
    }

//    @Step("Вводим значение в поисковик")
//    public void setValueToInput(value) {
//        inputSearch.shouldBe(visible).setValue(value);
//    }
}