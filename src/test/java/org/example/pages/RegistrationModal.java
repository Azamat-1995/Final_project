package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationModal {

    private final SelenideElement modal = $(".popUp_shell__LuyqR");
    private final SelenideElement emailInput = modal.$("input[name='email']");
    private final SelenideElement passwordInput = modal.$("input[name='password']");
    private final SelenideElement confirmPasswordInput = modal.$("input[name='submitPassword']");
    private final SelenideElement submitButton = modal.$(byText("Создать аккаунт"));
    private final SelenideElement errorLabel = $(".input_span__yWPqB");

    public RegistrationModal fillForm(String email, String password) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
        confirmPasswordInput.setValue(password);
        return this;
    }

    public void submit() {
        submitButton.click();
    }

    public RegistrationModal shouldShowError() {
        errorLabel.shouldBe(Condition.visible);
        return this;
    }
}
