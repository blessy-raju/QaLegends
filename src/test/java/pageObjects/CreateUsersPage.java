package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUsersPage {
	WebDriver driver;
	public CreateUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='surname']")
	WebElement surName;
	@FindBy(id="first_name")
	WebElement firstName1;
	@FindBy(id="last_name")
	WebElement lastName;
	@FindBy(id="email")
	WebElement emailIdField;
	@FindBy(id="username")
	WebElement userNameField;
	@FindBy(id="password")
	WebElement userPassword;
	@FindBy(id="confirm_password")
	WebElement confirmPassword;
	@FindBy(id="cmmsn_percent")
	WebElement commissionPercentage;
}
