package br.com.verity.gherkin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.verity.core.WaitHelper;
import br.com.verity.core.DriverManager;

public class MenuPage extends WaitHelper {
	
	public MenuPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	@FindBy(linkText = "Sobre")
	private WebElement sobre;

	@FindBy(linkText = "Soluções")
	private WebElement solucoes;
	
	@FindBy(linkText = "Clientes")
	private WebElement clientes;
	
	@FindBy(linkText = "Na Mídia")
	private WebElement naMidia;
	
	@FindBy(linkText = "e-Books")
	private WebElement eBooks;
	
	@FindBy(linkText = "Blog")
	private WebElement blog;
	
	@FindBy(linkText = "Trabalhe Conosco")
	private WebElement trabalheConosco;
	
	@FindBy(linkText = "CONTATO")
	private WebElement contato;
	
	public WebElement getSobre() {
		waitVisibilityOfElement(sobre, 20);
		return sobre;
	}

	public WebElement getSolucoes() {
		waitVisibilityOfElement(solucoes, 20);
		return solucoes;
	}

	public WebElement getClientes() {
		waitVisibilityOfElement(clientes, 20);
		return clientes;
	}

	public WebElement getNaMidia() {
		waitVisibilityOfElement(naMidia, 20);
		return naMidia;
	}

	public WebElement geteBooks() {
		waitVisibilityOfElement(eBooks, 20);
		return eBooks;
	}

	public WebElement getBlog() {
		waitVisibilityOfElement(blog, 20);
		return blog;
	}

	public WebElement getTrabalheConosco() {
		waitVisibilityOfElement(trabalheConosco, 20);
		return trabalheConosco;
	}

	public WebElement getContato() {
		waitVisibilityOfElement(contato, 20);
		return contato;
	}
	
	public void clickOnElementByLinkText(String link) {
		switch (link.toLowerCase()) {
			case "sobre": getSobre().click(); break;
			case "soluções": getSolucoes().click(); break;
			case "clientes": getClientes().click(); break;
			case "na mídia": getNaMidia().click(); break;
			case "e-books": geteBooks().click(); break;
			case "blog": getBlog().click(); break;
			case "trabalhe conosco": getTrabalheConosco().click(); break;
			case "contato": getContato().click(); break;
			default: new Exception("Invalid argument"); break;
		}
	}
}
