package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class ProfilePage {

    private final ElementsCollection listingCards = $$(".card");

    private SelenideElement card(String title) {
        return listingCards.findBy(Condition.text(title));
    }

    public EditListingPage openEditFor(String title) {
        card(title).$(".editButton").click();
        return new EditListingPage();
    }

    public void shouldHaveListing(String title) {
        card(title).shouldBe(Condition.visible);
    }

    public void shouldNotHaveListing(String title) {
        card(title).shouldNot(Condition.exist);
    }
}