package com.pom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.qa.base.TestBase;

public class OrderhistoryPage extends TestBase {
	
	@FindBy(xpath="//legend[@id='CC-orderHistory-title']")
	WebElement orderhistorytext;
	
	@FindBy(xpath="//section[@id='orders-info']//a[@class='no-orderHistory cta']")
	WebElement backtoomebtn;
	
	public OrderhistoryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateorderhistorylabel() {
		return orderhistorytext.isDisplayed();
	}
	
	public void pressbacktohomebtn() {
		backtoomebtn.click();
	}

}
