package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtility;

public class UsersPage {
	WebDriver driver;

	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='box-tools']")
	WebElement addButton;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchText;
	@FindBy(xpath = "//table[@id='users_table']//tr//td[4]")
	WebElement userEmailId;
	@FindBy(xpath = "//table[@id='users_table']//a[normalize-space()='View']")
	WebElement viewButton;
	@FindBy(xpath = "//table[@id='users_table']//button[normalize-space()='Delete']")
	WebElement deleteButton;
	@FindBy(xpath = "//table[@id='users_table']//td[@class='dataTables_empty']")
	WebElement noRecords;
	@FindBy(xpath = "//button[@class='swal-button swal-button--confirm swal-button--danger']")
	WebElement deleteOkButton;
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement deleteMessage;

	public CreateUsersPage clickAddUserButton() {
		addButton.click();
		return new CreateUsersPage(driver);
	}

	public void enterSearchUserName(String name) {
		searchText.clear();
		searchText.sendKeys(name);
	}

	public String getuserEmailId() {
		return userEmailId.getText();
	}

	public ViewUserDetailsPage clickViewButton() {
		viewButton.click();
		return new ViewUserDetailsPage(driver);
	}

	public void clickDeleteButton() {
		deleteButton.click();
	}

	public void clickDeleteOkButton() {
		deleteOkButton.click();
		WaitUtility.waitForAnElementToBeVisible(driver, deleteMessage);
	}

	public String getNoRecordsMessage() {
		return noRecords.getText();
	}
}
