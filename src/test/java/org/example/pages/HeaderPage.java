package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {

    private final SelenideElement authButton = $(byText("Вход и регистрация"));
    private final SelenideElement logoutButton = $(byText("Выйти"));
    private final SelenideElement createListingButton = $(byText("Разместить объявление"));
    private final SelenideElement searchInput = $("input[name='name']");
    private final SelenideElement applyButton = $(byText("Применить"));
    private final CategoryDropdown categoryFilter = new CategoryDropdown();


    public void openAuthModal() {
        authButton.click();
    }

    public void shouldBeLoggedIn() {
        logoutButton.shouldBe(Condition.visible);
    }

    public CreateListingPage openCreateListingForm() {
        createListingButton.click();
        return new CreateListingPage();
    }

    public void searchByName(String query, String category) {
        categoryFilter.select(category);
        searchInput.scrollIntoView(true).setValue(query).shouldHave(Condition.value(query));
        applyButton.click();
    }

    public void shouldSeeListingWithTitle(String title) {
        $(byText(title)).shouldBe(Condition.visible);
    }

    private final SelenideElement profileButton = $("button.circleSmall");

    public void openProfile() {
        profileButton.click();
    }
    public ListingPage openListing(String title) {
        $(byText(title)).click();
        return new ListingPage();
    }

    public void shouldNotSeeListingWithTitle(String title) {
        $(byText(title)).shouldNot(Condition.exist);
    }
}