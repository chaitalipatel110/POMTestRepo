package com.pom.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pom.qa.base.TestBase;
import com.pom.qa.pages.AddressesPage;
import com.pom.qa.pages.HomePage;
import com.pom.qa.pages.LoginPage;
import com.pom.qa.util.TestUtil;

public class AddressesPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	AddressesPage addressesPage;
	int logedbox = 0;
	String loginboxactualcss = "display: block;";
	String myaccountboxactualcss = "account active";
	String xlsSheetName = "addaddresssheet";
	
	public AddressesPageTest() {
		super();
	}
	
	@BeforeMethod(groups = "init6")
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		addressesPage = new AddressesPage();
		
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
	public void validateAddresseslabelTest() {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				addressesPage = homePage.clickaddresseslink();
				boolean flag = addressesPage.validateAddresseslabel();
				Assert.assertTrue(flag,"Addresses label is missing!");
				System.out.println("Test 1 Pass");
			}
		}
	}
	
	@DataProvider
	public Object[][] getPOMTestData(){
		Object[][] data = TestUtil.getTestData(xlsSheetName);       
        return data;
	}
	
	@Test(priority = 2, dataProvider="getPOMTestData",groups = "init6")
	public void pressaddaddress_btn(String fname, String lname, String address, String unit, String city, String province, String postalcode, String phone) throws InterruptedException {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				addressesPage = homePage.clickaddresseslink();
				Thread.sleep(5000);
				Thread.sleep(25000);
				addressesPage.pressaddaddressbtn(fname,lname,address,unit,city,province,postalcode,phone);
				System.out.println("Test 2 Pass");
			}
		}
	}
	
	
	
@AfterMethod(groups = "init6")
	public void tearDown() {
		driver.quit();
	}
	
}
