package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HistoryEpamPage extends BasePageEpam {
    private WebDriverWait wait;
    List<String> allElem = new ArrayList<>();

    public HistoryEpamPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    private final List<WebElement> checkingElems = driver.findElements(By.xpath("//*[@class='column-control']//child::div"));


    public List<String> TrdPageTest() {
        for (WebElement elem : checkingElems) {
            allElem.add(elem.getText());
        }
        return allElem;

    }

}
