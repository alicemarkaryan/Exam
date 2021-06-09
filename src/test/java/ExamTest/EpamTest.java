package ExamTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.CareerPageEpam;
import pages.EpamHomePage;
import pages.HistoryEpamPage;

public class EpamTest {
    WebDriver driver;
    private String skillsStr = "Software Engineering/Technology";


    @BeforeSuite
    public void BeforSuit() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeClass
    public void BeforeClass() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @Test
    public void emapTest() throws InterruptedException {
        EpamHomePage page = new EpamHomePage(driver).open();
        page.waitForLoad();
        page.HomePageTest();
        CareerPageEpam pageSecond = new CareerPageEpam(driver);
        pageSecond.number();
        pageSecond.pageSecondTest();

        Assert.assertEquals(pageSecond.AllCountJobs(), pageSecond.NumberJobInt(), "jobs' count don't match");
        pageSecond.testForSecondPage();
        HistoryEpamPage pageTrd = new HistoryEpamPage(driver);
        pageTrd.TrdPageTest();
        Assert.assertFalse(pageTrd.TrdPageTest().isEmpty(), "text is empty");

    }

    @AfterClass
    public void AfterClass() {
        driver.quit();
    }
}
