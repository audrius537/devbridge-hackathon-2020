package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GamePage extends Base {
//    private static final By GAME_STAGE = By.tagName("body");
    private static final By GAME_STAGE = By.id("stage");

    public GamePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getGameStage() {
        return getDriver().findElement(GAME_STAGE);
    }
}
