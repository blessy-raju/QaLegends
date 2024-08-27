package testScripts;

import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import pageObjects.ContactsMenu;
import pageObjects.HomePage;
import pageObjects.ImportContactsPage;
import pageObjects.LoginPage;
import utilities.ExcelUtility;

public class ImportContactsPageTest extends Base{
	@Test
	public void verifyImportCustomerContacts() {
		String userName = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelUtility.getNumericData(0, 1, Constants.LOGIN_PAGE);
		
		LoginPage login = new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		HomePage homepage = login.clickLoginButton();
		homepage.clickEndTour();
		homepage.clickContactsMenu();
		ContactsMenu contactsmenu = new ContactsMenu(driver);
		ImportContactsPage importcontacts= contactsmenu.clickImportContacts();
		importcontacts.uploadFile();
		importcontacts.clickSubmitButton();
	}

}
