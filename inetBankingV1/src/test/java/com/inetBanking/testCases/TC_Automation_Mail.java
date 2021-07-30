package com.inetBanking.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.inetBanking.utilites.AllureListener;
import com.inetBanking.utilites.MailUtility;

@Listeners({ AllureListener.class })
public class TC_Automation_Mail extends BaseClass {

//	@Test(priority = 0)
//	public void test1_SignUp() throws InterruptedException {
//		driver.get(properties.getProperty("MAILSLURP_URL"));
//		Thread.sleep(2000);
//		assertEquals(driver.getTitle(), "React App");
//
//		MailAutomationLoginPage mailAutomationLoginPage = new MailAutomationLoginPage(driver);
//		mailAutomationLoginPage.clickOnCreateAccountLink("Create account");
//		Thread.sleep(2000);
//		mailAutomationLoginPage.sendKeysToUserName("User name");
//		mailAutomationLoginPage.sendKeysToPassword("password");
//		mailAutomationLoginPage.clickOnCreateAccountButton();
//	}
	@Test(priority = 0)
	public void test2_verifyEmailSubject() throws InterruptedException, IOException, ParseException {
		MailUtility mailUtility = new MailUtility();
		String emailSubject = mailUtility.getEmailSubject();
		int attachmentFileNumber = mailUtility.getAttachmentFilesNumber();
		String attachmentFileName = mailUtility.getAttachmentFileNameOf(1);
		String contentType = mailUtility.getAttachmentContentType(1);
		boolean hasImageLink = mailUtility.verifyTheMailBodyHas("/<img src/g");
		String ccList = mailUtility.getCCList();
		
		assertEquals(emailSubject, "This is a mail to test automation");
		assertEquals(attachmentFileNumber, 2);
		assertEquals(attachmentFileName, "NID_BACK.JPG");
		assertEquals(contentType, "image/jpeg");
		//assertEquals(hasImageLink, true);
		assertEquals(ccList, "abc@mail.com, abd@mail.com");

	}
}
