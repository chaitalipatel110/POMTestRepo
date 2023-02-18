package com.pom.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.qa.base.TestBase;

public class UpdatepasswordPage extends TestBase{
	
	@FindBy(xpath="//div[@id='CC-customerProfile-password-title']")
	WebElement updatepasswordtext;
	
	@FindBy(xpath="//input[@id='CC-customerProfile-soldPassword-1']")
	WebElement oldpassworddata;
	
	@FindBy(xpath="//input[@id='CC-customerProfile-spassword-1']")
	WebElement newpassworddata;
	
	@FindBy(xpath="//input[@id='CC-customerProfile-sconfirmPassword']")
	WebElement confirmnewpassworddata;
	
	@FindBy(xpath="//div[@id='CC-customerProfile-save-cancel-control']//button[@id='CC-customerProfile-save']")
	WebElement updatepasswordbtn;
	
	@FindBy(xpath="//div[@id='CC-customerProfile-save-cancel-control']//span[@data-bind=\"widgetLocaleText: 'buttonCancel'\"]")
	WebElement cancelbtn;
	
	public UpdatepasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateUpdatepasswordlabel() {
		return updatepasswordtext.isDisplayed();
	}
	
	public String verifyoldpasswordfield() {
		String oldpassword = oldpassworddata.getAttribute("value");
		if(oldpassword.equals(null)) {
			String oldpass = oldpassworddata.getAttribute("placeholder");
			return oldpass;
		} else {
			String oldpass=oldpassword;
			return oldpass;
		}
	}
	
	public String verifynewpasswordfield() {
		String newpassword = newpassworddata.getAttribute("value");
		if(newpassword.equals(null)) {
			String newpass = newpassworddata.getAttribute("placeholder");
			return newpass;
		} else {
			String newpass=newpassword;
			return newpass;
		}
	}
	
	public String verifyconfirmnewpasswordfield() {
		String confirmnewpassword = confirmnewpassworddata.getAttribute("value");
		if(confirmnewpassword.equals(null)) {
			String confirmnewpass = confirmnewpassworddata.getAttribute("placeholder");
			return confirmnewpass;
		} else {
			String confirmnewpass=confirmnewpassword;
			return confirmnewpass;
		}
	}
	

	public void updatefields(String opass, String npass, String cpass) {
		WebElement oldpassword = driver.findElement(By.id("CC-customerProfile-soldPassword-1"));
		WebElement newpassword = driver.findElement(By.id("CC-customerProfile-spassword-1"));
		WebElement confirmpassword = driver.findElement(By.id("CC-customerProfile-sconfirmPassword"));	
		WebElement updatepassword = driver.findElement(By.id("CC-customerProfile-save"));
			
		oldpassword.sendKeys(opass);
		newpassword.sendKeys(npass);
		confirmpassword.sendKeys(cpass);	
		//oldpassworddata.sendKeys(opass);
		//newpassworddata.sendKeys(npass);
		//confirmnewpassworddata.sendKeys(cpass);
		
		updatepassword.click();
	}
	
	public void pressupdatepasswordbtn() {
		updatepasswordbtn.click();
	}

	public void presscancelbtn() {
		cancelbtn.click();
	}

}
