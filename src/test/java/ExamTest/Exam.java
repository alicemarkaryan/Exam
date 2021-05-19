package ExamTest;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import net.bytebuddy.dynamic.DynamicType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Exam {
    @Test
    public void testExam()  {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://staff.am/");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        By jobCategoElem = By.xpath("//*[@id='jobsfilter-category']");
        WebElement jobCatego = wait.until(ExpectedConditions.elementToBeClickable(jobCategoElem));
        jobCatego.click();
        By jobElem = By.xpath("//*[@id='jobsfilter-category']//child::option[4]");
        WebElement job = wait.until(ExpectedConditions.elementToBeClickable(jobElem));
        job.click();
        By searchElem = By.xpath("//*[@class='fa fa-search']");
        WebElement search = driver.findElement(searchElem);
        search.click();
        By countElem = By.xpath("//*[@id='jobsfilter-category']//child::label[4]");
        WebElement count = wait.until(ExpectedConditions.visibilityOfElementLocated(countElem));
        String countStr = count.getText();
        String countRep = countStr.replaceAll("[^0-9]", "");
        int countInt = Integer.parseInt(countRep);
        System.out.println(countInt);
        By allJobsElem = By.xpath("//*[@class='job_list_company_title']");
        List<WebElement> allJobs = wait.until(ExpectedConditions.numberOfElementsToBeLessThan(allJobsElem, 50));
        int elemCount = allJobs.size();
        System.out.println(elemCount);
        Assert.assertTrue(this.check(countInt, elemCount));
        driver.quit();
    }

    public boolean check(int a, int b) {
        return a == b;
    }
}
