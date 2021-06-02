package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;
    private final By searchLoc = By.xpath("//*[@id='jobsfilter-category']");
    private final By searchButtonLok = By.xpath("//*[@class='fa fa-search']");
    private final WebDriverWait wait;
    private String filterLoc = "//option[text()='%s']";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    private WebElement getFilterTetElement(String jobName) {
        String actualText = String.format(filterLoc, jobName);
        return driver.findElement(By.xpath(actualText));
    }

    public void searchJob(String jobName) {

        WebElement searchElem = driver.findElement(searchLoc);
        searchElem.click();
        getFilterTetElement(jobName).click();
        WebElement searchButtonElem = driver.findElement(searchButtonLok);
        searchButtonElem.click();

    }


    public void waitForLoad() {
        wait.until(ExpectedConditions.elementToBeClickable(searchLoc));
    }
}
