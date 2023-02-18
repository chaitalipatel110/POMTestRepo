package com.pom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pom.qa.base.TestBase;
import com.pom.qa.pages.CreditcardsPage;
import com.pom.qa.pages.HomePage;
import com.pom.qa.pages.LoginPage;
import com.pom.qa.util.TestUtil;

public class CreditcardsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	CreditcardsPage creditcardsPage;
	int logedbox = 0;
	String loginboxactualcss = "display: block;";
	String myaccountboxactualcss = "account active";
	String xlsSheetName = "addcardsheet";
	
	public CreditcardsPageTest() {
		super();
	}
	
	@BeforeMethod(groups = "init5")
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		creditcardsPage = new CreditcardsPage();
		
		loginPage.clickminimizeicon();
		
		
		loginPage.clickloginicon();
		String verifyloginbox = loginPage.verifyloginbox();
	    if(verifyloginbox.equals(loginboxactualcss)) {
			homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			logedbox=1;
			Thread.sleep(3000);
		}
	    
	    
	}
	
	@Test(priority = 1)
	public void validateCreditcardslabelTest() {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				creditcardsPage = homePage.clickcreditcardslink();
				boolean flag = creditcardsPage.validateCreditcardlabel();
				Assert.assertTrue(flag,"Credit cards label is missing!");
				System.out.println("Test 1 Pass");
			}
		}
	}
	
	@DataProvider
	public Object[][] getPOMTestData(){
		Object[][] data = TestUtil.getTestData(xlsSheetName);       
        return data;
	}
	
	@Test(priority = 2, dataProvider="getPOMTestData",groups = "init5")
	public void pressaddcard_btn(String cardholderName,String ccNum,String ccCVV,String expiryDate,String firstName,String lastName,String address1,String address2,String city,String state,String postalCode,String phoneNumber) throws InterruptedException {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				creditcardsPage = homePage.clickcreditcardslink();
				Thread.sleep(5000);
				creditcardsPage.pressaddcardbtn(cardholderName,ccNum,ccCVV,expiryDate,firstName,lastName,address1,address2,city,state,postalCode,phoneNumber);
				Thread.sleep(20000);
				System.out.println("Test 2 Pass");
			}
		}
	}
	
	
	
	@AfterMethod(groups = "init5")
	public void tearDown() {
		driver.quit();
	}
	
}
