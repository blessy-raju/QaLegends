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
	@Test(groups="Smoke")
	public void verifyAddNewUser() {
		String userName = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelUtility.getNumericData(0, 1, Constants.LOGIN_PAGE);
		String prefix = RandomDataUtility.getPrefix();
		String fName = RandomDataUtility.getFirstName();
		String lName = RandomDataUtility.getLastname();
		String expectedRole = ExcelUtility.getStringData(1, 0, Constants.USER_PAGE);
		String commission = ExcelUtility.getNumericData(1, 1, Constants.USER_PAGE);
		String expectedContact = ExcelUtility.getStringData(1, 3, Constants.USER_PAGE);
		String emailId = fName + Constants.SEPARATOR + lName + Constants.AT_SIGN + Constants.MAIL_SERVER;
		String newUserPassword = fName + Constants.AT_SIGN + lName;
		String newUserName = fName + Constants.SEPARATOR + lName;

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
		createusers.enterPassword(newUserPassword);
		createusers.enterConfirmPassword(newUserPassword);
		createusers.enterSalesCommisions(commission);
		createusers.clickAllowContactsCheckbox();
		createusers.clickContacts();
		PageUtility.selectOption(createusers.getContactLists(), expectedContact);
		userspage = createusers.clickSaveButton();
		userspage.enterSearchUserName(newUserName);
		Assert.assertEquals(userspage.getuserEmailId(), emailId, Messages.USER_ADDED_FAILED);
	}

	@Test
	public void verifyLoginWithNewlyAddedUser() {
		String userName = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelUtility.getNumericData(0, 1, Constants.LOGIN_PAGE);
		String prefix = RandomDataUtility.getPrefix();
		String fName = RandomDataUtility.getFirstName();
		String lName = RandomDataUtility.getLastname();
		String expectedRole = ExcelUtility.getStringData(1, 0, Constants.USER_PAGE);
		String commission = ExcelUtility.getNumericData(1, 1, Constants.USER_PAGE);
		String expectedContact = ExcelUtility.getStringData(1, 3, Constants.USER_PAGE);
		String emailId = fName + Constants.SEPARATOR + lName + Constants.AT_SIGN + Constants.MAIL_SERVER;
		String newUserPassword = fName + Constants.AT_SIGN + lName;
		String newUserName = fName + Constants.SEPARATOR + lName;
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
		Assert.assertEquals(homepage.getLoggedInUserName(), expectedUserName, Messages.INVALID_USER);
	}
}