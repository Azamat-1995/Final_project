package org.example.steps;

import io.cucumber.java.ru.Когда;
import org.example.pages.HeaderPage;

public class ProfileSteps {

    private final HeaderPage headerPage = new HeaderPage();

    @Когда("пользователь переходит в свой профиль")
    public void userOpensProfile() {
        headerPage.openProfile();
    }
}