package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccesPage {
	public WebDriver driver;
	
	@FindBy(xpath = "//p[contains(text(), 'Congratulations! Your new account has been successfully created!')]")
	private WebElement accountSuccessCreationMessage;
	
	
	public AccountSuccesPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}

	public void AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String retrieveAccountSuccessMessage() {
		String notificationMessage = accountSuccessCreationMessage.getText();
		return notificationMessage;
	}
}
