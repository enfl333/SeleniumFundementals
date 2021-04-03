package com.flores.testframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/***
 *        By Using PageFactory we replace the below by annotations and the
 *        the factory pattern
 *
 *        //1. go to the main page
 *         driver.get("https://opensource-demo.orangehrmlive.com");
 *         //2. Find and enter the userName textField
 *         WebElement inputUserName = driver.findElement(By.id("txtUsername"));
 *         inputUserName.sendKeys("Admin");
 *         //3. Find the password field and enter the password
 *         WebElement inputPassword = driver.findElement(By.id("txtPassword"));
 *         inputPassword.sendKeys("admin123");
 *         //4. Find the Login Button and press it
 *         WebElement loginButton = driver.findElement(By.id("btnLogin"));
 *         loginButton.click();
 *
 */
public class LoginPage extends BasePage{


    @FindBy(id = "txtUsername")
    WebElement userName;

    @FindBy(id = "txtPassword")
    WebElement password;

    @FindBy(id = "btnLogin")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginAction(String  uName, String passWd){
        userName.sendKeys(uName);
        password.sendKeys(passWd);
        loginButton.click();

    }

}
