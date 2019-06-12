package br.com.verity.gherkin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import br.com.verity.core.DriverManager;
import br.com.verity.core.WaitHelper;

public class ContactPage extends WaitHelper {

	public ContactPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	@FindBy(name = "empresa")
	private WebElement fieldCompany;
	
	@FindBy(name = "nome")
	private WebElement fieldName;
	
	@FindBy(name = "email")
	private WebElement fieldEmail;
	
	@FindBy(name = "telefone")
	private WebElement fieldTelefone;
	
	@FindBy(xpath = "//select")
	private WebElement selectSubject;
	
	@FindBy(name = "mensagem")
	private WebElement fieldMessage;
	
	@FindBy(xpath = "//button[@class='submit']")
	private WebElement buttonSend;
	
	@FindBy(xpath = "//form/div")
	private WebElement validationMessage;
	
	public WebElement getFieldCompany() {
		waitVisibilityOfElement(fieldCompany, 20);
		return fieldCompany;
	}
	
	public WebElement getFieldName() {
		waitVisibilityOfElement(fieldName, 20);
		return fieldName;
	}
	
	public WebElement getFieldEmail() {
		waitVisibilityOfElement(fieldEmail, 20);
		return fieldEmail;
	}
	
	public WebElement getFieldTelefone() {
		waitVisibilityOfElement(fieldTelefone, 20);
		return fieldTelefone;
	}
	
	public WebElement getSelectSubject() {
		return selectSubject;
	}
	
	public WebElement getFieldMessage() {
		waitVisibilityOfElement(fieldMessage, 20);
		return fieldMessage;
	}
	
	public WebElement getButtonSend() {
		waitVisibilityOfElement(buttonSend, 20);
		return buttonSend;
	}
	
	public WebElement getValidationMessage() {
		return validationMessage;
	}

	public void getSelectSubjectRandom(String value) {
		Select select = new Select(getSelectSubject());
		select.selectByVisibleText(value);
	}

	public void clickOnButtonByText(String string) {
		waitVisibilityOfElement(getButtonSend(), 20);
		switch (string.toLowerCase()) {
			case "enviar": getButtonSend().click(); break;
		}
	}
	
}

