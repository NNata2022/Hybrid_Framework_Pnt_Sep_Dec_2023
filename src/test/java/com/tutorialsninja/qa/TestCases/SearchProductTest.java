package com.tutorialsninja.qa.TestCases;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.HomePage;
import com.tutorialsninja.qa.Pages.SearchPage;
import com.tutorialsninja.qa.TestBase.TestBase;

public class SearchProductTest extends TestBase{
	public SearchProductTest() throws Exception {
		super();
	}


public WebDriver driver;
public HomePage homepage;
public SearchPage searchpage;
	
	@BeforeMethod
	public void registerSetup() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		
	}
	
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		homepage = new HomePage(driver);
		homepage.enterProductDetail(dataProp.getProperty("validProduct"));
		searchpage = homepage.clickOnSearchIcon();//System will be re-directed to SearchPage
		//driver.findElement(By.name("search")).sendKeys("HP");
		//driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		//SearchPage searchpage = new SearchPage(driver);
		Assert.assertTrue(searchpage.verifyDisplayStatusOfInValidProduct()); //deliberate failure
		
		//Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}
	
	@Test(priority=2)
	public void verifySearchWithInvalidProduct() {
		homepage = new HomePage(driver);
		searchpage = homepage.clickOnSearchIcon();
		homepage.enterProductDetail(dataProp.getProperty("invalidProduct"));
		//SearchPage searchpage = new SearchPage(driver);
		Assert.assertTrue(searchpage.verifyDisplayStatusOfInValidProduct());
//		driver.findElement(By.name("search")).sendKeys("DELL");
//		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
//		Assert.assertTrue(driver.findElement(By.xpath("//p[text() = 'There is no product that matches the search criteria.']")).isDisplayed());
	}
	
	@Test(priority=3)
	public void verifySearchWithNoProduct() {
		
		homepage = new HomePage(driver);
		searchpage =  homepage.clickOnSearchIcon();
		//SearchPage searchpage = new SearchPage(driver);
		Assert.assertTrue(searchpage.verifyDisplayStatusOfInValidProduct());
		
	}
	
		//driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		//Assert.assertTrue(driver.findElement(By.xpath("//p[text() = 'There is no product that matches the search criteria.']")).isDisplayed());
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
