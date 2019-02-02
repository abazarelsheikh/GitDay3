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

public class LoginTests {

    ChromeDriver driver;

   @BeforeClass
   public void setup(){

       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



   }


        @Test

                public void loginTest1(){
            driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
            driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
            driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER);
            String title = driver.getTitle();
            Assert.assertEquals(driver.getTitle(),"Web Orders");

        }

        @Test
        public void logOutTest(){

            loginTest1();

            driver.findElement(By.id("ctl00_logout")).click();
                        String title = driver.getTitle();

            Assert.assertEquals(driver.getTitle(),"Web Orders Login");

        }

        @AfterMethod

            public void cleanUp(){

            driver.close();

        }

}
