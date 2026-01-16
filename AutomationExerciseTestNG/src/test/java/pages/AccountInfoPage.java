package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountInfoPage {

    WebDriver driver;
    WebDriverWait wait;

    public AccountInfoPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ----------- Locators ------------

    By enterAccountInfoText = By.xpath("//b[contains(.,'Enter Account Information')]");

    By titleMr = By.id("id_gender1");
    By password = By.id("password");

    By days = By.id("days");
    By months = By.id("months");
    By years = By.id("years");

    By newsletter = By.id("newsletter");
    By offers = By.id("optin");

    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By company = By.id("company");
    By address1 = By.id("address1");
    By address2 = By.id("address2");

    By country = By.id("country");
    By state = By.id("state");
    By city = By.id("city");
    By zipcode = By.id("zipcode");
    By mobileNumber = By.id("mobile_number");

    By createAccountBtn = By.xpath("//button[text()='Create Account']");
    //By createAccountBtn = By.cssSelector("button[data-qa='create-account']");

    // ----------- Methods ------------

    public boolean isAccountInfoVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(enterAccountInfoText))
                .isDisplayed();
    }

    public void fillAccountDetails() {

        // Title & Password
        clickUsingJS(titleMr);
        driver.findElement(password).sendKeys("Test@123");

        // DOB
        new Select(driver.findElement(days)).selectByValue("5");
        new Select(driver.findElement(months)).selectByValue("12");
        new Select(driver.findElement(years)).selectByValue("2001");

        // Checkboxes
        clickUsingJS(newsletter);
        clickUsingJS(offers);

        // Address Info
        driver.findElement(firstName).sendKeys("Harsh");
        driver.findElement(lastName).sendKeys("Agarwal");
        driver.findElement(company).sendKeys("Test Company");
        driver.findElement(address1).sendKeys("123 Test Street");
        driver.findElement(address2).sendKeys("Near Test Area");

        new Select(driver.findElement(country)).selectByVisibleText("India");

        driver.findElement(state).sendKeys("Delhi");
        driver.findElement(city).sendKeys("New Delhi");
        driver.findElement(zipcode).sendKeys("110001");
        driver.findElement(mobileNumber).sendKeys("9999999999");
    }

    public void clickCreateAccount() {
        clickUsingJS(createAccountBtn);
    }

    // ----------- Utility ------------

    private void clickUsingJS(By locator) {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        js.executeScript("arguments[0].click();", element);
    }
}

