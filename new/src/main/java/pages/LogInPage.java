package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LogInPage {
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(name = "pwd")
	private WebElement password;
	
	@FindBy(id ="keepLoggedInCheckBox")
	private WebElement keepLoggedInCheckBox;
	
	@FindBy(xpath = "//div[.='Login ']")
	private WebElement login;
	
	@FindBy(xpath ="//span[contains(text(),'Please try again.')]")
	private WebElement errormsg;
	
	public LogInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void login() {
		username.sendKeys("admin");
		password.sendKeys("manager");
		keepLoggedInCheckBox.click();
		login.click();
	}
	
	public void login(String un , String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		keepLoggedInCheckBox.click();
		login.click();
	}
	
	public void setusername(String un) {
		username.sendKeys(un);
	}
	
	public void setpassword(String pw) {
		password.sendKeys(pw);
	}
	
	public void clickonkeepmeloggedin() {
		keepLoggedInCheckBox.click();
	}
	public void clickonlogin() {
		login.click();
	}
	
	public void verifyerrormsg(WebDriver driver ) {
		Assert.assertTrue(errormsg.isDisplayed());
		Reporter.log("error message is dispalyed" + errormsg.getText(),true);
	}
	
	
}
