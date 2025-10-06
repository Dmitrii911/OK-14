package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.QrCodePage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class QrCodeTest extends TestBase {
    private static LoginPage loginPage;
    private static QrCodePage qrCodePage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    @Tag("ok")
    public void findQrCodeImage() {
        loginPage.clickQrCode();
        qrCodePage = new QrCodePage();
    }
}
