package Page_Object_Model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.baseClass;

public class pom extends baseClass {

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//span[text()='There was a problem with that action']")
	WebElement errorMessageFirstLine;
	
	@FindBy(xpath = "//span[text()='No active account found with the given credentials']")
	WebElement errorMessageSecondLine;
	
	@FindBy(xpath="//input[@id='exampleCheck1']")
	WebElement rememberMe;
	
	@FindBy(xpath = "//span[text()='Forgot Password?']")
	WebElement forgotPassword;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath = "//button[text()='Next']")
	WebElement nextButton;
	
	@FindBy(xpath = "//div[text()='Reset Email Sent Successfully']")
	WebElement mailSendSuccessfully;

	@FindBy(xpath = "//span[text()='No active account found with the given credentials']")
	WebElement wrongMailID;
	
	public pom() {

		PageFactory.initElements(driver, this);
	}
	
	public void enterusername(String Username) {
		
		username.sendKeys(Username);
	}
	
	public void enterpassword(String Password) {
		
		password.sendKeys(Password);
	}
	
	public void clickLoginBtn() {
		
		loginBtn.click();
	}
	
	public String verifyPage() {
		return driver.getCurrentUrl();
		
	}
	
	public boolean verifyErrorMessage() {
		errorMessageFirstLine.isDisplayed();
		return errorMessageSecondLine.isDisplayed();
	}
	
	public void rememberMeCheckbox() {
		rememberMe.click();
	}
	public void forgotPasswordClkBtn() {
		forgotPassword.click();
	}
	
	public void enterEmail(String emailid) {
		email.sendKeys(emailid);
	}
	
	public void clickNextBtn() {
		nextButton.click();
	}
	
	public boolean verifyMailSend() {
		return mailSendSuccessfully.isDisplayed();
	}
	
	public boolean verifyWrongMailSend() {
		return wrongMailID.isDisplayed();
	}
	

}
