package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;

public class CareerPageEpam extends BasePageEpam {

    @FindBy(xpath = "//*[@class='search-result__heading']")
    private WebElement numberJob;
    String numberJobStr = numberJob.getText();
    String numberJobCount = numberJobStr.replaceAll("[^0-9]", "");


    WebDriverWait wait;

    @FindBy(xpath = "//*[@class='font-size-14']")
    private WebElement scrollTill;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    int allCountJobs;

    public CareerPageEpam(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(xpath = "//*[@href='/about']")
    private WebElement aboutElem;

    @FindBy(xpath = "//a[text()='History']")
    private WebElement historyElem;


    @FindBy(xpath = "//*[@class='search-result__view-more']")
    private WebElement viewMoreElem;
    int numberJobInt;

    public void number() {

        if (numberJobCount.isEmpty()) {

            numberJobInt = 0;
        } else {
            numberJobInt = Integer.parseInt(numberJobCount);
        }
    }

    public int NumberJobInt() {
        return numberJobInt;
    }

    public void pageSecondTest() throws InterruptedException {
        System.out.println(numberJobInt);
        js.executeScript("arguments[0].scrollIntoView(true);", scrollTill);
        Thread.sleep(5000);
        List<WebElement> allcountJobsElem = driver.findElements(By.xpath("//li[@class='search-result__item']"));
        allCountJobs = allcountJobsElem.size();
        if (numberJobInt > 40) {
            viewMoreElem.click();
            js.executeScript("arguments[0].scrollIntoView(true);", scrollTill);
            Thread.sleep(5000);
            allcountJobsElem = driver.findElements(By.xpath("//li[@class='search-result__item']"));
            allCountJobs = allcountJobsElem.size();
            System.out.println(allCountJobs);
        } else {
            System.out.println(allCountJobs);

        }
    }

    public int AllCountJobs() {
        return allCountJobs;
    }

    Actions actions = new Actions(driver);

    public void testForSecondPage() {
        actions.moveToElement(aboutElem).perform();
        historyElem.click();
    }

    public void waitForLoad() {
        wait.until(ExpectedConditions.elementToBeClickable(historyElem));
    }

}
