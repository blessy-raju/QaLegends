package testScripts;

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
import pageObjects.ViewUserDetailsPage;
import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.RandomDataUtility;

public class UsersPageTest extends Base {
	@Test
	public void verifyViewUser() {
		String userName = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelUtility.getNumericData(0, 1, Constants.LOGIN_PAGE);
		String searchUser = ExcelUtility.getStringData(4, 0, Constants.USER_PAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		HomePage homepage = login.clickLoginButton();
		homepage.clickEndTour();
		UserManagementMenu usermanagement = homepage.clickUserManagementMenu();
		UsersPage userspage = usermanagement.clickUsersMenu();
		userspage.enterSearchUserName(searchUser);
		String userPageEmail = userspage.getuserEmailId();
		ViewUserDetailsPage userdetailspage = userspage.clickViewButton();
		Assert.assertEquals(userPageEmail, userdetailspage.getUserDetailsPageEmail(), Messages.VIEW_USER_FAILED);
	}

	@Test
	public void verifyDeleteUser() {
		String userName = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelUtility.getNumericData(0, 1, Constants.LOGIN_PAGE);
		String prefix = RandomDataUtility.getPrefix();
		String fName = RandomDataUtility.getFirstName();
		String lName = RandomDataUtility.getLastname();
		String role = ExcelUtility.getStringData(1, 0, Constants.USER_PAGE);
		String commission = ExcelUtility.getNumericData(1, 1, Constants.USER_PAGE);
		String contact = ExcelUtility.getStringData(1, 3, Constants.USER_PAGE);
		String noRecordMessage = ExcelUtility.getStringData(7, 0, Constants.USER_PAGE);
		String emailId = fName + Constants.SEPARATOR + lName + Constants.AT_SIGN + Constants.MAIL_SERVER;
		String pwd = fName + Constants.AT_SIGN + lName;
		String newUserName = fName + Constants.SEPARATOR + lName;

		LoginPage login = new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		HomePage homepage = login.clickLoginButton();
		homepage.clickEndTour();
		UserManagementMenu usermanagement = homepage.clickUserManagementMenu();
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
		Assert.assertEquals(userspage.getNoRecordsMessage(), noRecordMessage, Messages.DELETE_USER_FAILED);
	}
}
