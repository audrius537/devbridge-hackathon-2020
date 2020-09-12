package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Base {
    @FindBy(how = How.CSS, using = "frameset frame")
    public WebElement mainFrame;

    @FindBy(how = How.CSS, using = "input[name='submit']")
    public WebElement submitButton;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public WebElement waitForAutoClicker() {
        By selector = By.id("btnMakeClipper");
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(selector));
    }
}
