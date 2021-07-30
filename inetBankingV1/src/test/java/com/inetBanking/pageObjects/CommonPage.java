package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {

	
	WebDriver lDriver;
	WebElement webElement;
	
	public CommonPage (WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	
	public WebElement findById(String id) {
		return lDriver.findElement(By.id(id));
	}
	public WebElement findByClassName(String className) {
		return lDriver.findElement(By.className(className));
	}
	public WebElement findEleByName (String name) {
		return lDriver.findElement(By.name(name));
	}
	public WebElement findByTagName(String tagName) {
		return lDriver.findElement(By.tagName(tagName));
	}
	public WebElement findByLinkText(String linkText) {
		return lDriver.findElement(By.linkText(linkText));
	}
	public WebElement findByPartialLinkText(String partialLinkText) {
		return lDriver.findElement(By.partialLinkText(partialLinkText));
	}
	public WebElement findByXpath(String xpath) {
		return lDriver.findElement(By.xpath(xpath));
	}
	
	
}
