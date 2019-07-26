package br.com.verity.core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	private static WebDriverWait wait;
	
	public void waitVisibilityOfElement(WebElement element, long timeout) {
		wait = new WebDriverWait(DriverManager.getDriver(), timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitElementClickable(WebElement element, long timeout) {
		wait = new WebDriverWait(DriverManager.getDriver(), timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}
