package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import dataProvider.DataProviders;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {
	@Test(groups = "Smoke")
	public void verifyValidUserLogin() {
		String userName = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelUtility.getNumericData(0, 1, Constants.LOGIN_PAGE);
		String expectedDropDownUserName = ExcelUtility.getStringData(2, 0, Constants.LOGIN_PAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		HomePage home = login.clickLoginButton();
		String actualDropDownUserName = home.getLoggedInUserName();
		Assert.assertEquals(actualDropDownUserName, expectedDropDownUserName, Messages.INVALID_USER);
	}

	@Test(dataProvider = "invalidUserData", dataProviderClass = DataProviders.class, groups = "Regression")
	public void verifyUserLoginWithInvalidCredentials(String userName, String password) {
		String expectedErrorMessage = ExcelUtility.getStringData(5, 0, Constants.LOGIN_PAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		String actualErrorMessage = login.getInvalidUserMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, Messages.INVALID_USER);
	}
}