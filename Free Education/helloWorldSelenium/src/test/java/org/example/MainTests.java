package org.example;

import lombok.SneakyThrows;
import org.example.utils.FileUtilHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.pages.CourseSearchPage.NEWEST_OPTION;

public class MainTests extends BaseTest {

    @BeforeAll
    public static void beforeAll() {
        initDriver();
        initPages();
        driver.get(URL);
    }

    @AfterAll
    public static void afterAll() {
        takeScreenshot(driver, "target/udemyLast.png");
        driver.quit();
    }

    @SneakyThrows
    @Test
    public void getPages() {
        courseSearchPage.getSortSelect().selectByVisibleText(NEWEST_OPTION);

        Thread.sleep(1_000);
        courseSearchPage.waitForLoadingSpinnerToDisappear();

        List<String> courseTitles = courseSearchPage.getCourseDetails(100);

        String titles = courseTitles.stream().reduce("", (someTitles, title) -> someTitles + title + '\n');
        FileUtilHelper.makeFileWithContent("target/newestFreeCourses.txt", titles);
    }
}
