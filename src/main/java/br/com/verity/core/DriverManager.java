package br.com.verity.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

	private static WebDriver driver;

	private DriverManager() {}

	public static WebDriver getDriver() {
		if(driver == null) {
			switch (Properties.browsers.toLowerCase()) {
				case "chrome": setChromeDriver(); break;
				default: driver = new ChromeDriver(); break;
			}
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	private static void setChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/windows/webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}
