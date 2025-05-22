package udemy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class windowHandleChildWindow {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void openGoogle() throws InterruptedException {


        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Page title is: " + driver.getTitle());


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /// click on the URI
        //a[@class='blinkingText'][1]

        driver.findElement(By.xpath("//a[@class='blinkingText'][1]")).click();

        Set<String> window = driver.getWindowHandles();

        Iterator<String> itr = window.iterator();
        String parentID = itr.next();
        String ChildID = itr.next();

        driver.switchTo().window(ChildID);

        driver.getTitle();

        driver.switchTo().window(parentID);
        driver.getTitle();
















    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}