package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.baseClass;

public class ForgotPassword extends baseClass {

	Page_Object_Model.pom pom;

	public ForgotPassword() {
		super();
	}

	@BeforeMethod
	public void browser() throws InterruptedException {

		openBrowser();
		Thread.sleep(2000);
		screenshots("--Open Browser");
		pom = new Page_Object_Model.pom();

	}

	@Test(priority = 1)
	public void forgotPasswordLink() throws InterruptedException {
		pom.forgotPasswordClkBtn();
		Thread.sleep(2000);
		Assert.assertEquals(pom.verifyPage(), prop.getProperty("expectedforgotPasswordURL"));
		screenshots("--Forgot Password URL");
	}

	@Test(priority = 2)
	public void WrongMailIDForgotPassword() throws InterruptedException {
		pom.forgotPasswordClkBtn();
		Thread.sleep(2000);
		pom.enterEmail(prop.getProperty("WrongforgotMailId"));
		pom.clickNextBtn();
		Thread.sleep(4000);
		screenshots("--Forgot Password Wrong MailID");
		Assert.assertEquals(pom.verifyWrongMailSend(), true);
		

	}

	@Test(priority = 3)
	public void forgotPassword() throws InterruptedException {

		pom.forgotPasswordClkBtn();
		Thread.sleep(2000);
		pom.enterEmail(prop.getProperty("forgotMailId"));
		pom.clickNextBtn();
		Thread.sleep(4000);
		Assert.assertEquals(pom.verifyMailSend(), true);
		screenshots("--Forgot Password Mail Send Successfully");

	}

	@AfterMethod
	public void closedriver() {
		driver.close();
	}
}
