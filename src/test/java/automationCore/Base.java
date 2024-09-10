package automationCore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.WaitUtility;

public class Base {
	public WebDriver driver;
	public FileInputStream file;
	public Properties property;

	public void initializeBrowser(String browserName) {
		property = new Properties();
		try {
			file = new FileInputStream(Constants.CONFIG_FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			property.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (browserName.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid browser name");
		}
		driver.manage().window().maximize();
		driver.get(property.getProperty("url"));
		WaitUtility.waitForAnElement(driver);
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void setBrowser(String browserName) {
		initializeBrowser(browserName);
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			takeScreenshot(result);
		}
		driver.close();
	}

	public void takeScreenshot(ITestResult result) {
		TakesScreenshot takesscreenshot = (TakesScreenshot) driver;
		File screenshot = takesscreenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("./Screenshots/" + result.getName() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
