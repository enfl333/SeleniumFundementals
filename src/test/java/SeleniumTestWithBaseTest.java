import com.flores.testframework.BasicSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/****
 *
 * Simple raw test af a login test case without any page object Model
 *
 */
public class SeleniumTestWithBaseTest extends BasicSeleniumTest {

    

   
    @Test
    void logInTest(){
        WebDriver driver = getDriver();
        //1. go to the main page
        driver.get("https://opensource-demo.orangehrmlive.com");
        //2. Find and enter the userName textField
        WebElement inputUserName = driver.findElement(By.id("txtUsername"));
        inputUserName.sendKeys("Admin");
        //3. Find the password field and enter the password
        WebElement inputPassword = driver.findElement(By.id("txtPassword"));
        inputPassword.sendKeys("admin123");
        //4. Find the Login Button and press it
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();

        String currentUrl = driver.getCurrentUrl();
        System.out.println("URL: "+currentUrl);
        Assert.assertTrue(currentUrl.contains("dashboard"));

    }



}
