package ExamTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.JobPage;
import pages.RandomJobPage;

public class SearchJobTest {

    WebDriver driver;
    private String jobName = "Web/Graphic design";

    @BeforeSuite

    public void BeforeSuit() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeClass

    public void BeforeClassMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://staff.am");
    }

    @Test
    public void HomePage() {

        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);
        homePage.searchJob(jobName);
        JobPage page = new JobPage(driver);

        homePage.waitForLoad();
        page.waitForLoad();
        page.getTitleRandom();

        softAssert.assertNotNull(page.getButton(jobName), "doesn't checked");
        softAssert.assertEquals(page.getSize(), page.getCount(jobName), "jobs' counts don't match");
        page.NextPage();
        RandomJobPage randomJobPage = new RandomJobPage(driver);
        String secondTitleName = randomJobPage.RandomJobSecondPageTitleMethod();
        randomJobPage.waitForLoad();
        softAssert.assertEquals(page.jobTitleFirstName(), secondTitleName, "names don't match");
        randomJobPage.languageChange();
        softAssert.assertEquals(secondTitleName, randomJobPage.checkTitleAfterChangeLanguage(), "Titles don't match");
        softAssert.assertAll();
    }

    @AfterClass

    public void AfterClass() {
        driver.quit();
    }
}
