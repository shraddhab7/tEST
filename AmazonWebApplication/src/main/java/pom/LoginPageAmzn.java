package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageAmzn {
	
	WebDriver driver;
	
	@FindBy (xpath = " //input[@type='email'] ") 
	private WebElement userName ;
	
	@FindBy (xpath = " //input[@id=\"continue\"] ") 
	private WebElement continueButton ;
	
	@FindBy (xpath = " //input[@id='ap_password'] ") 
	private WebElement password ;
	
	@FindBy (xpath = " //input[@id='signInSubmit'] ") 
	private WebElement signInButton ;
	
	

	public LoginPageAmzn(WebDriver driver123)
	{
		PageFactory.initElements(driver123, this);
	}
	

	
	public void sendUserName(String userName2)
	{
		userName.sendKeys(userName2);
	}
	
	public void clickOnContinue()
	{
		continueButton.click();
	}
	
	public void sendPassword(String password2)
	{
		password.sendKeys(password2);
	}
	
	public void clickOnSignInButton()
	{
		signInButton.click();
	}






	
	

	
}
