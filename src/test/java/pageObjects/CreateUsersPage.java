package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUsersPage {
	WebDriver driver;

	public CreateUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='surname']")
	WebElement surName;
	@FindBy(id = "first_name")
	WebElement firstName;
	@FindBy(id = "last_name")
	WebElement lastName;
	@FindBy(id = "email")
	WebElement emailIdField;
	@FindBy(xpath = "//span[@id='select2-role-container']")
	WebElement roles;
	@FindBy(xpath = "//li[@class='select2-results__option']")
	List<WebElement> rolesList;
	@FindBy(id = "username")
	WebElement userNameField;
	@FindBy(id = "password")
	WebElement userPassword;
	@FindBy(id = "confirm_password")
	WebElement confirmPassword;
	@FindBy(id = "cmmsn_percent")
	WebElement commissionPercentage;
	@FindBy(xpath = "//div[@class='icheckbox_square-blue']")
	WebElement allowContacts;
	@FindBy(xpath = "//ul[@class='select2-selection__rendered']")
	WebElement contacts;
	@FindBy(xpath = "//li[@class='select2-results__option']")
	List<WebElement> contactLists;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;

	public void enterSurName(String prefix) {
		surName.sendKeys(prefix);
	}

	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void enterEmailId(String email) {
		emailIdField.sendKeys(email);
	}

	// common code
	public void clickRoles() {
		roles.click();
	}

	public List<WebElement> getRoleLists() {
		return rolesList;
	}
	// end of code
//	public void selectRole(String role) {
//		roles.click();
//		for (int i = 0; i < rolesList.size(); i++) {
//			if (rolesList.get(i).getText().equals(role)) {
//				rolesList.get(i).click();
//				break;
//			}
//		}
//	}

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		userPassword.sendKeys(password);
	}

	public void enterConfirmPassword(String password) {
		confirmPassword.sendKeys(password);
	}

	public void enterSalesCommisions(String commisions) {
		commissionPercentage.sendKeys(commisions);
	}

	public void clickAllowContactsCheckbox() {
		allowContacts.click();
	}

//	public void selectContacts(String contactName) {
//		contacts.click();
//		for (int i = 0; i < contactLists.size(); i++) {
//			if (contactLists.get(i).getText().equals(contactName)) {
//				contactLists.get(i).click();
//				break;
//			}
//		}
//	}
	public void clickContacts() {
		contacts.click();
	}

	public List<WebElement> getContactLists() {
		return contactLists;
	}

	public UsersPage clickSaveButton() {
		saveButton.click();
		return new UsersPage(driver);
	}

}
