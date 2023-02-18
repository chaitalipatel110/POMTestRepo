package com.pom.qa.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.pom.qa.base.TestBase;
import com.pom.qa.pages.AddressesPage;
import com.pom.qa.pages.CreditcardsPage;
import com.pom.qa.pages.HomePage;
import com.pom.qa.pages.LoginPage;
import com.pom.qa.pages.OrderhistoryPage;
import com.pom.qa.pages.ProfilePage;
import com.pom.qa.pages.UpdatepasswordPage;
import com.pom.qa.pages.WishlistPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	OrderhistoryPage orderhistoryPage;
	CreditcardsPage creditcardsPage;
	UpdatepasswordPage updatepasswordPage;
	AddressesPage addressesPage;
	WishlistPage wishlistPage;
	ProfilePage profilePage;
	int logedbox=0;
	String loginboxactualcss = "display: block;";
	String myaccountboxactualcss = "account active";
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod(groups = "init2")
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		orderhistoryPage = new OrderhistoryPage();
		creditcardsPage = new CreditcardsPage();
		updatepasswordPage = new UpdatepasswordPage();
		addressesPage = new AddressesPage();
		wishlistPage = new WishlistPage();
		profilePage = new ProfilePage();
		
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
	public void pommyaccountTest() {	
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				boolean flag = homePage.validatemyaccounttext();
				Assert.assertTrue(flag);
				System.out.println("Test 1 Pass");
			}
		}
	}
	@Test(priority = 2)
	public void pomsignoutTest() {	
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				boolean flag = homePage.validatesignouttext();
				Assert.assertTrue(flag);
				System.out.println("Test 2 Pass");
			}
		}
	}
	@Test(priority = 3)
	public void verifyHomePageTitleTest() throws InterruptedException {
		Thread.sleep(3000);
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "All For Sleep | Sleep Country Canada","Title Not Matched");
		System.out.println("Test 3 Pass");
	}	
	
	@Test(priority = 4)
	public void clickorderhistorylinkTest() {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				orderhistoryPage = homePage.clickorderhistorylink();
				System.out.println("Test 4 Pass");
			}
		}
	}
	@Test(priority = 5)
	public void clickcreditcardslinkTest() {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				creditcardsPage = homePage.clickcreditcardslink();
				System.out.println("Test 5 Pass");
			}
		}
	}
	@Test(priority = 6)
	public void clickupdatepasswordlinkTest() {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				updatepasswordPage = homePage.clickupdatepasswordlink();
				System.out.println("Test 6 Pass");
			}
		}
	}
	@Test(priority = 7)
	public void clickaddresseslinkTest() {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				addressesPage = homePage.clickaddresseslink();
				System.out.println("Test 7 Pass");
			}
		}
	}
	@Test(priority = 8)
	public void clickwishlistlinkTest() {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				wishlistPage = homePage.clickwishlistlink();
				System.out.println("Test 8 Pass");
			}
		}
	}
	@Test(priority = 9)
	public void clickprofileTest() {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				profilePage = homePage.clickprofilelink();
				System.out.println("Test 9 Pass");
			}
		}
	}
	
	@Test(priority = 10,groups = "init2")
	public void click_Sealy_Test() throws InterruptedException {
		if(logedbox==1) {
			//SealyPage = homePage.click_Sealy_link();
			homePage.click_Sealy_link();
			Thread.sleep(3000);
			System.out.println("Test 10 Pass");
		}
	}
	
	@AfterMethod(groups = "init2")
	public void tearDown() {
		driver.quit();
	}

}
