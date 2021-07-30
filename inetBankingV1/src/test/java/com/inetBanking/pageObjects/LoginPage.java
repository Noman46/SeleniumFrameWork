package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;

public class LoginPage {

	CommonPage commonPage;
	public LoginPage(WebDriver driver) {
		commonPage = new CommonPage(driver);
	}
	
	public void sendKeysToUserName(String userName) {
		commonPage.findEleByName("uid").sendKeys(userName);
	}
	public void sendKeysToPassword(String password) {
		commonPage.findEleByName("password").sendKeys(password);
	}
	public void clickOnLoginButton() {
		commonPage.findEleByName("btnLogin").click();
	}
}
