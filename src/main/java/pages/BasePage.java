package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import url_manage.UrlSetter;

abstract public class BasePage {

    protected WebDriver driver;

    protected final String BASE_URL = UrlSetter.getUrl();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
