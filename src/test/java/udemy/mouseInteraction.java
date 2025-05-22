package udemy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class mouseInteraction {
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
        Thread.sleep(200);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Actions a = new Actions(driver);
        WebElement searchBox = driver.findElement(By.id("a[id='nav-link-accountList']"));
        a.moveToElement(searchBox).build().perform();

        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("&&&")));

        if(dropdown.isDisplayed()){
            System.out.println("Dropdown Displayed");
        }else{
            System.out.println("DropDown Not displayed");
        }







    }

//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }
}