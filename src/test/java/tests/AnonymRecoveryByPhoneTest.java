package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AnonymRecoveryPage;
import pages.LoginPage;
import pages.StartPhoneLinkPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnonymRecoveryByPhoneTest extends TestBase {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static StartPhoneLinkPage startPhoneLinkPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    @Tag("ok")
    @DisplayName("Попытка входа с некорректными данными телефона")
    public void setAnonymRecoveryTest() {
        loginPage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 2; i++) {
            loginPage.loginWithPassword("1");
            loginPage.clickLogin();
        }
        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();
        startPhoneLinkPage = new StartPhoneLinkPage();
        String countryCode = startPhoneLinkPage.selectCountryByName("Russia");
        assertEquals("+7", countryCode, "Код страны не совпадает с ожидаемым");
        startPhoneLinkPage.recieveCode();
        startPhoneLinkPage.recieveMessage();
        String expectedErrorMessage = "Incorrect phone number.";
        String actualErrorMessage = startPhoneLinkPage.recieveMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage, "текст об ошибке не совпадает");

    }
}
