package org.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class LoginModal {

    private final SelenideElement noAccountButton = $(byText("Нет аккаунта"));

    public RegistrationModal switchToRegistration() {
        noAccountButton.click();
        return new RegistrationModal();
    }
}
