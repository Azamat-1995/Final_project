package org.example.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.example.model.TestUser;
import org.example.pages.HeaderPage;
import org.example.pages.ListingPage;

public class DeleteListingSteps {

    private final TestUser testUser;
    private final HeaderPage headerPage = new HeaderPage();
    private ListingPage listingPage;

    public DeleteListingSteps(TestUser testUser) {
        this.testUser = testUser;
    }

    @Когда("пользователь ищет своё объявление на главной странице")
    public void userSearchesOwnListing() {
        headerPage.searchByName(testUser.getListingTitle(), testUser.getListingCategory());
    }

    @Когда("пользователь открывает своё объявление")
    public void userOpensOwnListing() {
        listingPage = headerPage.openListing(testUser.getListingTitle());
    }

    @Когда("пользователь удаляет объявление")
    public void userDeletesListing() {
        listingPage.delete();
    }

    @Тогда("объявление отсутствует в списке на главной странице")
    public void listingIsAbsent() {
        headerPage.shouldNotSeeListingWithTitle(testUser.getListingTitle());
    }
}