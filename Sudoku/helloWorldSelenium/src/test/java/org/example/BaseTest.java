package org.example;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.example.pages.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public abstract class BaseTest {
    private static final int WAIT_VALUE = 20;

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    protected static MainPage mainPage;
    protected static String URL = "https://www.websudoku.com/";

    @SneakyThrows
    protected static void takeScreenshot(WebDriver driver, String filePath) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(filePath));
    }

    protected static void initDriver() {
        var chromeDriverPath = "drivers/chromedriver.exe";
        //noinspection SpellCheckingInspection
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        //Set download directory
        ChromeOptions chromeOptions = new ChromeOptions();

        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, WAIT_VALUE);
    }

    protected static void initPages() {
        mainPage = new MainPage(driver, wait);
    }
}
