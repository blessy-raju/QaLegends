package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebElementUtility;

public class UserProfilePage {
	WebDriver driver;

	public UserProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="email")
	WebElement userEmail;
	@FindBy(xpath="//button[@type='submit']")
	WebElement updateButton;
	@FindBy(xpath="//div[@class='toast-message']")
	WebElement updateMessage;	
	
	public void editEmailAddress(String emailId) {
		userEmail.clear();
		userEmail.sendKeys(emailId);
	}
	public void clickUpdateButton() {
		updateButton.click();
	}

	public boolean isProfileUpdatedMessageDisplayed() {
		return WebElementUtility.isElementDisplayed(updateMessage);
		
	}
}
