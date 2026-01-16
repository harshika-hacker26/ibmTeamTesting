package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupLoginPage {

    WebDriver driver;
    WebDriverWait wait;
    
    public SignupLoginPage(WebDriver driver) {
    	this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
 // ---------- SignUp Section Locators ----------  

    By newUserText = By.xpath("//h2[text()='New User Signup!']");
    By nameField = By.name("name");
    By emailField = By.xpath("//input[@data-qa='signup-email']");
    By signupBtn = By.xpath("//button[text()='Signup']");
    By signupErrorMsg = By.xpath("//p[contains(text(),'Email Address already exist')]");

    

 // ---------- SignUp Methods ----------
    public boolean isNewUserSignupVisible() {
        return driver.findElement(newUserText).isDisplayed();
    }

    public void signup(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", signupBtn);
        
        driver.findElement(signupBtn).click();
        
        wait.until(ExpectedConditions.urlContains("/signup"));
    }
    
    public boolean isSignupErrorVisible() {
        return driver.findElements(signupErrorMsg).size() > 0;
    }

    
    
    
 // ---------- Login Section Locators ----------

    By loginHeading = By.xpath("//h2[text()='Login to your account']");
    By loginEmail = By.cssSelector("input[data-qa='login-email']");
    By loginPassword = By.cssSelector("input[data-qa='login-password']");
    By loginButton = By.cssSelector("button[data-qa='login-button']");
    By loginErrorMsg = By.xpath("//p[contains(text(),'Your email or password is incorrect')]");
    
    
 // ---------- Login Methods ----------

    public boolean isLoginHeadingVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginHeading))
                .isDisplayed();
    }

    public void login(String email, String password) {
        driver.findElement(loginEmail).sendKeys(email);
        driver.findElement(loginPassword).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isLoginErrorVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginErrorMsg))
                .isDisplayed();
    }
}
