package udemy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class spiceJetsleniumTest {


    @Test
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // Set the implicit wait time (in seconds)
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.spicejet.com/");

        driver.findElement(By.xpath("//div[text()='Login']")).click();


        WebElement userID = driver.findElement(By.xpath("//input[@class='css-1cwyjr8 r-homxoj r-13awgt0 r-ubezar r-tmtnm0 r-oxtfae r-10paoce r-ymttw5 r-9qu9m4' and @type='number']"));
        userID.sendKeys("9284412571");
        Assert.assertTrue(userID.isDisplayed(), "Expected input field is not displayed.");

        WebElement passward = driver.findElement(By.xpath("//input[@class='css-1cwyjr8 r-homxoj r-13awgt0 r-ubezar r-tmtnm0 r-oxtfae r-10paoce r-ymttw5 r-9qu9m4' and @type='password']"));
        passward.sendKeys("Manisha@2025");
        Assert.assertTrue(passward.isDisplayed(), "Expected input field is not displayed.");


        //login button "//div[@class='css-76zvg2 r-jwli3a r-n6v787 r-1kfrs79 r-q4m81j' and text() ='Log In']"
        //click on login button

        WebElement logIn = driver.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-n6v787 r-1kfrs79 r-q4m81j' and text()='Log In']"));
        logIn.click();


        System.out.println("test is passed.");

        driver.quit();
    }

    // @Test
    public void bookOneAwyTicket() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        ////div[@class='css-1dbjc4n r-19i43ro r-nsbfu8']

//        WebElement bookingwindow = driver.findElement(By.xpath("/div[@class='css-1dbjc4n r-19i43ro r-nsbfu8']"));
////        Assert.assertTrue(bookingwindow.isDisplayed(), "yes booking window is not displayed.");

        driver.quit();
    }


}
