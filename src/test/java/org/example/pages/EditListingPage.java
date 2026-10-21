package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class EditListingPage {

    private final SelenideElement nameInput = $("input[name='name']");
    private final SelenideElement saveButton = $("button[type='submit']");

    public EditListingPage changeName(String newName) {
        nameInput.click();
        nameInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), newName);
        nameInput.shouldHave(Condition.value(newName));
        return this;
    }

    public void save() {
        saveButton.scrollIntoView(true).click();
    }
}