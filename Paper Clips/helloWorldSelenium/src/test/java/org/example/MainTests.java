package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainTests extends BaseTest {

    @BeforeAll
    public static void beforeAll() {
        initDriver();
        initPages();
        driver.get(URL);
    }

    @AfterAll
    public static void afterAll() {
        takeScreenshot(driver, "target/tenKScreenshot.png");
        driver.quit();
    }

    @Test
    public void strategy1() {
        WebElement make_paper_clips = mainPage.makePaperClips;

        for (int i = 0; i < 21; i++) {
            mainPage.lowerPrice.click();
        }


        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 1000; i++) {
                make_paper_clips.click();
            }

            wait.until(ExpectedConditions.elementToBeClickable(mainPage.wireBtn)).click();
        }
    }
}
