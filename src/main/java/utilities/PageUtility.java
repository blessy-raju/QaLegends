package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public static void selectByValueFromDopDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public static void selectByIndexFromDropDown() {
		
	}

}
