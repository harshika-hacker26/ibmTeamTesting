package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By getInTouchText = By.xpath("//h2[text()='Get In Touch']");
    By nameInput = By.name("name");
    By emailInput = By.name("email");
    By subjectInput = By.name("subject");
    By messageTextarea = By.id("message");
    By uploadFileInput = By.name("upload_file");
    By submitButton = By.name("submit");
    By successMessage = By.xpath("//div[contains(@class,'status') and contains(text(),'Success!')]");
    By homeButton = By.xpath("//a[text()=' Home']");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isGetInTouchVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(getInTouchText)
        ).isDisplayed();
    }

    public void fillContactForm(String name, String email, String subject, String message) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(subjectInput).sendKeys(subject);
        driver.findElement(messageTextarea).sendKeys(message);
    }

    public void uploadFile(String filePath) {
        driver.findElement(uploadFileInput).sendKeys(filePath);
    }

    public void submitForm() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(submitButton));
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public boolean isSuccessMessageVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMessage)
        ).isDisplayed();
    }

    public void clickHomeButton() {
        wait.until(
                ExpectedConditions.elementToBeClickable(homeButton)
        ).click();
    }
}
