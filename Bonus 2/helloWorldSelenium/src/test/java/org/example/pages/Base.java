package org.example.pages;

import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base {
    @Getter(AccessLevel.PROTECTED)
    private WebDriver driver;

    @Getter(AccessLevel.PROTECTED)
    private WebDriverWait wait;

    public Base(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}
