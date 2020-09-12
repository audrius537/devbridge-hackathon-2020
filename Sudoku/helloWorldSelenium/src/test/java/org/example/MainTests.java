package org.example;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mariuszgromada.math.janetsudoku.SudokuSolver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MainTests extends BaseTest {

    @BeforeAll
    public static void beforeAll() {
        initDriver();
        initPages();
        driver.get(URL);
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @SneakyThrows
    @Test
    public void strategy1() {
        driver.switchTo().frame(mainPage.mainFrame);

        List<WebElement> rows = driver.findElements(By.cssSelector("table#puzzle_grid tr"));

        int[][] puzzle = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String value = rows.get(i).findElements(By.cssSelector("td input")).get(j).getAttribute("value");
                if (value.isEmpty()) {
                    value = "0";
                }
                puzzle[i][j] = Integer.parseInt(value);
            }
        }

        SudokuSolver solver = new SudokuSolver(puzzle);
        solver.solve();
        int[][] solvedPuzzle = solver.getSolvedBoard();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String field = String.valueOf(solvedPuzzle[i][j]);
                rows.get(i).findElements(By.cssSelector("td input")).get(j).sendKeys(field);
            }
        }
        mainPage.submitButton.click();

        Thread.sleep(5000);
        takeScreenshot(driver, "congratulationScreenshot.png");
    }
}
