package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class JobPage {
    private WebDriver driver;
    private String name="'Web/Graphic design'";
    private By jobCheckLoc = By.xpath("//*[text()="+name+"]/following-sibling::span");
    private By JobsLoc = By.xpath("//*[@class='job_list_company_title']");
    private By checkLoc = By.xpath("//*[@id='jobsfilter-category']//*[text()="+name+" ]/preceding-sibling::input");
    private WebDriverWait wait ;
    public JobPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }
    public String getButton() {
        WebElement button = driver.findElement(checkLoc);
        System.out.println(button.getAttribute("checked"));

        return button.getAttribute("checked");
    }
    public int getCount() {
        WebElement jobCount = driver.findElement(jobCheckLoc);
        String checkedStr = jobCount.getText().replaceAll("[^0-9]", "");
        System.out.println(Integer.parseInt(checkedStr));
        return Integer.parseInt(checkedStr);
    }
    public int getSize() {
        List<WebElement> JobList = driver.findElements(JobsLoc);
        System.out.println(JobList.size());
        return JobList.size();

    }

    public void waitForLoad(){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(JobsLoc,10));
    }
}
