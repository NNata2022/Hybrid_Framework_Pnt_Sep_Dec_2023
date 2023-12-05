package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	//I will list down all the Objects that i see in this webPage
	
	@FindBy(linkText = "My Account")
	private WebElement myAccountDropdown;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(name = "search")
	private WebElement searchTextBoxField;
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	//Need to initialize the object which i have defined above
	//what helps initialize object on Java - constructor
	
	public HomePage(WebDriver driver) {
		this.driver = driver;//this keyword for initialize current class variable
		//PageFactory.initElements(driver, HomePage.class);//you can initialize all webelements in one shot
		PageFactory.initElements(driver, this);//you can use both ways
	}
	//Actions for each webElement
	public void clickOnMyAccountDropMenu() {
		myAccountDropdown.click();
	}
	
	public LoginPage selectLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public void enterProductDetail(String productNameText) {
		searchTextBoxField.sendKeys(productNameText);
	}
	
	public SearchPage clickOnSearchIcon() {
		searchButton.click();
		return new SearchPage(driver);
	}

}
