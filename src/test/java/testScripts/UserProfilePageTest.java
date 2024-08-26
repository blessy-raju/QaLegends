package testScripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UserProfilePage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class UserProfilePageTest extends Base {
	@Test
	public void verifyEditProfile() {
		String userName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getNumericData(0, 1, "LoginPage");
		String fName = RandomDataUtility.getFirstName();
		String lName = RandomDataUtility.getLastname();
		String emailId = fName + "." + lName + "@yahoo.com";
		LoginPage login = new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		HomePage homepage = login.clickLoginButton();
		homepage.clickEndTour();
		homepage.clickLoggedInUserName(); 
		UserProfilePage userprofile = homepage.clickProfileButton();
		userprofile.editEmailAddress(emailId);
		userprofile.clickUpdateButton();
		homepage.clickHomeMenu();
		homepage.clickLoggedInUserName(); 
		userprofile = homepage.clickProfileButton();
		String actualEmail =userprofile.getEmailAddress();
		Assert.assertEquals(actualEmail, emailId,"Profile is not updated");
	}

}
