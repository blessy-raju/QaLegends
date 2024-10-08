package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.PageUtility;

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
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement importSuccessMessage;

	public void uploadFile() {
		PageUtility.fileUpload(chooseFileButton);
	}

	public void clickSubmitButton() {
		submitButton.click();
	}

	public String getImportSuccessMessage() {
		return importSuccessMessage.getText();
	}

}
