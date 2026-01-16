package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountCreatedPage;
import pages.AccountInfoPage;
import pages.HomePage;
import pages.SignupLoginPage;

public class TC01_RegisterUserTest extends BaseTest {

    @Test
    public void registerUser() {

        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isHomePageVisible(), "Home page not visible");

        home.clickSignupLogin();

        SignupLoginPage signup = new SignupLoginPage(driver);
        Assert.assertTrue(signup.isNewUserSignupVisible(), "New User Signup not visible");

        signup.signup("Harsh101", "harsh1001@test.com");

        AccountInfoPage accountInfo = new AccountInfoPage(driver);
        Assert.assertTrue(accountInfo.isAccountInfoVisible(), "Account Info page not visible");

        accountInfo.fillAccountDetails();
        accountInfo.clickCreateAccount();

        AccountCreatedPage account = new AccountCreatedPage(driver);
        
        Assert.assertTrue(account.isAccountCreatedVisible(), "Account Created not visible");

        account.clickContinue();

        Assert.assertTrue(account.isLoggedInVisible(), "Logged in user not visible");

        account.deleteAccount();

        Assert.assertTrue(account.isAccountDeletedVisible(), "Account Deleted not visible");

    }
}
