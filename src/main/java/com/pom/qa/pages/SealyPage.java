package com.pom.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.pom.qa.base.TestBase;

public class SealyPage extends TestBase{
	
	public SealyPage() {
		PageFactory.initElements(driver, this);
	}

}