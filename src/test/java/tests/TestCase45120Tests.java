package tests;

import annotations.Layer;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.fail;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Layer("e2e")
@Epic("Одностраничная форма")
@Feature("Авторизация")
@DisplayName("TestOps #45120 — Авторизация не проходит с неверным паролем")
public class TestCase45120Tests extends TestBase {

    private static final String TARGET_PAGE = "login.html?ru";

    @Test
    @AllureId("45120")
    @Tag("negative")
    @DisplayName("Авторизация не проходит с неверным паролем")
    void testCase45120Test() {
        step("Открыть страницу логина login.html", () ->
                open(TARGET_PAGE));

        step("Ввести user1 в поле логина", () ->
                $("[data-testid=login-input]").setValue("user1"));

        step("Ввести wrongpassword в поле пароля", () ->
                $("[data-testid=password-input]").setValue("wrongpassword"));

        step("Нажать кнопку submit", () ->
                $("[data-testid=submit-button]").click());

        step("Проверить сообщение об ошибке \"Wrong login or password\"", () ->
                $("[data-testid=error-message]").shouldHave(text("Неверный логин или пароль")));
    }
}
