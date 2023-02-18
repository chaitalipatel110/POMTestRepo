package com.pom.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - Object Repository	
	@FindBy(xpath="//*[@class='sc-bwzfXH hDrfMZ']")
	@CacheLookup
	List<WebElement> Minimizeicon;
	@FindBy(xpath="//div[@id='myAccountBtn']//a[@id='CC-loginHeader-login']")
	@CacheLookup
	WebElement Loginicon;
	@FindBy(xpath="//h3[contains(text(),'Sign in or Create Account')]")
	@CacheLookup
	WebElement Logintext;
	@FindBy(id="CC-login-input")
	@CacheLookup
	WebElement email;
	@FindBy(id="CC-login-password-input")
	@CacheLookup
	WebElement password;
	@FindBy(id="CC-userLoginSubmit")
	@CacheLookup
	WebElement Loginbtn;
	@FindBy(id="CC-loginHeader-createAccount")
	@CacheLookup
	WebElement createaccount;
	@CacheLookup
	@FindBy(xpath="//div[@class='cc-image']/img")
	WebElement Loginimg;
	
	@FindBy(css="#CC-headermodalpane")
	WebElement loginbox;
	
	//Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void clickminimizeicon() {
		if(Minimizeicon.size()>0) {
			//Minimizeicon.click();
			driver.findElement(By.xpath("//*[@class='sc-bwzfXH hDrfMZ']\"")).click();
		}
	}
	public void clickloginicon() {
		Loginicon.click();
	}
	public int verifyloginboxopen()
	{
		String loginboxstyle = loginbox.getAttribute("style");
		if(loginboxstyle=="display: block;") {
			return 1;
		} else {
			return 0;
		}
	}
	public String verifyloginbox()
	{
		String loginboxstyle = loginbox.getAttribute("style");
		return loginboxstyle;
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatePOMImage() {
		return Loginimg.isDisplayed();
	}
	
	public boolean validatePOMText() {
		return Logintext.isDisplayed();
	}
	
	public HomePage login(String un,String pwd ) {
		email.sendKeys(un);
		password.sendKeys(pwd);
		Loginbtn.click();
		
		return new HomePage();
	}
	
}
