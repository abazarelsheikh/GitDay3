package tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
// login tests are maintained here.
//without Page object approch
public class LoginTests {

    ChromeDriver driver;

    // this process to setup the browser
   @BeforeClass
   public void setup(){

       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



   }

        // this process to logIn to the WebPage
        @Test

                public void loginTest1(){
            driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
            driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
            driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER);

            Assert.assertEquals(driver.getTitle(),"Web Orders");

        }
                // this process to logout of the WebPage
        @Test
        public void logOutTest(){

            loginTest1();

            driver.findElement(By.id("ctl00_logout")).click();

            Assert.assertEquals(driver.getTitle(),"Web Orders Login");

        }

        @AfterMethod
                // this process to close the browser
            public void cleanUp(){

            driver.close();

        }


    @Test
    public void negativeloginTest() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester2");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test2" + Keys.ENTER);
        String errorMsg = driver.findElement(By.id("ctl00_MainContent_status")).getText();

        Assert.assertEquals(errorMsg, "Invalid Login or Password.");
    }

}
