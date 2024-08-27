package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsMenu {
	WebDriver driver;
	
	public ContactsMenu(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Customers']")
	WebElement customers;
	@FindBy(xpath="//a[normalize-space()='Import Contacts']")
	WebElement importContacts;
	
	public ImportContactsPage clickImportContacts() {
		importContacts.click();
		return new ImportContactsPage(driver);
	}

}
