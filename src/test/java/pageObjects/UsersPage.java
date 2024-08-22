package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {
	WebDriver driver;
	public UsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='box-tools']")
	WebElement addButton;
	
	public CreateUsersPage clickAddUserButton() {
		addButton.click();
		return new CreateUsersPage(driver);
	}
}
