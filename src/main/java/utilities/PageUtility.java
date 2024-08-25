package utilities;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public static void selectByValueFromDopDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public static void selectByIndexFromDropDown() {
		
	}
	
	public static void selectOption(List<WebElement> list, String option) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals(option)) {
				list.get(i).click();
				break;
			}
		}
	}

}
