package org.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class LoginModal {

    private final SelenideElement modal = $(".popUp_shell__LuyqR");
    private final SelenideElement noAccountButton = modal.$(byText("Нет аккаунта"));
    private final SelenideElement emailInput = modal.$("input[name='email']");
    private final SelenideElement passwordInput = modal.$("input[name='password']");
    private final SelenideElement loginButton = modal.$("button[type='submit']");

    public RegistrationModal switchToRegistration() {
        noAccountButton.click();
        return new RegistrationModal();
    }

    public LoginModal fillForm(String email, String password) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
        return this;
    }

    public void submit() {
        loginButton.click();
    }
}