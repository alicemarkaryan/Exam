package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private By searchLoc = By.xpath("//*[@id='jobsfilter-category']");
    private String jobName="'Web/Graphic design'";
    private By categoriesLoc = By.xpath("//option[text()="+jobName+"]");
    private By searchButtonLok = By.xpath("//*[@class='fa fa-search']");
    private WebDriverWait wait;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public void searchJob() {
        WebElement searchElem = driver.findElement(searchLoc);
        searchElem.click();
        WebElement jobElem =driver.findElement(categoriesLoc);
        jobElem.click();
        System.out.println(jobElem.getText());
        WebElement searchButtonElem = driver.findElement(searchButtonLok);
        searchButtonElem.click();
    }

    public void waitForLoad(){
        wait.until(ExpectedConditions.elementToBeClickable(searchLoc));
//        wait.until(ExpectedConditions.elementToBeClickable(categoriesLoc));
    }
}
