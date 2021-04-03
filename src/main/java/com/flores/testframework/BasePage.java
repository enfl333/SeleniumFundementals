package com.flores.testframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * What is PageFactory in Selenium?
 * ---------------------------------
 * Page Factory is a class provided by Selenium WebDriver to implement the Page Object Model.
 * Using it, you can initialize the Page Objects or directly
 * instantiate them. In simple words, the Page Object Model lets you create separate
 * java classes for different pages of a website.
 *
 * These different classes contain the locators for different
 * web elements (like button, text field, dropdown, etc.) present on the page and
 * the methods to perform actions on these elements.
 *
 * Another interesting concept offered by Page Factory is the lazy load concept using the
 * AjaxElementLocatorFactory.
 * It can be used when your application uses Ajax elements. Additionally, you can use
 * it while trying to find an element to perform an operation and pass a timeout value,
 * until which the driver would wait before throwing an exception. In other words,
 * it is a variant of implicit wait using the class AjaxElementLocatorFactory.
 *
 *
 * What are the Page Factory annotations?
 * Page Factory annotations are very descriptive and make the
 * code very readable
 *
 * @FindBy(id="userName")
 * WebElement username;
 *
 */
public class BasePage {

    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
    }

    protected void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }
}