package br.com.verity.gherkin.hooks;

import br.com.verity.core.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	
	@Before
	public void init() {
		DriverManager.getDriver();
		
	}
	
	@After
	public void killDriver() {
		DriverManager.killDriver();
	}
	
	
}
