package br.com.verity.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json"},
				 glue = "br/com/verity/gherkin",
				 features = "features")
public class RunCucumberTest {}
