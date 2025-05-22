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
import java.util.concurrent.TimeUnit;


public class mouseInteraction2 {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void openGoogle() throws InterruptedException {


//        getText()
//        Purpose:
//        Retrieves the visible text (i.e., what you can see on the page) from an element.
//                Use Case:
//        When you want to verify labels, button names, links, or text content shown on the UI.
//
//        getAttribute(String attributeName)
//        //Retrieves the value of an attribute of an element (whether visible or hidden).
//        Useful when you want to check:
//
//        HTML attribute values like placeholder, value, href, src, class, type
//
//        Hidden text inside value attributes of input fields






        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Page title is: " + driver.getTitle());


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//div[@class='a4bIc']"))).build().perform();

        //div[@class='YacQv']
        //double click on searchbox
        a.moveToElement(driver.findElement(By.xpath("//div[@class='a4bIc']"))).click().keyDown(Keys.SHIFT).sendKeys("HELLO").doubleClick().build().perform();

        WebElement serachBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='a4bIc']")));

        String text = serachBox.getAttribute("HEllO)");


        if("HELLO".equals(text)){
            System.out.println("match");
        }else{
            System.out.println("not match");
        }











    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}