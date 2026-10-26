package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CategoryDropdown {

    private static final int OPEN_ATTEMPTS = 3;

    private final SelenideElement dropdown =
            $("input[name='category']").closest(".dropDownMenu_dropMenu__sBxhz");

    public void select(String category) {
        SelenideElement arrow = dropdown.$("button").scrollIntoView(true);
        SelenideElement option = dropdown.$(byText(category));

        open(arrow, option);
        option.click();
        dropdown.$("input[name='category']").shouldHave(Condition.value(category));
    }

    private void open(SelenideElement arrow, SelenideElement option) {
        for (int attempt = 1; attempt <= OPEN_ATTEMPTS; attempt++) {
            arrow.click();
            try {
                option.shouldBe(Condition.visible, Duration.ofSeconds(2));
                return;
            } catch (AssertionError e) {
                if (attempt == OPEN_ATTEMPTS) {
                    throw e;
                }
            }
        }
    }
}