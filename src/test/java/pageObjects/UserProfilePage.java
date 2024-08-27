package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public void editEmailAddress(String emailId) {
		userEmail.clear();
		userEmail.sendKeys(emailId);
	}
	public void clickUpdateButton() {
		updateButton.click();
	}
	public String getEmailAddress() {
		return userEmail.getText();
		
	}
	
}
