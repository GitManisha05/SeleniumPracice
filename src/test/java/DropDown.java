import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class DropDown {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void openGoogle() throws InterruptedException {


        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Page title is: " + driver.getTitle());

        //get static dropdown
        WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        //select element in dropdown
        Select dropDown = new Select(staticDropDown);
        dropDown.selectByIndex(3);
        System.out.println(dropDown.getFirstSelectedOption().getText());


        //Latest dropDown looping
        driver.findElement(By.id("divpaxinfo"));
        Thread.sleep(2000l);
        for(int i =0; i< 5; i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }





    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}