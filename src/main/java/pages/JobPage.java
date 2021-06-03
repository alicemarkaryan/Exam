package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class JobPage extends BasePage{

    private String jobCheckStr = "//*[text()='%s']/following-sibling::span";
    private final By JobsLoc = By.xpath("//*[@class='job_list_company_title']");
    private String checkLocStr = "//*[@id='jobsfilter-category']//*[text()='%s']/preceding-sibling::input";
    private final WebDriverWait wait;
    private final By randomJobLoc = By.xpath("//*[@class='job-inner job-item-title']");
    private final By randomJobTitleLoc = By.xpath(".//*[@class='font_bold']");
    private String jobTitleFirst;
    private WebElement jobRandom;
    private String url="/en/jobs";

    public JobPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 20);
    }

    private WebElement CheckCount(String jobCount) {
        String job = String.format(jobCheckStr, jobCount);
        return driver.findElement(By.xpath(job));
    }

    public JobPage open(){
        driver.get(BASE_URL+url);
        return this;
    }

    private WebElement CheckButton(String jobCheck) {
        String button = String.format(checkLocStr, jobCheck);
        return driver.findElement(By.xpath(button));
    }

    public String getButton(String jobCheck) {
        System.out.println(CheckButton(jobCheck).getAttribute("checked"));
        return CheckButton(jobCheck).getAttribute("checked");

    }

    public int getCount(String jobCount) {
        String checkedStr = CheckCount(jobCount).getText().replaceAll("[^0-9]", "");
        System.out.println(Integer.parseInt(checkedStr));
        return Integer.parseInt(checkedStr);
    }

    public int getSize() {
        List<WebElement> JobList = driver.findElements(JobsLoc);
        System.out.println(JobList.size());
        return JobList.size();

    }

    public void getTitleRandom() {

        List<WebElement> randomJobElem = driver.findElements(randomJobLoc);
        Random random = new Random();
        int result = random.nextInt(randomJobElem.size());
        jobRandom = randomJobElem.get(result);
        WebElement jobRandomTitleElem = jobRandom.findElement(randomJobTitleLoc);
        jobTitleFirst = jobRandomTitleElem.getText();
        System.out.println(jobTitleFirst);

    }

    public String jobTitleFirstName() {
        return jobTitleFirst;
    }

    public void NextPage() {
        jobRandom.click();
    }

    public void waitForLoad() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(randomJobLoc, 5));
    }

}
