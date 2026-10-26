package org.example.steps;

import io.cucumber.java.ru.Когда;
import org.example.data.UserDataGenerator;
import org.example.model.TestUser;
import org.example.pages.CreateListingPage;

public class CreateListingSteps {

    private final TestUser testUser;
    private final CreateListingPage createListingPage = new CreateListingPage();

    public CreateListingSteps(TestUser testUser) {
        this.testUser = testUser;
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
}