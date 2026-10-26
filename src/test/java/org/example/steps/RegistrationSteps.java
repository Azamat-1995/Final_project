package org.example.steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.example.api.UserApiClient;
import org.example.data.UserDataGenerator;
import org.example.model.TestUser;
import org.example.pages.HeaderPage;
import org.example.pages.LoginModal;
import org.example.pages.RegistrationModal;

public class RegistrationSteps {

    private final TestUser testUser;
    private final HeaderPage headerPage = new HeaderPage();
    private RegistrationModal registrationModal;

    public RegistrationSteps(TestUser testUser) {
        this.testUser = testUser;
    }

    @Дано("пользователь уже зарегистрирован в системе")
    public void userAlreadyRegistered() {
        testUser.setEmail(UserDataGenerator.generateUniqueEmail());
        testUser.setPassword(UserDataGenerator.generatePassword());
        UserApiClient.registerUser(testUser);
    }

    @Когда("пользователь открывает форму регистрации")
    public void userOpensRegistrationForm() {
        headerPage.openAuthModal();
        registrationModal = new LoginModal().switchToRegistration();
    }

    @Когда("пользователь регистрируется с уникальными данными")
    public void userRegistersWithUniqueData() {
        testUser.setEmail(UserDataGenerator.generateUniqueEmail());
        testUser.setPassword(UserDataGenerator.generatePassword());

        registrationModal.fillForm(testUser.getEmail(), testUser.getPassword());
        registrationModal.submit();
    }

    @Когда("пользователь пытается зарегистрироваться с тем же email")
    public void userTriesToRegisterWithSameEmail() {
        registrationModal.fillForm(testUser.getEmail(), testUser.getPassword());
        registrationModal.submit();
    }

    @Тогда("регистрация проходит успешно")
    public void registrationIsSuccessful() {
        headerPage.shouldBeLoggedIn();
    }

    @Тогда("система сообщает об ошибке регистрации")
    public void systemShowsRegistrationError() {
        registrationModal.shouldShowError();
    }
}
