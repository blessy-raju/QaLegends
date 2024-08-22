package testScripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pageObjects.CreateUsersPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UserManagementMenu;
import pageObjects.UsersPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class CreateUsersPageTest extends Base {
	@Test
	public void verifyAddNewUser() {
		String userName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getNumericData(0, 1, "LoginPage");
		String prefix = RandomDataUtility.getPrefix();
		String fName = RandomDataUtility.getFirstName();
		String lName = RandomDataUtility.getLastname();
		String expectedRole = ExcelUtility.getStringData(1, 0, "UserPage");
		String commission = ExcelUtility.getNumericData(1, 1, "UserPage");
		String expectedSuccessMessage = ExcelUtility.getStringData(1, 2, "UserPage");
		String expectedContact = ExcelUtility.getStringData(1, 3, "UserPage");

		LoginPage login = new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		HomePage home = login.clickLoginButton();
		home.clickEndTour();
		UserManagementMenu usermanagement = new UserManagementMenu(driver);
		usermanagement.clickUserManagementMenu();
		UsersPage userspage = usermanagement.clickUsersMenu();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(users));
	
		CreateUsersPage createusers=userspage.clickAddUserButton();

		// WebElement isActive =
		// driver.findElement(By.xpath("//input[@name='is_active']"));
		WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']"));
		WebElement selectedContacts = driver.findElement(By.xpath("//div[@class='icheckbox_square-blue']"));
		String emailId = fName + "." + lName + "@yahoo.com";
		String pwd = fName + "@" + lName;
		String newUserName = fName + "." + lName;
		surname.sendKeys(prefix);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		emailIdField.sendKeys(emailId);
		WebElement roles = driver.findElement(By.xpath("//span[@id='select2-role-container']"));
		roles.click();
		List<WebElement> rolesList = driver.findElements(By.xpath("//li[@class='select2-results__option']"));
		for (int i = 0; i < rolesList.size(); i++) {
			if (rolesList.get(i).getText().equals(expectedRole)) {
				rolesList.get(i).click();
				break;
			}
		}
		newUserNameField.sendKeys(newUserName);
		newUserPassword.sendKeys(pwd);
		confirmPassword.sendKeys(pwd);
		commissionPercentage.sendKeys(commission);
		// isActive.click();
		selectedContacts.click();
		WebElement contacts = driver.findElement(By.xpath("//ul[@class='select2-selection__rendered']"));
		contacts.click();
		List<WebElement> contactLists = driver.findElements(By.xpath("//li[@class='select2-results__option']"));
		for (int i = 0; i < contactLists.size(); i++) {
			if (contactLists.get(i).getText().equals(expectedContact)) {
				contactLists.get(i).click();
				break;
			}
		}
		saveButton.click();

		String actualSuccessMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Invalid message after user creation");
	}

	@Test
	public void verifyLoginWithNewlyAddedUser() {
		String userName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getNumericData(0, 1, "LoginPage");
		String prefix = RandomDataUtility.getPrefix();
		String fName = RandomDataUtility.getFirstName();
		String lName = RandomDataUtility.getLastname();
		String expectedRole = ExcelUtility.getStringData(1, 0, "UserPage");
		String commission = ExcelUtility.getNumericData(1, 1, "UserPage");
		String expectedContact = ExcelUtility.getStringData(1, 3, "UserPage");

		WebElement userNameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		loginButton.click();

		WebElement endTour = driver.findElement(By.xpath("//button[@data-role='end']"));
		endTour.click();

		WebElement userManagement = driver.findElement(By.xpath("//span[text()='User Management']"));
		userManagement.click();
		WebElement users = driver.findElement(By.xpath("//span[normalize-space()='Users']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(users));
		users.click();
		WebElement addButton = driver.findElement(By.xpath("//div[@class='box-tools']"));
		addButton.click();
		WebElement surname = driver.findElement(By.xpath("//input[@id='surname']"));
		WebElement firstName = driver.findElement(By.id("first_name"));
		WebElement lastName = driver.findElement(By.id("last_name"));
		WebElement emailIdField = driver.findElement(By.id("email"));
		WebElement newUserNameField = driver.findElement(By.id("username"));
		WebElement newUserPassword = driver.findElement(By.id("password"));
		WebElement confirmPassword = driver.findElement(By.id("confirm_password"));
		WebElement commissionPercentage = driver.findElement(By.id("cmmsn_percent"));
		WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']"));
		WebElement selectedContacts = driver.findElement(By.xpath("//div[@class='icheckbox_square-blue']"));

		String emailId = fName + "." + lName + "@yahoo.com";
		String pwd = fName + "@" + lName;
		String newUserName = fName + "." + lName;
		surname.sendKeys(prefix);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		emailIdField.sendKeys(emailId);
		WebElement roles = driver.findElement(By.xpath("//span[@id='select2-role-container']"));
		roles.click();
		List<WebElement> rolesList = driver.findElements(By.xpath("//li[@class='select2-results__option']"));
		for (int i = 0; i < rolesList.size(); i++) {
			if (rolesList.get(i).getText().equals(expectedRole)) {
				rolesList.get(i).click();
				break;
			}
		}
		newUserNameField.sendKeys(newUserName);
		newUserPassword.sendKeys(pwd);
		confirmPassword.sendKeys(pwd);
		commissionPercentage.sendKeys(commission);
		selectedContacts.click();
		WebElement contacts = driver.findElement(By.xpath("//ul[@class='select2-selection__rendered']"));
		contacts.click();
		List<WebElement> contactLists = driver.findElements(By.xpath("//li[@class='select2-results__option']"));
		for (int i = 0; i < contactLists.size(); i++) {
			if (contactLists.get(i).getText().equals(expectedContact)) {
				contactLists.get(i).click();
				break;
			}
		}
		saveButton.click();
		WebElement home = driver.findElement(By.xpath("//a[contains(@href,'public/home')]//span"));
		home.click();
		WebElement userMenu = driver.findElement(By.xpath("//a[@class='dropdown-toggle']//span"));
		userMenu.click();
		WebElement signOutButton = driver.findElement(By.xpath("//div[@class='pull-right']//a"));
		signOutButton.click();
		
		//wait.until(ExpectedConditions.elementToBeClickable(userNameField));
		WebElement newUserrNameField = driver.findElement(By.id("username"));
		WebElement newUserPasswordField = driver.findElement(By.id("password"));
		WebElement newUserLoginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		newUserrNameField.sendKeys(newUserName);
		newUserPasswordField.sendKeys(pwd);
		newUserLoginButton.click();
		WebElement newUserMenu = driver.findElement(By.xpath("//a[@class='dropdown-toggle']//span"));
		String expectedUserName = fName + " " + lName;
		Assert.assertEquals(newUserMenu.getText(), expectedUserName, "Invalid user login");

	}
}