package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.RestorePage;
import pages.SupportDialogPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class SupportTest extends TestBase {
    private static LoginPage loginPage;
    private static RestorePage restorePage;
    private static SupportDialogPage supportDialogPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    @Tag("ok")
    @DisplayName("Проверка Support")
    public void goToSupport() {
        loginPage.clickRestoreButton();
        restorePage = new RestorePage();
        restorePage.clickSupport();
        supportDialogPage = new SupportDialogPage();
        supportDialogPage.clickbuttonCancel();
    }
}
