package com.pom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.qa.base.TestBase;

public class WishlistPage extends TestBase {
	
	@FindBy(xpath="//h3[@class='wishlist-text']")
	WebElement wishlisttext;
	
	@FindBy(xpath="//div[@class='no-data']//button[@class='no-wishlist cta']")
	WebElement gotoomebtn;
	
	public WishlistPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validatewishlistlabel() {
		return wishlisttext.isDisplayed();
	}
	
	public void pressgotohomebtn() {
		gotoomebtn.click();
	}

}
