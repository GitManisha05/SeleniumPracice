package udemy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class scrollingWebPageAndTableGridHandle {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void openGoogle() throws InterruptedException {


        driver.get("http://qaclickacademy.com/practice.php");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println("Page title is: " + driver.getTitle());

        //link count on webpage
       System.out.println(driver.findElements(By.tagName("a")).size());

       //JavaScript executor

        JavascriptExecutor js =  (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,450)");


        //Working with the table
        js.executeScript("document.querySelector('.tableFixHead').scrollTop = 500");
        //td:nth-child(4)\")");

        List<WebElement> allcount = driver.findElements(By.cssSelector(".tableFixHead th:nth-child(4)"));
        int sum =0;

        for(int i =0; i< allcount.size();i++){

            String text = allcount.get(i).getText();
            if(text.matches("\\d+")) {
                sum += Integer.parseInt(allcount.get(i).getText());
            }
        }

        System.out.println("SUM : " + sum);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}