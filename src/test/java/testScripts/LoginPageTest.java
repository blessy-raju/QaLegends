package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import dataProvider.DataProviders;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {
	@Test
	public void verifyValidUserLogin() {
		String userName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getNumericData(0, 1, "LoginPage");
		String expectedDropDownUserName = ExcelUtility.getStringData(2, 0, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		HomePage home = login.clickLoginButton();
		String actualDropDownUserName = home.getLoggedInUserName();
		Assert.assertEquals(actualDropDownUserName, expectedDropDownUserName, "Invalid user login");
	}

	@Test(dataProvider = "invalidUserData", dataProviderClass = DataProviders.class)
	public void verifyUserLoginWithInvalidCredentials(String userName, String password) {
		String expectedErrorMessage = ExcelUtility.getStringData(5, 0, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		String actualErrorMessage = login.getInvalidUserMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid error message");

	}
}