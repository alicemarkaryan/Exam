package ExamTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JobPage;

public class SearchJobTest {

    WebDriver driver;

    @BeforeSuite

    public void BeforeSuit() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod

    public void BeforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://staff.am");
    }

    @Test
    public void HomePage() {

        HomePage homePage = new HomePage(driver);
        homePage.searchJob();
        JobPage page = new JobPag;
        homePage.waitForLoad();
        page.waitForLoad();
        Assert.assertNotNull(page.getButton(),"doesn't checked");
        Assert.assertEquals(page.getSize(), page.getCount(),"jobs' counts don't match");

    }

    @AfterMethod

    public void AfterClass() {
        driver.quit();
    }
}
