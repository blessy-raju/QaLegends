package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	@FindBy(xpath = "//div[@class='pull-right']//a")
	WebElement signOutButton;

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

	public void clickUserManagementMenu() {
		userManagement.click();
	}

	public void clickLoggedInUserName() {
		loggedInUserName.click();
	}

	public void clickSignOutButton() {
		signOutButton.click();
	}

}
