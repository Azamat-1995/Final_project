package org.example.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.example.data.UserDataGenerator;
import org.example.model.TestUser;
import org.example.pages.CreateListingPage;
import org.example.pages.HeaderPage;

public class CreateListingSteps {

    private final TestUser testUser;
    private final HeaderPage headerPage = new HeaderPage();
    private final CreateListingPage createListingPage = new CreateListingPage();

    public CreateListingSteps(TestUser testUser) {
        this.testUser = testUser;
    }

    @Когда("пользователь нажимает кнопку \"Разместить объявление\" на главной странице")
    public void userOpensCreateListingForm() {
        headerPage.openCreateListingForm();
    }

    @Когда("пользователь вводит название объявления")
    public void userEntersListingTitle() {
        testUser.setListingTitle(UserDataGenerator.generateListingTitle());
        createListingPage.fillName(testUser.getListingTitle());
    }

    @Когда("пользователь выбирает категорию {string}")
    public void userSelectsCategory(String category) {
        testUser.setListingCategory(category);
        createListingPage.selectCategory(category);
    }

    @Когда("пользователь публикует объявление")
    public void userPublishesListing() {
        createListingPage.publish();
    }

    @Тогда("объявление с указанным названием отображается в списке на главной странице")
    public void listingShouldBeVisibleInSearch() {
        headerPage.searchByName(testUser.getListingTitle(), testUser.getListingCategory());
        headerPage.shouldSeeListingWithTitle(testUser.getListingTitle());
    }
}