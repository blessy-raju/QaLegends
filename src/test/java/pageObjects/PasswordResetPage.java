package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordResetPage {
	WebDriver driver;

	public PasswordResetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	WebElement emailAddress;
	@FindBy(xpath="//button[@type='submit']")
	WebElement sendLinkButton;
	@FindBy(xpath="//span[@class='help-block']")
	WebElement errorMessage;
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement successMessage;
	
	public void enterEmailAddress(String emailId) {
		emailAddress.sendKeys(emailId);
	}
	public void sendPasswordResetLink() {
		sendLinkButton.click();
	}
	public String getEmailNotFoundMessage() {
		return errorMessage.getText();
	}
	public String getEmailSentMessage() {
		return successMessage.getText();
	}
	
}
