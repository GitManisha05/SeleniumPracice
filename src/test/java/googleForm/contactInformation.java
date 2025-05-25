package googleForm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class contactInformation {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void openGoogle() throws InterruptedException {

        String emailID = System.getenv("EMAILID");
        String passWard = System.getenv("PASSWARD");

        driver.get("https://docs.google.com/forms/u/0/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Page title is: " + driver.getTitle());

        System.out.println(driver.getTitle());


        //eneter emailID
        driver.findElement(By.id("identifierId")).sendKeys(emailID);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       WebElement nextButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
       if(nextButton.isDisplayed()){
           nextButton.click();
       };

       try{
           if(nextButton.isDisplayed()) {
               nextButton.click();
           }
       } catch(Exception e){
       System.out.println("Some other exception occurred: " + e.getMessage());
       }
       Thread.sleep(2000);

       System.out.println("Pagea after email eneter : " + driver.getTitle());

       // WebElement passWardPlaceHolder=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Enter your password']")));
        driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(passWard);

        Thread.sleep(2000);

        nextButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
        if(nextButton.isDisplayed()){
            nextButton.click();
        };

//        //formPage:
//        driver.findElement(By.id(":30")).click();
//        Thread.sleep(2000);

//        System.out.println("formPage should be diaplyed : " + driver.getTitle());
//        Thread.sleep(30);

        //click on contact form
        //div[@class='docs-homescreen-fcc-content']//div[text()="Contact Information"]

        driver.findElement(By.xpath("//div[@class='docs-homescreen-fcc-content']//div[text()=\"Contact Information\"]")).click();
        Thread.sleep(30);


    }






    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}