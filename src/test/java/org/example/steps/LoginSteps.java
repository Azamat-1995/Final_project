package org.example.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.example.model.TestUser;
import org.example.pages.HeaderPage;
import org.example.pages.LoginModal;

public class LoginSteps {

    private final TestUser testUser;
    private final HeaderPage headerPage = new HeaderPage();
    private final LoginModal loginModal = new LoginModal();

    public LoginSteps(TestUser testUser) {
        this.testUser = testUser;
    }

    @Когда("пользователь открывает форму входа")
    public void userOpensLoginForm() {
        headerPage.openAuthModal();
    }

    @Когда("пользователь вводит email и пароль ранее зарегистрированного пользователя")
    public void userEntersCredentials() {
        loginModal.fillForm(testUser.getEmail(), testUser.getPassword());
    }

    @Когда("пользователь нажимает кнопку {string}")
    public void userClicksButton(String buttonText) {
        loginModal.submit();
    }

    @Тогда("пользователь авторизован успешно")
    public void userIsLoggedIn() {
        headerPage.shouldBeLoggedIn();
    }
}