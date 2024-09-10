package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	public static final long IMPLICITLYWAIT = 10;
	public static final long EXPLICITLYWAIT = 10;
	public static final long TIMEOUT = 10;
	public static final long POLLINGTIME = 2;

	public static void waitForAnElement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLYWAIT));
	}

	public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLYWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForAlertToBePresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLYWAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void waitForAnElementToBeSelected(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLYWAIT));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	public static void waitForAnElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLYWAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForPollingInterval(WebDriver driver) {
		FluentWait fluentWait = new FluentWait(driver);
		fluentWait.withTimeout(Duration.ofSeconds(TIMEOUT));
		fluentWait.pollingEvery(Duration.ofSeconds(POLLINGTIME));
		fluentWait.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.alertIsPresent());
	}
}
