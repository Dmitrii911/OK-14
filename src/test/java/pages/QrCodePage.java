package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class QrCodePage {
    private final SelenideElement qrCodeImage = $(".qr_code_image_wrapper");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость QR-кода на странице")
    public void verifyPageElements() {
        qrCodeImage.shouldBe(visible);


    }
}
