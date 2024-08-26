package testScripts;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pageObjects.CreateUsersPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UserManagementMenu;
import pageObjects.UsersPage;
import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.RandomDataUtility;
import utilities.WaitUtility;

public class UsersPageTest extends Base {
	@Test
	public void verifyViewUser() {
		String userName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getNumericData(0, 1, "LoginPage");
		String searchUser = ExcelUtility.getStringData(4, 0, "UserPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		HomePage homepage = login.clickLoginButton();
		homepage.clickEndTour();
		homepage.clickUserManagementMenu();
		UserManagementMenu usermanagement = new UserManagementMenu(driver);
		UsersPage userspage = usermanagement.clickUsersMenu();
		userspage.enterSearchUserName(searchUser);
		userspage.clickViewButton();
	}

	@Test
	public void verifyDeleteUser() {
		String userName = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getNumericData(0, 1, "LoginPage");
		String prefix = RandomDataUtility.getPrefix();
		String fName = RandomDataUtility.getFirstName();
		String lName = RandomDataUtility.getLastname();
		String role = ExcelUtility.getStringData(1, 0, "UserPage");
		String commission = ExcelUtility.getNumericData(1, 1, "UserPage");
		String contact = ExcelUtility.getStringData(1, 3, "UserPage");
		String noRecordMessage = ExcelUtility.getStringData(7, 0, "UserPage");
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
		PageUtility.selectOption(createusers.getRoleLists(), role);
		createusers.enterUserName(newUserName);
		createusers.enterPassword(pwd);
		createusers.enterConfirmPassword(pwd);
		createusers.enterSalesCommisions(commission);
		createusers.clickAllowContactsCheckbox();
		createusers.clickContacts();
		PageUtility.selectOption(createusers.getContactLists(), contact);
		userspage = createusers.clickSaveButton();
		userspage.enterSearchUserName(newUserName);
		userspage.clickDeleteButton();
		userspage.clickDeleteOkButton();
		userspage.enterSearchUserName(newUserName);
		Assert.assertEquals(userspage.getNoRecordsMessage(), noRecordMessage, "User not deleted");
	}
}
