package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.TestCasesPage;

public class TC07_VerifyTestCasesPageTest {
  @Test
  public void verifyTestCasesPage() {

	    HomePage home = new HomePage(driver);
	    TestCasesPage testCases = new TestCasesPage(driver);

	    Assert.assertTrue(home.isHomePageVisible(),
	            "Home page is not visible");

	    home.clickTestCases();

	    Assert.assertTrue(testCases.isTestCasesPageVisible(),
	            "Test Cases page is not visible");
	}
}
