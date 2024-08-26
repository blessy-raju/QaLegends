package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pageObjects.LoginPage;
import pageObjects.PasswordResetPage;
import utilities.ExcelUtility;

public class PasswordResetPageTest extends Base {
	@Test
	public void verifyResetPasswordWithNonExistingUserEmail() {
		String userEmail = ExcelUtility.getStringData(1, 0, "ResetPage");
		String expectedMessage = ExcelUtility.getStringData(1, 1, "ResetPage");
		LoginPage loginpage = new LoginPage(driver);
		PasswordResetPage resetpage = loginpage.clickForgotPasswordLink();
		resetpage.enterEmailAddress(userEmail);
		resetpage.sendPasswordResetLink();
		String actualMessage = resetpage.getEmailNotFoundMessage();
		Assert.assertEquals(actualMessage, expectedMessage, "Invalid message for non existing user");
	}

	@Test
	public void verifyResetPasswordWithExistingUserEmail() {
		String userEmail = ExcelUtility.getStringData(5, 0, "ResetPage");
		String expectedMessage = ExcelUtility.getStringData(5, 1, "ResetPage");
		LoginPage loginpage = new LoginPage(driver);
		PasswordResetPage resetpage = loginpage.clickForgotPasswordLink();
		resetpage.enterEmailAddress(userEmail);
		resetpage.sendPasswordResetLink();
		String actualMessage = resetpage.getEmailSentMessage();
		Assert.assertEquals(actualMessage, expectedMessage, "Invalid message for existing user");
	}
}
