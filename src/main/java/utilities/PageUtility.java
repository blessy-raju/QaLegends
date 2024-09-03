package utilities;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public static void selectByValueFromDopDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static void selectByIndexFromDropDown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static void selectByTextFromDropDown(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void selectOption(List<WebElement> list, String option) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals(option)) {
				list.get(i).click();
				break;
			}
		}
	}

	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor javascriptexecutor = (JavascriptExecutor) driver;
		javascriptexecutor.executeScript("window.scrollBy(0,500)");
	}

	public static void scrollUp(WebDriver driver) {
		JavascriptExecutor javascriptexecutor = (JavascriptExecutor) driver;
		javascriptexecutor.executeScript("window.scrollBy(0,-500)");
	}

}
