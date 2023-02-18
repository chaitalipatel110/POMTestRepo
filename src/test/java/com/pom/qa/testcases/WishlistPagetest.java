package com.pom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.qa.base.TestBase;
import com.pom.qa.pages.HomePage;
import com.pom.qa.pages.LoginPage;
import com.pom.qa.pages.WishlistPage;

public class WishlistPagetest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	WishlistPage wishlistPage;
	int logedbox = 0;
	String loginboxactualcss = "display: block;";
	String myaccountboxactualcss = "account active";
	
	public WishlistPagetest() {
		super();
	}
	
	@BeforeMethod(groups = "init7")
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		wishlistPage = new WishlistPage();
		
		loginPage.clickminimizeicon();
		
		
		loginPage.clickloginicon();
		String verifyloginbox = loginPage.verifyloginbox();
	    if(verifyloginbox.equals(loginboxactualcss)) {
			homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			logedbox=1;
			Thread.sleep(3000);
		}
	    
	    
	}
	
	@Test(priority = 1,groups = "init7")
	public void validateWishlistlabelTest() {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				wishlistPage = homePage.clickwishlistlink();
				boolean flag = wishlistPage.validatewishlistlabel();
				Assert.assertTrue(flag,"Wishlist label is missing!");
				System.out.println("Test 1 Pass");
			}
		}
	}
	
	@Test(priority = 2)
	public void pressgotohome_btn() throws InterruptedException {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				wishlistPage = homePage.clickwishlistlink();
				Thread.sleep(5000);
				wishlistPage.pressgotohomebtn();
				System.out.println("Test 2 Pass");
			}
		}
	}
	
	
	
	@AfterMethod(groups = "init7")
	public void tearDown() {
		driver.quit();
	}
	
}
