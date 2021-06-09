package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EpamHomePage extends BasePageEpam {

    @FindBy(xpath = "//button[@class='button-ui bg-color-light-blue cookie-disclaimer__button']")
    private WebElement acceptElem;

    @FindBy(xpath = "//span[@class='selection']")
    private WebElement locationSearchElem;


    @FindBy(xpath = "//*[@class='select2-results__option select2-results__option--highlighted']")
    private WebElement locationElem;
    private final WebDriverWait wait;
    private final String url = "/";


    @FindBy(xpath = "//div[@class='default-label']")
    private WebElement skills;

    @FindBy(xpath = "//form[@id='jobSearchFilterForm']//div[text()='All Skills']")
    private WebElement job;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitElem;


    public EpamHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public EpamHomePage open() {
        driver.get(URl + url);
        return this;
    }

    public void HomePageTest() {
        System.out.println(job.getText());
        acceptElem.click();
        locationSearchElem.click();
        locationElem.click();
        skills.click();
        job.click();
        submitElem.click();

    }


    public void waitForLoad() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptElem));
////        wait.until(ExpectedConditions.visibilityOfElementLocated(countryLoc));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='multi-select-dropdown-container']")));
//        wait.until(ExpectedConditions.elementToBeClickable(job));
    }

}
