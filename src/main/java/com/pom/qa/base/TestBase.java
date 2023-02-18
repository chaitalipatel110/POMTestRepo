package com.pom.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.pom.qa.util.TestUtil;
import com.pom.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\qa\\Selenium_Workspace\\POMTest\\src\\main\\java\\com\\pom\\qa\\config\\config.properties");
			prop.load(ip);
		
		}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.gecko.driver","C:\\qa\\SeleniumJars\\geckodriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\qa\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("Safari")) {
			System.setProperty("webdriver.gecko.driver","C:\\qa\\SeleniumJars\\geckodriver.exe");
			driver = new SafariDriver();
		} else if (browserName.equals("InternetExplorer")) {
			System.setProperty("webdriver.gecko.driver","C:\\qa\\SeleniumJars\\geckodriver.exe");
			driver = new InternetExplorerDriver();
		} else if (browserName.equals("Edge")) {
			System.setProperty("webdriver.gecko.driver","C:\\qa\\SeleniumJars\\geckodriver.exe");
			driver = new EdgeDriver();
		} 
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
}
