package udemy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class linkCount {
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


       //Limit scope to the footer section
       WebElement footerSection = driver.findElement(By.id("gf-BIG"));
       List<WebElement> countLink = (footerSection.findElements(By.tagName("a")));
        String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);

       for(int i =0; i < countLink.size() ; i++){

           countLink.get(i).sendKeys(clickOnLink);
           Thread.sleep(1000); // Optional: allow tab to open smoothly

       }







    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}