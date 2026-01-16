package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountDeletedPage {

    WebDriver driver;
    WebDriverWait wait;

    By accountDeletedText = By.xpath("//b[text()='Account Deleted!']");

    public AccountDeletedPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isAccountDeletedVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(accountDeletedText))
                .isDisplayed();
    }
}
