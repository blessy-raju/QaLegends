package utilities;

import org.openqa.selenium.WebElement;

public class WebElementUtility {
	public static boolean isElementDisplayed(WebElement element) {
		boolean status = element.isDisplayed();
		return status;
	}

	public static boolean isElementSelected(WebElement element) {
		boolean status = element.isSelected();
		return status;
	}

	public static boolean isElementEnabled(WebElement element) {
		boolean status = element.isEnabled();
		return status;
	}
}
