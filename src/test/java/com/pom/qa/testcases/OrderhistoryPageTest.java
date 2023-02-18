package com.pom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.qa.base.TestBase;
import com.pom.qa.pages.HomePage;
import com.pom.qa.pages.LoginPage;
import com.pom.qa.pages.OrderhistoryPage;

public class OrderhistoryPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	OrderhistoryPage orderhistoryPage;
	int logedbox = 0;
	String loginboxactualcss = "display: block;";
	String myaccountboxactualcss = "account active";
	
	public OrderhistoryPageTest() {
		super();
	}
	
	@BeforeMethod(groups = "init4")
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		orderhistoryPage = new OrderhistoryPage();
		
		loginPage.clickminimizeicon();
		
		
		loginPage.clickloginicon();
		String verifyloginbox = loginPage.verifyloginbox();
	    if(verifyloginbox.equals(loginboxactualcss)) {
			homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			logedbox=1;
			Thread.sleep(3000);
		}
	    
	    
	}
	
	@Test(priority = 1,groups = "init4")
	public void validateOrderhistorylabelTest() {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				orderhistoryPage = homePage.clickorderhistorylink();
				boolean flag = orderhistoryPage.validateorderhistorylabel();
				Assert.assertTrue(flag,"Order history label is missing!");
				System.out.println("Test 1 Pass");
			}
		}
	}
	
	@Test(priority = 2)
	public void pressbacktohome_btn() throws InterruptedException {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				orderhistoryPage = homePage.clickorderhistorylink();
				Thread.sleep(5000);
				orderhistoryPage.pressbacktohomebtn();
				System.out.println("Test 2 Pass");
			}
		}
	}
	
	
	
	@AfterMethod(groups = "init4")
	public void tearDown() {
		driver.quit();
	}
	
}
