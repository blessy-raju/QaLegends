package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewUserDetailsPage {
	WebDriver driver;

	public ViewUserDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='wrapper']//div[2]//p[1]")
	WebElement detailsPageEmail;

	public String getUserDetailsPageEmail() {
		String text = detailsPageEmail.getText();
		return text.substring(7);
	}

}
