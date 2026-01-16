  package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By homePageSlider = By.id("slider-carousel");
    By signupLoginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");
    By loggedInAsText = By.xpath("//a[contains(text(),'Logged in as')]");
    By logoutBtn = By.xpath("//a[text()=' Logout']");
    By deleteAccountBtn = By.xpath("//a[text()=' Delete Account']");
    By contactUsBtn = By.xpath("//a[text()=' Contact us']");
    By testCasesBtn = By.xpath("//a[contains(text(),'Test Cases')]");

  
    public boolean isHomePageVisible() {
//        return driver.getTitle().contains("Automation Exercise");
        
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(homePageSlider))
                .isDisplayed();
    }

    public void clickSignupLogin() {
//        driver.findElement(signupLoginBtn).click();
    	wait.until(
                ExpectedConditions.elementToBeClickable(signupLoginBtn))
                .click();
    }
    
    public boolean isLoggedInAsVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loggedInAsText))
                .isDisplayed();
    }
    
    public void clickLogout() {
        wait.until(
            ExpectedConditions.elementToBeClickable(logoutBtn)
        ).click();
    }

    public void clickDeleteAccount() {
//        driver.findElement(deleteAccountBtn).click();
        wait.until(
                ExpectedConditions.elementToBeClickable(deleteAccountBtn))
                .click();
    }
    
    public void clickContactUs() {
        wait.until(ExpectedConditions.elementToBeClickable(contactUsBtn)).click();
    }
    
    public void clickTestCases() {
    	wait.until(ExpectedConditions.elementToBeClickable(testCasesBtn)).click();
    }
}
