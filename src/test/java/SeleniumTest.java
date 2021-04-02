import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/***
 * Basic test in selenium+ testNG
 */
public class SeleniumTest {

    WebDriver driver;
    @BeforeTest
    void setUp(){
        System.out.println("Set up");
        System.setProperty("webdriver.chrome.driver","C:/WebDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
        System.out.println("Test");
    }

    @Test(priority = 1)
    void logoTest(){
        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
        Assert.assertTrue(webElement.isDisplayed(),"Logo not displayed");
    }

    @Test(priority = 2)
    void homePageTitle(){
        String title =  driver.getTitle();
        Assert.assertEquals("OrangeHRM",title,"Title is not matched");
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }


}
