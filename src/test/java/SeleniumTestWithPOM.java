import com.flores.testframework.BasicSeleniumTest;
import com.flores.testframework.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


/****
 *
 *  Login test case with page object Model for the LoginPage.
 *  Simple PageFactory.initElements is used. Can the Ajax be used as well?
 *  E.g PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
 *
 */
public class SeleniumTestWithPOM extends BasicSeleniumTest {


    @Test
    void logInTest(){
        //1. Init the Login page
        WebDriver driver = getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
        LoginPage loginPage= PageFactory.initElements(driver,LoginPage.class);

        // 2. Try to login
        loginPage.loginAction("Admin","admin123");

        // 3. Verify successful login
        String currentUrl = driver.getCurrentUrl();
        System.out.println("URL: "+currentUrl);
        Assert.assertTrue(currentUrl.contains("dashboard"));
    }

}
