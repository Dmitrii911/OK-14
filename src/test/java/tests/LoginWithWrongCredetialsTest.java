package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithWrongCredetialsTest extends TestBase {
    private static LoginPage loginPage;

    @BeforeEach
    public void prepare(){
        open(baseUrl);
        //Принятие куки и политики
        loginPage = new LoginPage();
//        loginPage.acceptCookie();
//        loginPage.acceptPrivacyButton();

    }
    @Test
    @Tag("ok")
    @DisplayName("Тест входа с некорректными данными")
    public void loginTest(){
        //Попытка входа с некорректными данными
        loginPage.login("incorrectUser", "incorrectPassword");
       //проверка наличия сообщения об ошибке
        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");
        // Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Incorrect username and/or password";
        String actualErrorMessage = loginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "текст об ошибке не совпадает");

    }
}




