package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

// import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;

//    @BeforeSuite
//    public void setupSuite() {
//        WebDriverManager.chromedriver().setup();
//    }

    @BeforeMethod
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");
    }

    @AfterMethod
    public void closeBrowser() {
    	if (driver != null) {
            driver.quit();
        }
    }
}
