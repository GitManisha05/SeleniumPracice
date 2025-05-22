import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class addItemsToCart {
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

        int checkBoxCount = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
        System.out.println("CheckBoxCount : " + checkBoxCount);


        WebElement checkbox = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));
        boolean isChecked = checkbox.isSelected();
        System.out.println("Is checkbox selected: " + isChecked);












    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}