package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagementMenu {
	WebDriver driver;

	public UserManagementMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Users']")
	WebElement users;

	public UsersPage clickUsersMenu() {
		users.click();
		return new UsersPage(driver);
	}
}
