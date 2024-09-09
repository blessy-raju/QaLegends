package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.ExcelUtility;


public class HomePageTest extends Base {
	@Test
	public void verifyUserLoginDate() {
		String userName = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelUtility.getNumericData(0, 1, Constants.LOGIN_PAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		HomePage homepage = login.clickLoginButton();
		homepage.clickEndTour();
		String homePageDate=homepage.getLoginDate();
		String currentDate = homepage.getCurrentDate();
		Assert.assertEquals(homePageDate, currentDate, Messages.LOGIN_DATE_MISMATCH);

	}

}
