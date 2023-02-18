package com.pom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pom.qa.base.TestBase;
import com.pom.qa.pages.HomePage;
import com.pom.qa.pages.LoginPage;
import com.pom.qa.pages.ProfilePage;
import com.pom.qa.util.TestUtil;

public class ProfilePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	int logedbox = 0;
	String loginboxactualcss = "display: block;";
	String myaccountboxactualcss = "account active";
	String xlsSheetName = "updateprofilesheet";
	
	public ProfilePageTest() {
		super();
	}
	
	@BeforeMethod(groups = "init3")
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
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
	public void validateProfilelabelTest() {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				profilePage = homePage.clickprofilelink();
				boolean flag = profilePage.validateProfilelabel();
				Assert.assertTrue(flag,"Profile label is missing!");
				System.out.println("Test 1 Pass");
			}
		}
	}
	
	@Test(priority = 2)
	public void VerifyfnamefieldTest() {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				profilePage = homePage.clickprofilelink();
				String fnamedata = profilePage.verifyfnamefield();	
				if(fnamedata.equals("First Name")) {
					String fnameprop = prop.getProperty("profile_fnameplaceholder");
					Assert.assertEquals(fnamedata, fnameprop,"Profile First Name is different!");
					System.out.println("Test 2 Pass");	
				} else {
					String fnameprop = prop.getProperty("profile_fname");
					Assert.assertEquals(fnamedata, fnameprop,"Profile First Name is different!");
					System.out.println("Test 2 Pass");	
				}
			}
		}
	}
	
	@Test(priority = 3)
	public void VerifylnamefieldTest() {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				profilePage = homePage.clickprofilelink();
				String lnamedata = profilePage.verifylnamefield();	
				if(lnamedata.equals("Last Name")) {
					String lnameprop = prop.getProperty("profile_lnameplaceholder");
					Assert.assertEquals(lnamedata, lnameprop,"Profile Last Name is different!");
					System.out.println("Test 3 Pass");
				} else {
					String lnameprop = prop.getProperty("profile_lname");
					Assert.assertEquals(lnamedata, lnameprop,"Profile Last Name is different!");
					System.out.println("Test 3 Pass");	
				}	
			}
		}
	}
	
	@Test(priority = 4)
	public void VerifyemailfieldTest() {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				profilePage = homePage.clickprofilelink();
				String emaildata = profilePage.verifyemailfield();
				String emailprop = prop.getProperty("profile_email");
				Assert.assertEquals(emaildata, emailprop,"Profile Email is different!");
				System.out.println("Test 4 Pass");	
			}
		}
	}
	
	@Test(priority = 5)
	public void selectcheckbox_1() throws InterruptedException {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				profilePage = homePage.clickprofilelink();
				Thread.sleep(3000);
				profilePage.selectcheckbox1();
				System.out.println("Test 5 Pass");	
			}
		}	
	}
	
	@Test(priority = 6)
	public void selectcheckbox_2() throws InterruptedException {		
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				profilePage = homePage.clickprofilelink();
				Thread.sleep(3000);
				profilePage.selectcheckbox2();
				System.out.println("Test 6 Pass");	
			}
		}
	}
	
	@Test(priority = 7)
	public void presssavechanges_btn() throws InterruptedException {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				profilePage = homePage.clickprofilelink();
				Thread.sleep(3000);
				profilePage.presssavechangesbtn();
				System.out.println("Test 7 Pass");
			}
		}
	}
	
	@Test(priority = 8)
	public void presscancel_btn() throws InterruptedException {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				profilePage = homePage.clickprofilelink();
				Thread.sleep(3000);
				profilePage.presscancelbtn();
				System.out.println("Test 8 Pass");
			}
		}
	}
	
	@DataProvider
	public Object[][] getPOMTestData(){
		Object[][] data = TestUtil.getTestData(xlsSheetName);       
        return data;
	}

	@Test(priority = 9, dataProvider="getPOMTestData",groups = "init3")
	public void updateprofileTest(String fname,String lname) throws InterruptedException {
		if(logedbox==1) {
			Thread.sleep(3000);
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				profilePage = homePage.clickprofilelink();
				Thread.sleep(3000);
				profilePage.updateprofile(fname,lname);
				System.out.println("Test 8 Pass");
			}
			
		}
	}
	
	
	
	@AfterMethod(groups = "init3")
	public void tearDown() {
		driver.quit();
	}
	
}
