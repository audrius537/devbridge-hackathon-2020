package org.example.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

public class CourseSearchPage extends Base {
    public static final String NEWEST_OPTION = "Newest";

    private static final By SORT_SELECT = By.cssSelector(".udlite-form-group .udlite-select.udlite-text-md");
    private static final By COURSE_ROOT_ELEMS = By.xpath("//*[contains(@class,'course-list--container')]/a");
    private static final By COURSE_TITLE = By.xpath(".//*[contains(@class,'course-card--course-title')]");
    private static final By NEXT_PAGE_BTN = By.cssSelector("[aria-label=\"next page\"]");
    private static final By LOADING_SPINNER = By.xpath("//*[contains(@class, 'filter-container--show')]");

    public CourseSearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public Select getSortSelect() {
        WebElement rawElem = getWait().until(ExpectedConditions.visibilityOfElementLocated(SORT_SELECT));
        return new Select(rawElem);
    }

    public List<WebElement> getCoursesTitleElems() {
        return getDriver().findElements(COURSE_ROOT_ELEMS);
    }

    public WebElement getNextBtn() {
        return getDriver().findElement(NEXT_PAGE_BTN);
    }

    public void waitForLoadingSpinnerToDisappear() {
        getWait().until(loadingSpinnerToDisappear());
    }

    private ExpectedCondition<Boolean> loadingSpinnerToDisappear() {
        return driver -> driver.findElements(LOADING_SPINNER).isEmpty();
    }

    @SneakyThrows
    public List<String> getCourseDetails(int courseCount) {
        List<String> res = new LinkedList<>();

        List<WebElement> coursesTitles = getCoursesTitleElems();
        while (res.size() < courseCount) {
            if (coursesTitles.isEmpty()) {
                getNextBtn().click();
                Thread.sleep(1_000);
                coursesTitles = getCoursesTitleElems();
            }

            WebElement nextElem = coursesTitles.remove(0);
            String nextElemDetails = nextElem.getAttribute("href") + '\n' + nextElem.findElement(COURSE_TITLE).getText();
            res.add(nextElemDetails);
        }

        return res;
    }
}
