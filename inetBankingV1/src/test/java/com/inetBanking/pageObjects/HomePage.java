package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;

public class HomePage {

	CommonPage commonPage;
	public HomePage(WebDriver driver) {
		commonPage = new CommonPage(driver);
	}
	
	public void clickOnLogout() {
		commonPage.findByLinkText("Log out").click();
	}
	
}
