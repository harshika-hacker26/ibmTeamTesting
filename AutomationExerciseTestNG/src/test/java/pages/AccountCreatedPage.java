package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreatedPage {

    WebDriver driver;
    WebDriverWait wait;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    
    
    By accountCreatedText = By.xpath("//h2[@data-qa='account-created']");
    By continueBtn = By.xpath("//a[@data-qa='continue-button']");
    By loggedInUser = By.xpath("//a[contains(text(),'Logged in as')]");
    By deleteAccountBtn = By.xpath("//a[contains(text(),'Delete Account')]");
    By accountDeletedText = By.xpath("//h2[@data-qa='account-deleted']");

    public boolean isAccountCreatedVisible() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(accountCreatedText));
        return element.isDisplayed();
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    public boolean isLoggedInVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loggedInUser))
                .isDisplayed();
    }

    public void deleteAccount() {
        wait.until(
                ExpectedConditions.elementToBeClickable(deleteAccountBtn))
                .click();
    }

    public boolean isAccountDeletedVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(accountDeletedText))
                .isDisplayed();
    }
   
}
