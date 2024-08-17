package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import utilities.ExcelUtility;

public class ResetPageTest extends Base {
	@Test
	public void verifyResetPasswordWithNonExistingUserEmail() {
		String userEmail = ExcelUtility.getStringData(1, 0, "ResetPage");
		String expectedMessage = ExcelUtility.getStringData(1, 1, "ResetPage");

		WebElement forgotLink = driver.findElement(By.xpath("//a[@class='btn btn-link']"));
		forgotLink.click();
		WebElement emailAddress = driver.findElement(By.id("email"));
		WebElement sendLinkButton = driver.findElement(By.xpath("//button[@type='submit']"));

		emailAddress.sendKeys(userEmail);
		sendLinkButton.click();

		String actualMessage = driver.findElement(By.xpath("//span[@class='help-block']")).getText();
		Assert.assertEquals(actualMessage, expectedMessage, "Invalid message for non existing user");

	}

	@Test
	public void verifyResetPasswordWithExistingUserEmail() {
		String userEmail = ExcelUtility.getStringData(5, 0, "ResetPage");
		String expectedMessage = ExcelUtility.getStringData(5, 1, "ResetPage");

		WebElement forgotLink = driver.findElement(By.xpath("//a[@class='btn btn-link']"));
		forgotLink.click();
		WebElement emailAddress = driver.findElement(By.id("email"));
		WebElement sendLinkButton = driver.findElement(By.xpath("//button[@type='submit']"));

		emailAddress.sendKeys(userEmail);
		sendLinkButton.click();

		String actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertEquals(actualMessage, expectedMessage, "Invalid message for existing user");

	}

}
