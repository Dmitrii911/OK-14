package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomePage  {
    @Tag("ок")
    @Tag("property")
    @DisplayName("Проверка входа по QR")
        @Test
        void homeQr () {

            open("https://ok.ru/");

            $(".filter").$(byText("QR-код")).click();
            $(".qr_code_info_digest_info").
                    shouldHave(text("Ваш код авторизации: "));

        }

    @DisplayName("Вторая проверка входа по QR")
    @Test
    void homeQrq () {

        open("https://ok.ru/");

        $(".qr-code-button").$(byText("Войти по QR-коду")).click();
        $(".qr_code_info_digest_info").
                shouldHave(text("Ваш код авторизации: "));

    }
    @Test
    @DisplayName("Проверка входа через Не получается войти")
    void loginCode() {
        open("https://ok.ru/");

        $(".recovery-link").$(byText("Не получается войти?")).click();
        $(".add-stub").$(byText("Телефон")).click();
        $("#field_phone").setValue("79325350550").pressEnter();
        $("#smsCode").setValue("932535").pressEnter();
        Configuration.timeout = 3_000;
        $(".input-e").
                shouldHave(text("Неправильный код"));

    };
    @Test
    @DisplayName("Проверка входа через Yandex")
    public void testYandexEnter() {
        open("https://ok.ru/");
        $(".__yandex").click(); // отправка формы
        $(".+YtV-gg-KX5S1qALIHgMAg==")
                .shouldHave(text("Введите номер телефона"));
    }
}
