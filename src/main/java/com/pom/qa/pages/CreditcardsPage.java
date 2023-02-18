package com.pom.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pom.qa.base.TestBase;

public class CreditcardsPage extends TestBase {
	
	@FindBy(xpath="//h3[contains(text(),'Credit Cards')]")
	WebElement creditcardtext;
	
	@FindBy(xpath="//div[@class='card add-card']")
	WebElement addcardicon;
	
	@FindBy(xpath="//div[@class='modal-footer']//button[contains(text(),'SAVE MY CARD')]")
	WebElement savecardbtn;
	
	
	
	
	
	public CreditcardsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateCreditcardlabel() {
		return creditcardtext.isDisplayed();
	}
	
	public void pressaddcardbtn(String cardholderName,String ccNum,String ccCVV,String expiryDate,String firstName,String lastName,String address1,String address2,String city,String state,String postalCode,String phoneNumber) {
		addcardicon.click();
		String parentHandle = driver.getWindowHandle(); 
		
		for (String winHandle : driver.getWindowHandles()) {
			
            driver.switchTo().window(winHandle); 
            WebDriverWait wait = new WebDriverWait(driver, 30);
            
            WebElement addcreditcardtext = driver.findElement(By.xpath("//h3[contains(text(),'Add Credit Card')]"));
    		System.out.println(addcreditcardtext.getSize());
    		if(addcreditcardtext.isDisplayed()) {
    			System.out.println("AddCreditCard Test Present");
    		} else {
    			System.out.println("AddCreditCard Text Not Present");
    		}
    		WebElement f_cardholderName = driver.findElement(By.id("cardholderName"));
    		f_cardholderName.sendKeys(cardholderName);
    		
    		driver.switchTo().frame(driver.findElement(By.id("ccframe")));
    		
    		WebElement f_ccNum = driver.findElement(By.id("ccNum"));
    		WebElement f_ccCVV = driver.findElement(By.id("ccCVV"));
    		
    		f_ccNum.sendKeys(ccNum);
    		f_ccCVV.sendKeys(ccCVV);
    		
    		driver.switchTo().parentFrame();
    		
    		WebElement f_expiryDate = driver.findElement(By.id("expiryDate"));
    		WebElement f_firstName = driver.findElement(By.id("CC-Savedcard-firstName"));
    		WebElement f_lastName = driver.findElement(By.id("CC-Savedcard-lastName"));
    		WebElement f_address1 = driver.findElement(By.id("CC-Savedcard-address1"));
    		WebElement f_address2 = driver.findElement(By.id("CC-Savedcard-address2"));
    		WebElement f_city = driver.findElement(By.id("CC-Savedcard-city"));
    		Select f_state = new Select(driver.findElement(By.id("CC-Savedcard-state"))); 
    		WebElement f_postalCode = driver.findElement(By.id("CC-Savedcard-postalCode"));
    		WebElement f_phoneNumber = driver.findElement(By.id("CC-Savedcard-phoneNumber"));
    		f_expiryDate.sendKeys(expiryDate);
    		f_firstName.sendKeys(firstName);
    		f_lastName.sendKeys(lastName);
    		f_address1.sendKeys(address1);
    		f_address2.sendKeys(address2);
    		f_city.sendKeys(city);	
    		f_state.selectByVisibleText(state);
    		f_postalCode.sendKeys(postalCode);
    		f_phoneNumber.sendKeys(phoneNumber);
    		

    		/*List<WebElement> dropdownList = driver.findElements(By.id("CC-Savedcard-state"));
    		System.out.println(dropdownList.size());
    		for(int i=0; i<dropdownList.size(); i++) {
    			System.out.println(dropdownList.get(i).getText()+"-----"+dropdownList.get(i).isSelected());
    		}
    		
    		Select state = new Select(driver.findElement(By.id("CC-Savedcard-state"))); 
    		state.selectByVisibleText(statename);
    		for(int i=0; i<dropdownList.size(); i++) {
    			System.out.println(dropdownList.get(i).getText()+"-----"+dropdownList.get(i).isSelected());
    		}*/
    		
    		//wait.until(ExpectedConditions.elementToBeClickable(savecardbtn));
    		
    		savecardbtn.click();
    		

        }
		
		driver.switchTo().window(parentHandle); 
	}
	
	

}
