package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import dataProvider.DataProviders;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {
	@Test
	public void verifyValidUserLogin() {
		String userName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getNumericData(0, 1, "LoginPage");
		String expectedDropDownUserName = ExcelUtility.getStringData(2, 0, "LoginPage");

		WebElement userNameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		loginButton.click();

		String actualDropDownUserName = driver.findElement(By.xpath("//a[@class='dropdown-toggle']//span")).getText();
		Assert.assertEquals(actualDropDownUserName, expectedDropDownUserName, "Invalid user login");
	}

	@Test(dataProvider = "invalidUserData", dataProviderClass = DataProviders.class)
	public void verifyUserLoginWithInvalidCredentials(String userName, String password) {
		WebElement userNameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		
		String expectedErrorMessage=ExcelUtility.getStringData(5, 0, "LoginPage");
		
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		loginButton.click();
		
		String actualErrorMessage = driver.findElement(By.xpath("//span[@class='help-block']")).getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid error message");
		
	}
}