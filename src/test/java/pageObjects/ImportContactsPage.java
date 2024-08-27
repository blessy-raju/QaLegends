package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportContactsPage {
	WebDriver driver;

	public ImportContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='contacts_csv']")
	WebElement chooseFileButton;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;

	public void uploadFile() {
		chooseFileButton.sendKeys("D:\\SeleniumAutomation\\QaLegends\\src\\main\\resources\\Files\\Contacts.csv");
	}

	public void clickSubmitButton() {
		submitButton.click();
	}

}
