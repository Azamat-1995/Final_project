package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CreateListingPage {

    private final SelenideElement nameInput = $("input[name='name']");
    private final SelenideElement publishButton = $("button[type='submit']");
    private final CategoryDropdown categoryDropdown = new CategoryDropdown();

    public CreateListingPage fillName(String name) {
        nameInput.setValue(name);
        return this;
    }

    public CreateListingPage selectCategory(String category) {
        categoryDropdown.select(category);
        return this;
    }

    public void publish() {
        publishButton.scrollIntoView(true).click();
        $("form.createListing_shell__A5EA7").shouldNot(Condition.exist);
    }
}