package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RandomJobPage {

    private WebDriver driver;
    private final By jobTitleLoc = By.xpath("//*[@id='job-post']//*[@class='col-lg-8']");
    private final WebDriverWait wait;
    private final By languageLoc = By.xpath("//*[@id='not_logged_menu']//li[8]");
    private final By languageRus = By.xpath("//*[@id='w4']//li[1]");

    public RandomJobPage(WebDriver driver) {
       this.driver=driver;
        wait = new WebDriverWait(driver, 20);
    }



    public String RandomJobSecondPageTitleMethod() {

        WebElement jobTitleElem = driver.findElement(jobTitleLoc);
        String jobTitleSecond = jobTitleElem.getText();
        System.out.println(jobTitleSecond);
        return jobTitleSecond;
    }

    public void languageChange() {
        Actions action = new Actions(driver);
        WebElement changeLanguageElem = driver.findElement(languageLoc);
        action.moveToElement(changeLanguageElem).perform();
        WebElement languageRusElem = wait.until(ExpectedConditions.elementToBeClickable(languageRus));
        languageRusElem.click();
    }

    public String checkTitleAfterChangeLanguage() {

        String jobTitleAfterChangeLanguage = driver.findElement(jobTitleLoc).getText();
        System.out.println(jobTitleAfterChangeLanguage);
        return jobTitleAfterChangeLanguage;
    }


    public void waitForLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitleLoc));

    }


}
