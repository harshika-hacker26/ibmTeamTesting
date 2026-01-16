package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountCreatedPage;
import pages.AccountInfoPage;
import pages.HomePage;
import pages.SignupLoginPage;

public class TC05_RegisterExistingUserTest extends BaseTest {

    @Test
    public void registerWithExistingEmail() {

        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isHomePageVisible());

        home.clickSignupLogin();

        SignupLoginPage signupLogin = new SignupLoginPage(driver);
        
        Assert.assertTrue(signupLogin.isNewUserSignupVisible());

        // First register a user
        String email = "existing_" + System.currentTimeMillis() + "@testmail.com";
        signupLogin.signup("Harsh11", email);

        AccountInfoPage accountInfo = new AccountInfoPage(driver);
        Assert.assertTrue(accountInfo.isAccountInfoVisible());
        accountInfo.fillAccountDetails();
        
        accountInfo.clickCreateAccount();

        AccountCreatedPage accountCreated = new AccountCreatedPage(driver);
        Assert.assertTrue(accountCreated.isAccountCreatedVisible());
        accountCreated.clickContinue();

        // Logout
        home.clickLogout();

        // Try registering again with SAME email
        signupLogin.signup("Harsh11", email);

        // Verify error message
        Assert.assertTrue(
                signupLogin.isSignupErrorVisible(),
                "Email Address already exist!"
        );
    }
}
