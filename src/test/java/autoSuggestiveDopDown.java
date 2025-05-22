import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class autoSuggestiveDopDown {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void openGoogle() throws InterruptedException {


        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Page title is: " + driver.getTitle());

        driver.findElement(By.id("autosuggest")).click();
        driver.findElement(By.id("autosuggest")).sendKeys("IND");

        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for(WebElement option : options){

            if(option.getText().equalsIgnoreCase("INDIA")){
              option.click();
              break;
            }

        }




    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}