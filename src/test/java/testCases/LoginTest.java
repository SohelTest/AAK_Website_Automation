package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.baseClass;

public class LoginTest extends baseClass {

	Page_Object_Model.pom pom;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void browser() throws InterruptedException {

		openBrowser();
		Thread.sleep(2000);
		screenshots("--Open Browser");
		pom = new Page_Object_Model.pom();

	}

	@Test
	public void CheckingLink() throws InterruptedException {

		Assert.assertEquals(pom.verifyPage(), prop.getProperty("expectedLoginURL"));
		Thread.sleep(2000);
		screenshots("--verifyURL");
	}

	@Test
	public void SuccessfullLogin() throws InterruptedException {

		pom.enterusername(prop.getProperty("username"));
		pom.enterpassword(prop.getProperty("password"));
		pom.clickLoginBtn();
		Thread.sleep(4000);
		Assert.assertEquals(pom.verifyPage(), prop.getProperty("expectedDashboardURL") + prop.getProperty("username"));
		screenshots("--Successfull Login");

	}

	@Test
	public void WrongUsernameLogin() throws InterruptedException {
		pom.enterusername(prop.getProperty("WrongUsername"));
		pom.enterpassword(prop.getProperty("password"));
		pom.clickLoginBtn();
		Thread.sleep(4000);
		Assert.assertEquals(pom.verifyErrorMessage(), true);

		screenshots("--Wrong Username Error Message");

	}

	@Test
	public void WrongPasswordLogin() throws InterruptedException {

		pom.enterusername(prop.getProperty("username"));
		pom.enterpassword(prop.getProperty("WrongPassword"));
		pom.clickLoginBtn();
		Thread.sleep(4000);
		Assert.assertEquals(pom.verifyErrorMessage(), true);

		screenshots("--Wrong Password Error Message");

	}

	@Test
	public void WrongUsernameAndPasswordLogin() throws InterruptedException {

		pom.enterusername(prop.getProperty("WrongUsername"));
		pom.enterpassword(prop.getProperty("WrongPassword"));
		pom.clickLoginBtn();
		Thread.sleep(4000);
		Assert.assertEquals(pom.verifyErrorMessage(), true);

		screenshots("--Wrong Username And Password Error Message");
	}

	@Test
	public void RememberMeCheckbox() throws InterruptedException {

		pom.enterusername(prop.getProperty("username"));
		pom.enterpassword(prop.getProperty("password"));
		pom.rememberMeCheckbox();
		pom.clickLoginBtn();
		Thread.sleep(4000);

		driver.quit();
		openBrowser();
		Thread.sleep(5000);
		screenshots("--After Remember Me");
		Assert.assertEquals(pom.verifyPage(), prop.getProperty("expectedDashboardURL") + prop.getProperty("username"));
		

	}

	@AfterMethod
	public void closedriver() {
		driver.close();
	}
}
