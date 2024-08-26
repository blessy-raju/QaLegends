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
import constants.Constants;
import constants.Messages;
import pageObjects.CreateUsersPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UserManagementMenu;
import pageObjects.UsersPage;
import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.RandomDataUtility;

public class CreateUsersPageTest extends Base {
	@Test
	public void verifyAddNewUser() {
		String userName = ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
		String password = ExcelUtility.getNumericData(0, 1, Constants.LOGINPAGE);
		String prefix = RandomDataUtility.getPrefix();
		String fName = RandomDataUtility.getFirstName();
		String lName = RandomDataUtility.getLastname();
		String expectedRole = ExcelUtility.getStringData(1, 0, "UserPage");
		String commission = ExcelUtility.getNumericData(1, 1, "UserPage");
		// String expectedSuccessMessage = ExcelUtility.getStringData(1, 2, "UserPage");
		String expectedContact = ExcelUtility.getStringData(1, 3, "UserPage");
		String emailId = fName + "." + lName + "@yahoo.com";
		String pwd = fName + "@" + lName;
		String newUserName = fName + "." + lName;
		
		LoginPage login = new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		HomePage homepage = login.clickLoginButton();
		homepage.clickEndTour();
		homepage.clickUserManagementMenu();
		UserManagementMenu usermanagement = new UserManagementMenu(driver);
		UsersPage userspage = usermanagement.clickUsersMenu();
		CreateUsersPage createusers = userspage.clickAddUserButton();
		createusers.enterSurName(prefix);
		createusers.enterFirstName(fName);
		createusers.enterLastName(lName);
		createusers.enterEmailId(emailId);
		createusers.clickRoles();
		PageUtility.selectOption(createusers.getRoleLists(), expectedRole);
		createusers.enterUserName(newUserName);
		createusers.enterPassword(pwd);
		createusers.enterConfirmPassword(pwd);
		createusers.enterSalesCommisions(commission);
		createusers.clickAllowContactsCheckbox();
		createusers.clickContacts();
		PageUtility.selectOption(createusers.getContactLists(), expectedContact);
		userspage = createusers.clickSaveButton();
		userspage.enterSearchUserName(newUserName);
		Assert.assertEquals(userspage.getuserEmailId(), emailId, Messages.USERADDFAILED);
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
		String emailId = fName + "." + lName + "@yahoo.com";
		String newUserPassword = fName + "@" + lName;
		String newUserName = fName + "." + lName;
		LoginPage login = new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		HomePage homepage = login.clickLoginButton();
		homepage.clickEndTour();
		homepage.clickUserManagementMenu();
		UserManagementMenu usermanagement = new UserManagementMenu(driver);
		UsersPage userspage = usermanagement.clickUsersMenu();
		CreateUsersPage createusers = userspage.clickAddUserButton();
		createusers.enterSurName(prefix);
		createusers.enterFirstName(fName);
		createusers.enterLastName(lName);
		createusers.enterEmailId(emailId);
		// createusers.selectRole(expectedRole);
		createusers.clickRoles();
		PageUtility.selectOption(createusers.getRoleLists(), expectedRole);
		createusers.enterUserName(newUserName);
		createusers.enterPassword(newUserPassword);
		createusers.enterConfirmPassword(newUserPassword);
		createusers.enterSalesCommisions(commission);
		createusers.clickAllowContactsCheckbox();
		// createusers.selectContacts(expectedContact);
		createusers.clickContacts();
		PageUtility.selectOption(createusers.getContactLists(), expectedContact);
		createusers.clickSaveButton();
		homepage.clickHomeMenu();
		homepage.clickLoggedInUserName();
		homepage.clickSignOutButton();
		login.enterUserName(newUserName);
		login.enterPassword(newUserPassword);
		homepage = login.clickLoginButton();
		String expectedUserName = fName + " " + lName;
		Assert.assertEquals(homepage.getLoggedInUserName(), expectedUserName, "Invalid user login");
	}
}