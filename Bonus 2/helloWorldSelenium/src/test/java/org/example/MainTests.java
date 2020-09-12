package org.example;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MainTests extends BaseTest {
    private Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void beforeAll() {
        initDriver();
        initPages();
        driver.get(URL);
    }

    @AfterAll
    public static void afterAll() {
        takeScreenshot(driver, "target/SearchForNeighbourLast.png");
        driver.quit();
    }

    @SneakyThrows
    @Test
    public void playGame() {
        Thread.sleep(3_000);

        new Actions(driver).click(gamePage.getGameStage())
                .perform();

        String cmd = "ddddddvd";
        sendKeys(cmd);
        Thread.sleep(3_000);

        cmd = "aakkkkkkakkaaa";
        sendKeys(cmd);
        Thread.sleep(3_000);
        takeScreenshot(driver, "target/outOfHouse.png");

        cmd = "aaaaddddddddvvvvd";
        sendKeys(cmd);

        robot.keyPress(KeyEvent.VK_SPACE);
    }

    @SneakyThrows
    public void sendKeys(String cmds) {
        for (char c : cmds.toCharArray()) {
            sendKey(c);
            Thread.sleep(100);
        }
    }

    @SneakyThrows
    private void sendKey(char ch) {
        int keyEvent = -1;
        switch (ch) {
            case 'd':
                keyEvent = KeyEvent.VK_RIGHT;
                break;
            case 'k':
                keyEvent = KeyEvent.VK_LEFT;
                break;
            case 'a':
                keyEvent = KeyEvent.VK_DOWN;
                break;
            case 'v':
                keyEvent = KeyEvent.VK_UP;
                break;
        }
        robot.keyPress(keyEvent);
        Thread.sleep(100);
        robot.keyRelease(keyEvent);
    }
}
