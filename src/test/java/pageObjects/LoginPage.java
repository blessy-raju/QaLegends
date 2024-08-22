package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement userNameField;
	@FindBy(id = "password")
	WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;
	@FindBy(xpath = "//span[@class='help-block']")
	WebElement errorMessage;
	@FindBy(xpath = "//a[@class='btn btn-link']")
	WebElement forgotLink;

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public HomePage clickLoginButton() {
		loginButton.click();
		return new HomePage(driver);
	}

	public String getInvalidUserMessage() {
		loginButton.click();
		return errorMessage.getText();
	}
	public PasswordResetPage clickForgotPasswordLink() {
		forgotLink.click();
		return new PasswordResetPage(driver);
	}

}
