package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DateUtility;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='dropdown-toggle']//span")
	WebElement loggedInUserName;
	@FindBy(xpath = "//button[@data-role='end']")
	WebElement endTour;
	@FindBy(xpath = "//a[contains(@href,'public/home')]//span")
	WebElement homeMenu;
	@FindBy(xpath = "//span[text()='User Management']")
	WebElement userManagement;
	@FindBy(xpath = "//span[normalize-space()='Contacts']")
	WebElement contactsMenu;
	@FindBy(xpath = "//div[@class='pull-right']//a")
	WebElement signOutButton;
	@FindBy(xpath = "//div[@class='pull-left']//a")
	WebElement profileButton;
	@FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']//strong")
	WebElement loginDate;

	public String getLoggedInUserName() {
		String userNameText = loggedInUserName.getText();
		return userNameText;
	}

	public void clickEndTour() {
		endTour.click();
	}

	public void clickHomeMenu() {
		homeMenu.click();
	}

	public UserManagementMenu clickUserManagementMenu() {
		userManagement.click();
		return new UserManagementMenu(driver);
	}

//	public void clickUserManagementMenu() {
//		userManagement.click();
//	}
	public ContactsMenu clickContactsMenu() {
		contactsMenu.click();
		return new ContactsMenu(driver);
	}

	public void clickLoggedInUserName() {
		loggedInUserName.click();
	}

	public void clickSignOutButton() {
		signOutButton.click();
	}

	public UserProfilePage clickProfileButton() {
		profileButton.click();
		return new UserProfilePage(driver);
	}

	public String getLoginDate() {
		return loginDate.getText();
	}

	public String getCurrentDate() {
		return DateUtility.getUserLoginDate("dd-MM-YYYY");
	}

}
