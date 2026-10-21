package org.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ListingPage {

    private final SelenideElement deleteButton = $(byText("Удалить"));

    public void delete() {
        deleteButton.scrollIntoView(true).click();
    }
}