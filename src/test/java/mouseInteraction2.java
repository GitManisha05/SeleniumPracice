import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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


        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Page title is: " + driver.getTitle());

        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.id("a[id='nav-link-accountList']"))).build().perform();





    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}