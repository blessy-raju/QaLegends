package testScripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UserProfilePage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class UserProfilePageTest extends Base {
	@Test(groups = "Regression")
	public void verifyEditProfile() {
		String userName = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelUtility.getNumericData(0, 1, Constants.LOGIN_PAGE);
		String fName = RandomDataUtility.getFirstName();
		String lName = RandomDataUtility.getLastname();
		String emailId = fName + Constants.SEPARATOR + lName + Constants.AT_SIGN + Constants.MAIL_SERVER;
		LoginPage login = new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		HomePage homepage = login.clickLoginButton();
		homepage.clickEndTour();
		homepage.clickLoggedInUserName();
		UserProfilePage userprofile = homepage.clickProfileButton();
		userprofile.editEmailAddress(emailId);
		userprofile.clickUpdateButton();
		Assert.assertTrue(userprofile.isProfileUpdatedMessageDisplayed(), Messages.PROFILE_UPDATE_FAILED);
	}

}
