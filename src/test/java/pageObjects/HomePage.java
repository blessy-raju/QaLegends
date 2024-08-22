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
	@FindBy(xpath="//button[@data-role='end']")
	WebElement endTour;
	
	public String getLoggedInUserName() {
		String userNameText=loggedInUserName.getText();
		return userNameText;
	}
	public void clickEndTour() {
		endTour.click();
	}
}
