package br.com.verity.gherkin.hooks;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import br.com.verity.core.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	Logger log = Logger.getLogger(Hooks.class);

	@Before
	public void initializeTest() {
		DriverManager.getDriver();
	}

	@After
	public void endTest(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				log.info(scenario.getName() + " is Failed");
				final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png"); // ... and embed it in
			} catch (WebDriverException e) {
				e.printStackTrace();
			}
		} else {
			try {
				log.info(scenario.getName() + " is Pass");
				scenario.embed(((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		DriverManager.killDriver();
	}

}
