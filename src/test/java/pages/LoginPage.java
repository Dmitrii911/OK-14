package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private SelenideElement usernameField = $(".field_email");
    private SelenideElement passwordField = $("[name = 'st.password']");
    private SelenideElement loginButton = $("[tsid=\"login-block21_input_9ad800\"]");
    private SelenideElement forgotPasswordLink = $("[data-l = 't,restore']");
    private SelenideElement registrationButton = $x("//div [@class='external-oauth-login-footer']/a[@data-l='t,register']");
    private SelenideElement qrCodeButton = $(".qr-code-button");
    private SelenideElement restoreButton = $(".lp");
    private SelenideElement inputSearch = $(".search-wrapper__4nym2");
    private SelenideElement vkButton = $("[data-l = 't,vkc']");
    private SelenideElement yandexButton = $(".social-icon");
    private SelenideElement mailRuButton = $("[data-l = 't,mailru']");
    private SelenideElement errorMessage = $(".input-e.login_error");
    private SelenideElement goToRecoveryButton = $("[tsid=\"restore\"]");

    {
        verifyUsernameFieldIsVisible();
        verifyPasswordFieldIsVisible();
        verifyLoginButtonIsVisible();
        verifyForgotPasswordLinkIsVisible();
        verifyRegistrationButtonIsVisible();
        verifyVkAuthButtonIsVisible();
        verifyYandexAuthButtonIsVisible();
        verifyMailRuAuthButtonIsVisible();
        verifyQrCodeButtonIsVisible();
        verifyRestoreButtonIsVisible();
        verifyInputSearchIsVisible();

    }

    @Step("Проверяем видимость поля ввода имени пользователя")
    private void verifyUsernameFieldIsVisible() {
        try {
            usernameField.shouldBe(visible);
        } catch (AssertionError e) {
            System.out.println("Ошибка видимости поля ввода имени пользователя");
            throw new AssertionError(e.getMessage());
        }
    }

    @Step("Проверяем видимость поля ввода пароля")
    public void verifyPasswordFieldIsVisible() {
        try {
            passwordField.shouldBe(visible);
        } catch (AssertionError e) {
            System.out.println("Ошибка видимости поля ввода пароля");
            throw new AssertionError(e.getMessage());
        }
    }

    @Step("Проверяем видимость кнопки входа")
    public void verifyLoginButtonIsVisible() {
        try {
            loginButton.shouldBe(visible);
        } catch (AssertionError e) {
            System.out.println("Ошибка видимости кнопки входа");
            throw new AssertionError(e.getMessage());
        }
    }

    @Step("Проверяем видимость ссылки 'Забыли пароль?'")
    public void verifyForgotPasswordLinkIsVisible() {
        try {
            forgotPasswordLink.shouldBe(visible);
        } catch (AssertionError e) {
            System.out.println("Ошибка видимости ссылки 'Забыли пароль?'");
            throw new AssertionError(e.getMessage());
        }
    }

    @Step("Проверяем видимость кнопки регистрации")
    public void verifyRegistrationButtonIsVisible() {
        try {
            registrationButton.shouldBe(visible);
        } catch (AssertionError e) {
            System.out.println("Ошибка видимости кнопки регистрации");
            throw new AssertionError(e.getMessage());
        }
    }

    @Step("Проверяем видимость кнопки авторизации VK")
    public void verifyVkAuthButtonIsVisible() {
        try {
            vkButton.shouldBe(visible);
        } catch (AssertionError e) {
            System.out.println("Ошибка видимости кнопки авторизации VK");
            throw new AssertionError(e.getMessage());
        }
    }

    @Step("Проверяем видимость кнопки авторизации Yandex")
    public void verifyYandexAuthButtonIsVisible() {
        try {
            yandexButton.shouldBe(visible);
        } catch (AssertionError e) {
            System.out.println("Ошибка видимости кнопки авторизации Yandex");
            throw new AssertionError(e.getMessage());
        }
    }

    @Step("Проверяем видимость кнопки авторизации Mail.ru")
    public void verifyMailRuAuthButtonIsVisible() {
        try {
            mailRuButton.shouldBe(visible);
        } catch (AssertionError e) {
            System.out.println("Ошибка видимости кнопки авторизации Mail.ru");
            throw new AssertionError(e.getMessage());
        }
    }

    @Step("Проверяем видимость QR-кода")
    public void verifyQrCodeButtonIsVisible() {
        try {
            qrCodeButton.shouldBe(visible);
        } catch (AssertionError e) {
            System.out.println("Ошибка видимости QR-кода");
            throw new AssertionError(e.getMessage());
        }
    }

    @Step("Проверяем видимость кнопки восстановления аккаунта")
    public void verifyRestoreButtonIsVisible() {
        try {
            restoreButton.shouldBe(visible);
        } catch (AssertionError e) {
            System.out.println("Ошибка видимости кнопки восстановления аккаунта");
            throw new AssertionError(e.getMessage());
        }
    }

    @Step("Проверяем видимость поля поиска")
    public void verifyInputSearchIsVisible() {
        try {
            inputSearch.shouldBe(visible);
        } catch (AssertionError e) {
            System.out.println("Ошибка видимости поля поиска");
            throw new AssertionError(e.getMessage());
        }
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

    @Step("Кликаем на вход по кр-коду")
    public void clickQrCode() {
        qrCodeButton.shouldBe(visible).click();
    }

    @Step("Кликаем на Не получается войти")
    public void clickRestoreButton() {
        restoreButton.shouldBe(visible).click();
    }
}