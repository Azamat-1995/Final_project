package org.example.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.example.data.UserDataGenerator;
import org.example.model.TestUser;
import org.example.pages.EditListingPage;
import org.example.pages.HeaderPage;
import org.example.pages.ProfilePage;

public class EditListingSteps {

    private final TestUser testUser;
    private final HeaderPage headerPage = new HeaderPage();
    private final ProfilePage profilePage = new ProfilePage();
    private EditListingPage editListingPage;
    private String oldTitle;

    public EditListingSteps(TestUser testUser) {
        this.testUser = testUser;
    }

    @Когда("пользователь нажимает на карандаш своего объявления")
    public void userClicksEditOnOwnListing() {
        editListingPage = profilePage.openEditFor(testUser.getListingTitle());
    }

    @Когда("пользователь меняет название объявления на новое")
    public void userChangesListingTitle() {
        oldTitle = testUser.getListingTitle();
        testUser.setListingTitle(UserDataGenerator.generateListingTitle());
        editListingPage.changeName(testUser.getListingTitle());
    }

    @Когда("пользователь сохраняет изменения")
    public void userSavesChanges() {
        editListingPage.save();
    }

    @Тогда("в профиле отображается объявление с новым названием")
    public void profileShowsListingWithNewTitle() {
        headerPage.openProfile();
        profilePage.shouldHaveListing(testUser.getListingTitle());
        profilePage.shouldNotHaveListing(oldTitle);
    }
}