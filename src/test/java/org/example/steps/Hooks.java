package org.example.steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.config.Config;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Hooks {

    @Before
    public void setUp() {
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.baseUrl = Config.BASE_URL;
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        open("/");
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
