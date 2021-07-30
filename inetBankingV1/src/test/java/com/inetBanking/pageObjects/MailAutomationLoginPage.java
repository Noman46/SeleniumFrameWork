package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;

public class MailAutomationLoginPage {
	CommonPage commonPage;
	public MailAutomationLoginPage(WebDriver driver) {
		commonPage = new CommonPage(driver);
	}
	
	public void sendKeysToUserName(String userName) {
		commonPage.findEleByName("email").sendKeys(userName);
	}
	public void sendKeysToPassword(String password) {
		commonPage.findEleByName("password").sendKeys(password);
	}
	public void clickOnCreateAccountLink(String linkText) {
		commonPage.findByLinkText(linkText).click();
	}
	public void clickOnCreateAccountButton() {
		commonPage.findByClassName("Button__button___vS7Mv").click();
	}
}
