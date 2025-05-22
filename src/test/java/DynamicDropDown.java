import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class DynamicDropDown {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void openGoogle() throws InterruptedException {


        driver.get("https://www.spicejet.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Page title is: " + driver.getTitle());

        //Departure
//        driver.findElement(By.xpath("//input[@class='css-1cwyjr8 r-1yadl64 r-cqee49 r-1b43r93 r-1pi2tsx r-10paoce r-8zlnwy r-1k6034g']")).click();
//        driver.findElement(By.xpath("//div[text()='DEL - Delhi, India'][1]")).click();

        //arrival
        driver.findElement(By.xpath("//input[@class='css-1cwyjr8 r-1yadl64 r-cqee49 r-1b43r93 r-1pi2tsx r-10paoce r-8zlnwy r-1k6034g']")).click();
        driver.findElement(By.xpath("//div[text()='Raja Bhoj Airport']")).click();



    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}