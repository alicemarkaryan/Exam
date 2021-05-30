package ExamTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JobPage;

public class SearchJobTest {

    WebDriver driver;
    @BeforeMethod

    public void BeforeClass(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://staff.am");
    }

    @Test
    public void  HomePage() {

        HomePage homePage = new HomePage(driver);
        homePage.searchJob();

        JobPage page=new JobPage(driver);
        page.JobPage();

    }
    @AfterMethod

    public void AfterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
