package com.pom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory - Object Repository
	@FindBy(xpath="//div[@id='myAccountBtn']")
	WebElement Myaccounticon;
	
	@FindBy(xpath="//p[@class='body-2 style-2']")
	WebElement myaccount;
	
	@FindBy(xpath="//button[contains(text(),'SIGN OUT')]")
	WebElement signout;

	@FindBy(xpath="//a[@class='body-3'][contains(text(),'Order History')]")
	WebElement Orderhistory;
	@FindBy(xpath="//a[@class='body-3'][contains(text(),'Credit Cards')]")
	WebElement Creditcards;
	@FindBy(xpath="//a[@class='body-3'][contains(text(),'Update Password')]")
	WebElement Updatepassword;
	@FindBy(xpath="//a[@class='body-3'][contains(text(),'Addresses')]")
	WebElement Addresses;
	@FindBy(xpath="//a[@class='body-3'][contains(text(),'Wishlist')]")
	WebElement Wishlist;
	@FindBy(xpath="//a[@class='body-3'][contains(text(),'Profile')]")
	WebElement Profile;
	
	@FindBy(css="#myAccountBtn")
	WebElement myAccountbox;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav pull-right']/li[1]")
	WebElement Mattresses;
	@FindBy(xpath="//ul[@class='dropdown-menu']//a[contains(text(),'Shop by Brand')]")
	WebElement M_title1;
	@FindBy(xpath="//ul[@class='dropdown-menu']//a[contains(text(),'Sealy')]")
	WebElement M_title1_link1;
	
	
	
	@FindBy(xpath="//ul[@class='nav navbar-nav pull-right']/li[2]")
	WebElement Pillows;

	@FindBy(xpath="//ul[@class='nav navbar-nav pull-right']/li[3]")
	WebElement Bedding;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav pull-right']/li[4]")
	WebElement Furniture;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav pull-right']/li[5]")
	WebElement Valentinesgiftshop;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav pull-right']/li[6]")
	WebElement Specials;
	
	
	
	//Initializing the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
		
	//Actions
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	public boolean validatemyaccounttext() {
		return myaccount.isDisplayed();
	}
	
	public boolean validatesignouttext() {
		return signout.isDisplayed();
	}
	public void clickmyaccounticon() {
		Myaccounticon.click();
	}
	public int verifymyaccountboxopen()
	{
		String myAccountboxstyle = myAccountbox.getAttribute("Class");
		if(myAccountboxstyle == "account active"){
			return 1;
		} else {
			return 0;
		}
	}	
	public String verifymyaccountbox()
	{
		String myAccountboxstyle = myAccountbox.getAttribute("Class");
		return myAccountboxstyle;
	}	
	public OrderhistoryPage clickorderhistorylink() {
		Orderhistory.click();
		return new OrderhistoryPage();
	}	
	public CreditcardsPage clickcreditcardslink() {
		Creditcards.click();
		return new CreditcardsPage();
	}	
	public UpdatepasswordPage clickupdatepasswordlink() {
		Updatepassword.click();
		return new UpdatepasswordPage();
	}	
	public AddressesPage clickaddresseslink() {
		Addresses.click();
		return new AddressesPage();
	}	
	public WishlistPage clickwishlistlink() {
		Wishlist.click();
		return new WishlistPage();
	}	
	public ProfilePage clickprofilelink() {
		Profile.click();
		return new ProfilePage();
	}
	
	public boolean validateShopByBrandtext() {
		return M_title1.isDisplayed();
	}
	
	public SealyPage click_Sealy_link() {
	//public void click_Sealy_link() {
		Actions action = new Actions(driver);
		action.moveToElement(Mattresses).build().perform();
		M_title1_link1.click();
		return new SealyPage();
		
	}
	
	public PillowsPage clickpillowslink() {
		Actions action = new Actions(driver);
		action.moveToElement(Pillows).build().perform();
		return new PillowsPage();
	}
	
	public BeddingPage clickbeddinglink() {
		Actions action = new Actions(driver);
		action.moveToElement(Bedding).build().perform();
		return new BeddingPage();
	}
	
	public FurniturePage clickfurniturelink() {
		Actions action = new Actions(driver);
		action.moveToElement(Furniture).build().perform();
		return new FurniturePage();
	}
	
	public SpecialsPage clickspecialslink() {
		Actions action = new Actions(driver);
		action.moveToElement(Specials).build().perform();
		return new SpecialsPage();
	}

}