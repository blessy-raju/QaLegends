package automationCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	public WebDriver driver;

	public void initializeBrowser(String browserName) {
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
		driver.get("https://qalegend.com/billing/public/login");
	}

	@BeforeMethod
	public void setBrowser() {
		initializeBrowser("Chrome");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
