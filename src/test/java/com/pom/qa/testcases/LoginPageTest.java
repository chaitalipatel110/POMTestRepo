package com.pom.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pom.qa.base.TestBase;
import com.pom.qa.pages.HomePage;
import com.pom.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;

	String loginboxactualcss = "display: block;";
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod(groups = "init1")
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		
		loginPage.clickminimizeicon();	
		
	}
	
	@Test(priority = 1,groups = "init1")
	public void pomImageTest() {
		loginPage.clickloginicon();
		String verifyloginbox = loginPage.verifyloginbox();
	    if(verifyloginbox.equals(loginboxactualcss)) {
			boolean flag = loginPage.validatePOMImage();
			Assert.assertTrue(flag, "No Image found.");  
			System.out.println("Test 1 Pass");
		} 
	}
	@Test(priority = 2)
	public void pomTextTest() {
		loginPage.clickloginicon();
		String verifyloginbox = loginPage.verifyloginbox();
	    if(verifyloginbox.equals(loginboxactualcss)) {
	    	boolean flag = loginPage.validatePOMText();
			Assert.assertTrue(flag, "No Text found.");
			System.out.println("Test 2 Pass");
	    } 
	}
	@Test(priority = 3)
	public void loginTest() throws InterruptedException {
		loginPage.clickloginicon();
		String verifyloginbox = loginPage.verifyloginbox();
	    if(verifyloginbox.equals(loginboxactualcss)) {
	    	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    	Thread.sleep(3000);
	    	System.out.println("Test 3 Pass");
	    }  
	}
	@Test(priority = 4)
	public void loginPageTitleTest() throws InterruptedException {
		Thread.sleep(3000);
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "All For Sleep | Sleep Country Canada","Title Not Matched");
		System.out.println("Test 4 Pass");
	}
	
	
	@AfterMethod(groups = "init1")
	public void tearDown() {
		driver.quit();
	}

}
