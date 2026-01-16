package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountCreatedPage;
import pages.AccountInfoPage;
import pages.HomePage;
import pages.SignupLoginPage;

public class TC04_LogoutUserTest extends BaseTest {

    @Test
    public void logoutUser() {

        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isHomePageVisible());

        home.clickSignupLogin();

        SignupLoginPage signupLogin = new SignupLoginPage(driver);
        
        Assert.assertTrue(signupLogin.isNewUserSignupVisible());

        // Create a fresh user
        String email = "user_" + System.currentTimeMillis() + "@testmail.com";
        signupLogin.signup("Harsh", email);

        AccountInfoPage accountInfo = new AccountInfoPage(driver);
        Assert.assertTrue(accountInfo.isAccountInfoVisible());
        accountInfo.fillAccountDetails();
        
        accountInfo.clickCreateAccount();

        AccountCreatedPage accountCreated = new AccountCreatedPage(driver);
        Assert.assertTrue(accountCreated.isAccountCreatedVisible());
        accountCreated.clickContinue();

        // Verify login
        Assert.assertTrue(home.isLoggedInAsVisible());

        // Logout
        home.clickLogout();

        // Verify navigation to login page
        Assert.assertTrue(signupLogin.isLoginHeadingVisible(), "'Login to your account' not visible");
    }
}
