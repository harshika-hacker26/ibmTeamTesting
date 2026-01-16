package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountCreatedPage;
import pages.AccountInfoPage;
import pages.HomePage;
import pages.SignupLoginPage;

public class TC03_LoginUserWithIncorrectCredentials extends BaseTest {

    @Test
    public void loginUserWithIncorrectCredentials() {

        HomePage home = new HomePage(driver);

        // Step 3
        Assert.assertTrue(home.isHomePageVisible(), "Home page not visible");

        home.clickSignupLogin();
        
        
        // Extra step to first create account so that we can login with not the same account
        
        SignupLoginPage signupLogin = new SignupLoginPage(driver);
        
        Assert.assertTrue(signupLogin.isNewUserSignupVisible());

        // Fill signup info
        String email = "test_" + System.currentTimeMillis() + "@testmail.com";
        String name = "test1";
        String password = "Test@123";

        signupLogin.signup(name, email);

        AccountInfoPage accountInfo = new AccountInfoPage(driver);
        Assert.assertTrue(accountInfo.isAccountInfoVisible());
        accountInfo.fillAccountDetails();
        
        accountInfo.clickCreateAccount();

        AccountCreatedPage accountCreated = new AccountCreatedPage(driver);
        Assert.assertTrue(accountCreated.isAccountCreatedVisible());

        accountCreated.clickContinue();
        
        // Verify login
        Assert.assertTrue(home.isLoggedInAsVisible());

        // Now we logout and try login
        home.clickLogout();
        
        
        // Step 4
        home.clickSignupLogin();

        SignupLoginPage loginPage = new SignupLoginPage(driver);

        // Step 5
        Assert.assertTrue(loginPage.isLoginHeadingVisible(),
                "'Login to your account' not visible");

        // Step 6 & 7
        loginPage.login(
                "wrongemail@test.com",
                password
        );

        // Step 8
        Assert.assertTrue(loginPage.isLoginErrorVisible(),
                "Error message not visible");
    }
}
