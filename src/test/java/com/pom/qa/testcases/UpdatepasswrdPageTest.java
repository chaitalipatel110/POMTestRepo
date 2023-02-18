package com.pom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pom.qa.base.TestBase;
import com.pom.qa.pages.HomePage;
import com.pom.qa.pages.LoginPage;
import com.pom.qa.pages.UpdatepasswordPage;
import com.pom.qa.testdata.Xls_Reader;
import com.pom.qa.util.TestUtil;

public class UpdatepasswrdPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	UpdatepasswordPage updatepasswordPage;
	TestUtil testUtil;
	int logedbox = 0;
	String loginboxactualcss = "display: block;";
	String myaccountboxactualcss = "account active";
	String xlsSheetName = "updatepassworddatasheet";
	
	
	public UpdatepasswrdPageTest() {
		super();
	}
	
	@BeforeMethod(groups = "init8")
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		updatepasswordPage = new UpdatepasswordPage();
		testUtil = new TestUtil();
		
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
	public void validateUpdatepasswordlabelTest() {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				updatepasswordPage = homePage.clickupdatepasswordlink();
				boolean flag = updatepasswordPage.validateUpdatepasswordlabel();
				Assert.assertTrue(flag,"Update Password label is missing!");
				System.out.println("Test 1 Pass");
			}
		}
	}
	
	@Test(priority = 2)
	public void VerifyoldpasswordfieldTest() {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				updatepasswordPage = homePage.clickupdatepasswordlink();
				String updateoldpassdata = updatepasswordPage.verifyoldpasswordfield();	
				if(updateoldpassdata.equals("Old Password")) {
					String opassprop = prop.getProperty("updatepass_opassplaceholder");
					Assert.assertEquals(updateoldpassdata, opassprop,"Old Password is different!");
					System.out.println("Test 2 Pass");	
				} else {
					String opassprop = prop.getProperty("updatepass_opass");
					Assert.assertEquals(updateoldpassdata, opassprop,"Old Password is different!");
					System.out.println("Test 2 Pass");	
				}
			}
		}
	}
	
	@Test(priority = 3)
	public void VerifynewpasswordfieldTest() {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				updatepasswordPage = homePage.clickupdatepasswordlink();
				String updatenewpassdata = updatepasswordPage.verifynewpasswordfield();	
				if(updatenewpassdata.equals("New Password")) {
					String npassprop = prop.getProperty("updatepass_npassplaceholder");
					Assert.assertEquals(updatenewpassdata, npassprop,"New Password is different!");
					System.out.println("Test 3 Pass");	
				} else {
					String npassprop = prop.getProperty("updatepass_npass");
					Assert.assertEquals(updatenewpassdata, npassprop,"New Password is different!");
					System.out.println("Test 3 Pass");	
				}
			}
		}
	}
	
	@Test(priority = 4)
	public void VerifyconfirmnewpasswordfieldTest() {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				updatepasswordPage = homePage.clickupdatepasswordlink();
				String updateconfirmnewpassdata = updatepasswordPage.verifyconfirmnewpasswordfield();	
				if(updateconfirmnewpassdata.equals("Confirm New Password")) {
					String cnpassprop = prop.getProperty("updatepass_cpassplaceholder");
					Assert.assertEquals(updateconfirmnewpassdata, cnpassprop,"Confirm New Password is different!");
					System.out.println("Test 4 Pass");	
				} else {
					String cnpassprop = prop.getProperty("updatepass_cpass");
					Assert.assertEquals(updateconfirmnewpassdata, cnpassprop,"Confirm New Password is different!");
					System.out.println("Test 4 Pass");	
				}
			}
		}
	}
	
	@Test(priority = 5)
	public void pressupdatepassword_btn() throws InterruptedException {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				updatepasswordPage = homePage.clickupdatepasswordlink();
				Thread.sleep(3000);
				updatepasswordPage.pressupdatepasswordbtn();
				System.out.println("Test 5 Pass");
			}
		}
	}
	
	@Test(priority = 6)
	public void presscancel_btn() throws InterruptedException {
		if(logedbox==1) {
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				updatepasswordPage = homePage.clickupdatepasswordlink();
				Thread.sleep(3000);
				updatepasswordPage.presscancelbtn();
				System.out.println("Test 6 Pass");
			}
		}
	}
	
	
	@DataProvider
	public Object[][] getPOMTestData(){
		Object[][] data = TestUtil.getTestData(xlsSheetName);       
        return data;
	}
	
	
	@Test(priority = 7, dataProvider="getPOMTestData", groups = "init8")
	public void updatefieldsTest(String email,String opass, String npass, String cpass) throws InterruptedException {
		if(logedbox==1) {
			Thread.sleep(3000);
			homePage.clickmyaccounticon();
			String verifymyaccountbox = homePage.verifymyaccountbox();
			if(verifymyaccountbox.equals(myaccountboxactualcss)) {
				updatepasswordPage = homePage.clickupdatepasswordlink();
				Thread.sleep(3000);
				updatepasswordPage.updatefields(opass, npass, cpass);
				//password not changed because used password can not use again so Dolly@110 already used once change something new then try
				//updatepasswordPage.presscancelbtn();
				System.out.println("Test 7 Pass");
			}
		}
	}
	
	@AfterMethod(groups = "init8")
	public void tearDown() {
		driver.quit();
	}
	
}
