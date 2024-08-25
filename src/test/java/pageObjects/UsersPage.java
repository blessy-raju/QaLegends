package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {
	WebDriver driver;

	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='box-tools']")
	WebElement addButton;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchText;
	@FindBy(xpath = "//table[@id='users_table']")
	WebElement userTable;

	public CreateUsersPage clickAddUserButton() {
		addButton.click();
		return new CreateUsersPage(driver);
	}

	public void enterSearchUserName(String name) {
		searchText.sendKeys(name);
	}

	public boolean isNewlyCreatedUserPresent(String email) {
		String emailDisplayed = userTable.findElement(By.tagName("tr//td[4]")).getText();
		if (emailDisplayed.equals(email))
			return true;
		else
			return false;
	}

}
//int rowSize = rows.size();
//for (int i = 0; i < rowSize; i++) {
//	List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
//	int columnSize = columns.size();
//	for (int j = 0; j < columnSize; j++) {
//		String cellData = columns.get(j).getText();
//		if (cellData.equals("NIFTY BANK")) {
//			System.out.println("Prev Close value is " + columns.get(1).getText());
//		}
