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
    @FindBy(how = How.ID, using = "clips")
    public WebElement clipCount;

    @FindBy(how = How.ID, using = "btnMakePaperclip")
    public WebElement makePaperClips;

    @FindBy(how = How.ID, using = "btnLowerPrice")
    public WebElement lowerPrice;

    @FindBy(how = How.ID, using = "btnRaisePrice")
    public WebElement raisePrice;

    @FindBy(how = How.ID, using = "btnExpandMarketing")
    public WebElement marketingBtn;

    @FindBy(how = How.ID, using = "btnBuyWire")
    public WebElement wireBtn;

    @FindBy(how = How.ID, using = "btnMakeClipper")
    public WebElement autoClippersBtn;

    @FindBy(how = How.ID, using = "projectButton1")
    public WebElement improvisedAutoClippers;

    @FindBy(how = How.ID, using = "projectButton42")
    public WebElement revTrackerBtn;
    
    @FindBy(how = How.ID, using = "projectButton3")
    public WebElement creativityBtn;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public WebElement waitForAutoClicker() {
        By selector = By.id("btnMakeClipper");
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(selector));
    }
}
