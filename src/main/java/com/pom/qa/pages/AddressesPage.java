package com.pom.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pom.qa.base.TestBase;

public class AddressesPage extends TestBase {
	
	@FindBy(xpath="//div[@id='CC-customerProfile-addressBook-title']")
	WebElement addressestext;
	
	@FindBy(xpath="//button[@id='cc-customer-profile-shipping-address-add']")
	WebElement addaddressicon;
	
	@FindBy(id="CC-customerProfile-save")
	WebElement saveaddressbtn;
	
	public AddressesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateAddresseslabel() {
		return addressestext.isDisplayed();
	}
	
	public void pressaddaddressbtn(String fname, String lname, String address, String unit, String city, String province, String postalcode, String phone) {
		addaddressicon.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		WebElement addressestext = driver.findElement(By.id("CC-customerProfile-addressBook-title"));
		System.out.println(addressestext.getSize());
		if(addressestext.isDisplayed()) {
			System.out.println("Addresses Text Present");
		} else {
			System.out.println("Addresses Text Not Present");
		}
		WebElement f_fname = driver.findElement(By.id("CC-customerProfile-sfirstname"));	
		WebElement f_lname = driver.findElement(By.id("CC-customerProfile-slastname"));	
		WebElement f_address = driver.findElement(By.id("CC-customerProfile-saddress1"));
		WebElement f_unit = driver.findElement(By.id("CC-customerProfile-saddress2"));
		WebElement f_city = driver.findElement(By.id("CC-customerProfile-scity"));	
		Select f_province = new Select(driver.findElement(By.id("CC-customerProfile-sstate"))); 	
		WebElement f_postalcode = driver.findElement(By.id("CC-customerProfile-szipcode"));
		WebElement f_phone = driver.findElement(By.id("CC-customerProfile-sphone"));
		
		f_fname.sendKeys(fname);
		f_lname.sendKeys(lname);
		f_address.sendKeys(address);
		f_unit.sendKeys(unit);
		f_city.sendKeys(city);
		f_province.selectByVisibleText(province);
		f_postalcode.sendKeys(postalcode);
		f_phone.sendKeys(phone);
		
		wait.until(ExpectedConditions.elementToBeClickable(saveaddressbtn));
		saveaddressbtn.click();
	}

}
