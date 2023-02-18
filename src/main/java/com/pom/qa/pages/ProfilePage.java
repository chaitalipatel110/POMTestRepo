package com.pom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.qa.base.TestBase;

public class ProfilePage extends TestBase {
	
	@FindBy(xpath="//h3[@id='CC-customerAccount-title']")
	WebElement prfiletext;
	
	@FindBy(xpath="//input[@id='CC-customerProfile-edit-details-firstname']")
	WebElement fnamedata;
	
	@FindBy(xpath="//input[@id='CC-customerProfile-edit-details-lastname']")
	WebElement lnamedata;
	
	@FindBy(xpath="//input[@id='CC-customerProfile-edit-details-emailAddress']")
	WebElement emaildata;
	
	@FindBy(xpath="//div[@id='CC-customerProfile-edit-marketingMail-checkbox']")
	WebElement checkbox1;
	
	@FindBy(xpath="//div[@id='CC-customerProfile-edit-personalizationConsent-checkbox']")
	WebElement checkbox2;
	
	@FindBy(xpath="//div[@id='CC-customerProfile-save-cancel-control']")
	WebElement savechangesbtn;
	
	@FindBy(xpath="//div[@id='CC-customerProfile-save-cancel-control']")
	WebElement cancelbtn;
	
	
	
	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateProfilelabel() {
		return prfiletext.isDisplayed();
	}
	
	public String verifyfnamefield() {
		String firstname = fnamedata.getAttribute("value");
		if(firstname.equals(null)) {
			String fname = fnamedata.getAttribute("placeholder");
			return fname;
		} else {
			String fname=firstname;
			return fname;
		}
	}
	
    public String verifylnamefield() {
		String lastname = lnamedata.getAttribute("value");
		if(lastname.equals(null)) {
			String lname = lnamedata.getAttribute("placeholder");
			return lname;
		} else {
			String lname=lastname;
			return lname;
		}
	}
	
	public String verifyemailfield() {
		String email = emaildata.getAttribute("value");
		return email;
	}
	
	public void selectcheckbox1() {
		checkbox1.click();
	}
	
	public void selectcheckbox2() {
		checkbox2.click();
	}
		
	public void updateprofile(String fname, String lname) {
			
		fnamedata.clear();
		fnamedata.sendKeys(fname);
		lnamedata.clear();
		lnamedata.sendKeys(lname);	
		checkbox1.click();
		checkbox2.click();
		
		savechangesbtn.click();
	}
	
	public void presssavechangesbtn() {
		savechangesbtn.click();
	}
	
	public void presscancelbtn() {
		cancelbtn.click();
	}
	
	

}
