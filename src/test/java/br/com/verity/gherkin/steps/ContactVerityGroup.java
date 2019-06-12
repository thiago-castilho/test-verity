package br.com.verity.gherkin.steps;

import static br.com.verity.core.DriverManager.getDriver;
import static br.com.verity.core.Properties.site;

import org.junit.Assert;

import com.github.javafaker.Faker;

import br.com.verity.core.WaitHelper;
import br.com.verity.gherkin.pages.ContactPage;
import br.com.verity.gherkin.pages.MenuPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactVerityGroup extends WaitHelper{
	
	MenuPage menuPage = new MenuPage();
	ContactPage contactPage = new ContactPage();
	Faker faker = new Faker();
	
	@Given("I accessed the Verity Group home page")
	public void i_accessed_the_Verity_Group_home_page() {
	    getDriver().get(site);
	}

	@When("I click on the {string} menu option")
	public void i_click_on_the_menu_option(String link) {
	    menuPage.clickOnElementByLinkText(link);
	}

	@When("fill in the Company, Name, Email, Phone, Subject and Message fields")
	public void fill_in_the_Company_Name_Email_Phone_Subject_and_Message_fields() {
	   contactPage.getFieldCompany().sendKeys(faker.company().name());
	   contactPage.getFieldName().sendKeys(faker.gameOfThrones().character());
	   contactPage.getFieldEmail().sendKeys(faker.internet().emailAddress());
	   contactPage.getFieldTelefone().sendKeys(faker.number().digits(11));
	   contactPage.getSelectSubjectRandom("Elogios");
	   contactPage.getFieldMessage().sendKeys(faker.lorem().paragraph());
	}

	@When("click the {string} button")
	public void click_the_button(String string) {
	    contactPage.clickOnButtonByText(string);
	    contactPage.waitElementClickable(contactPage.getButtonSend(), 20);
	}

	@Then("the site will register the submission with a message that the message was sent successfully.")
	public void the_site_will_register_the_submission_with_a_message_that_the_message_was_sent_successfully() {
		Assert.assertEquals("Sua mensagem foi enviado com sucesso!", contactPage.getValidationMessage().getText().substring(7));
	}
	
}
