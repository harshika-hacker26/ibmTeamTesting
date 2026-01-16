package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactUsPage;
import pages.HomePage;

public class TC06_ContactUsFormTest extends BaseTest {

    @Test
    public void contactUsFormSubmission() {

        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isHomePageVisible());

        home.clickContactUs();

        ContactUsPage contact = new ContactUsPage(driver);
        Assert.assertTrue(contact.isGetInTouchVisible());

        contact.fillContactForm(
                "Harsh Agarwal",
                "harsh@testmail.com",
                "Automation Testing",
                "This is a test message from Selenium automation."
        );

        // Upload file (ensure file exists)
        String filePath = "C:\\Users\\HarshAgarwal\\Downloads\\DECTAB_Exercises.pdf";
        contact.uploadFile(filePath);

        contact.submitForm();

        // Handle alert
        contact.acceptAlert();

        Assert.assertTrue(
                contact.isSuccessMessageVisible(),
                "Success message not visible"
        );

        contact.clickHomeButton();

        Assert.assertTrue(home.isHomePageVisible());
    }
}
