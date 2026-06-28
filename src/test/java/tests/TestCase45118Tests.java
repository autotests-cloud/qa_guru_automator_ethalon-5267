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
@DisplayName("TestOps #45118 — Успешная авторизация с валидными учётными данными")
public class TestCase45118Tests extends TestBase {

    private static final String TARGET_PAGE = "login.html?ru";

    @Test
    @AllureId("45118")
    @Tag("positive")
    @DisplayName("Успешная авторизация с валидными учётными данными")
    void testCase45118Test() {
        step("Открыть страницу логина login.html", () ->
                open(TARGET_PAGE));

        step("Ввести user1 в поле логина", () ->
                $("[data-testid=login-input]").setValue("user1"));

        step("Ввести password1 в поле пароля", () ->
                $("[data-testid=password-input]").setValue("password1"));

        step("Нажать кнопку submit", () ->
                $("[data-testid=submit-button]").click());

        step("Проверить текст приветствия \"Добро пожаловать, user1!\"", () ->
                $("[data-testid=welcome-message]").shouldHave(text("Добро пожаловать, user1!")));
    }
}
