package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import pageObjects.ContactsMenu;
import pageObjects.HomePage;
import pageObjects.ImportContactsPage;
import pageObjects.LoginPage;
import utilities.ExcelUtility;

public class ImportContactsPageTest extends Base {
	@Test(groups = "Regression")
	public void verifyImportCustomerContacts() {
		String userName = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelUtility.getNumericData(0, 1, Constants.LOGIN_PAGE);
		String importSuccessMessage = ExcelUtility.getStringData(0, 0, Constants.IMPORT_CONTACTS);

		LoginPage login = new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassword(password);
		HomePage homepage = login.clickLoginButton();
		homepage.clickEndTour();
		ContactsMenu contactsmenu = homepage.clickContactsMenu();
		ImportContactsPage importcontacts = contactsmenu.clickImportContacts();
		importcontacts.uploadFile();
		importcontacts.clickSubmitButton();
		Assert.assertEquals(importcontacts.getImportSuccessMessage(), importSuccessMessage, Messages.IMPORT_FAILED);
	}

}
