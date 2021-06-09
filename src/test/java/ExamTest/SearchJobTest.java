package ExamTest;

import driver_manager.DriverSetter;
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
import url_manage.UrlSetter;

public class SearchJobTest {

    WebDriver driver;
    private String jobName = "Web/Graphic design";


    @BeforeSuite

    public void BeforeSuit() {
//        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe"); jnjvum e
        UrlSetter.setUrl();
    }

    @BeforeClass

    public void BeforeClassMethod() {
        DriverSetter.setDriver();
        driver=DriverSetter.getDriver();


        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void HomePage() {
        HomePage homePage=new HomePage(driver).open();
        SoftAssert softAssert = new SoftAssert();
        homePage.searchJob(jobName);
        JobPage page = new JobPage(driver);

        homePage.waitForLoad();
        page.waitForLoad();
        page.getTitleRandom();

        softAssert.assertNotNull(page.getButton(jobName), "doesn't checked");
        softAssert.assertEquals(page.getSize(), page.getCount(jobName), "jobs' counts don't match");
        page.NextPage();
        RandomJobPage randomJobPage = new RandomJobPage(driver);
        String secondTitleName = page.jobTitleFirstName();
        randomJobPage.waitForLoad();
        softAssert.assertEquals(randomJobPage.RandomJobSecondPageTitleMethod(), secondTitleName, "names don't match");
        randomJobPage.languageChange();
        softAssert.assertEquals(secondTitleName, randomJobPage.checkTitleAfterChangeLanguage(), "Titles don't match");
        softAssert.assertAll();
    }

    @AfterClass

    public void AfterClass() {
        driver.quit();
    }
}
