package org.example.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.example.model.TestUser;
import org.example.pages.HeaderPage;

public class HomePageSteps {

    private final TestUser testUser;
    private final HeaderPage headerPage = new HeaderPage();

    public HomePageSteps(TestUser testUser) {
        this.testUser = testUser;
    }

    @Когда("пользователь нажимает кнопку \"Разместить объявление\" на главной странице")
    public void userOpensCreateListingForm() {
        headerPage.openCreateListingForm();
    }

    @Когда("пользователь ищет своё объявление на главной странице")
    public void userSearchesOwnListing() {
        headerPage.searchByName(testUser.getListingTitle(), testUser.getListingCategory());
    }

    @Тогда("объявление с указанным названием отображается в списке на главной странице")
    public void listingIsVisible() {
        headerPage.shouldSeeListingWithTitle(testUser.getListingTitle());
    }

    @Тогда("объявление отсутствует в списке на главной странице")
    public void listingIsAbsent() {
        headerPage.shouldNotSeeListingWithTitle(testUser.getListingTitle());
    }
}