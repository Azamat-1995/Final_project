package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class HeaderPage {

    private final SelenideElement authButton = $(byText("Вход и регистрация"));
    private final SelenideElement logoutButton = $(byText("Выйти"));

    public void openAuthModal() {
        authButton.click();
    }

    public void shouldBeLoggedIn() {
        logoutButton.shouldBe(Condition.visible);
    }
}
