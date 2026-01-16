package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage {

    WebDriver driver;

    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[contains(text(),'Test Cases')]")
    private WebElement testCasesHeading;

    public boolean isTestCasesPageVisible() {
        return testCasesHeading.isDisplayed();
    }
}
