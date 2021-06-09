package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.WeakHashMap;

public class BasePageEpam {

    protected WebDriver driver;
    protected final String URl="https://www.epam.com/careers";
    public BasePageEpam(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
