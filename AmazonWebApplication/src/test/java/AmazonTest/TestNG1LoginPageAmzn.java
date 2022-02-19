package AmazonTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pom.LoginPageAmzn;

public class TestNG1LoginPageAmzn {

	WebDriver driver;
	LoginPageAmzn loginPageAmzn;
	SoftAssert softAssert;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeClass
	public void launchBrowser()
	{
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		System.out.println("beforeclass");
		System.setProperty("webdriver.chrome.driver", "D:\\SHraddha\\ChromeDriver98-80\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@BeforeMethod 
	public void launchLoginPage()
	{
		System.out.println("beforemethod");
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		LoginPageAmzn loginPageAmzn= new LoginPageAmzn(driver);
		
	}
	
	@Test 
	public void toVerifyLoginPage()
	{
		LoginPageAmzn loginPageAmzn = new LoginPageAmzn(driver);
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(title, "Amazon Sign In","login page title is Incorrect");
		softAssert.assertAll();
		
		System.out.println("Login Test");
	}
	
	@AfterMethod 
	public void afterMethod()
	{
		System.out.println("aftermethod");
	}
	
	@AfterClass 
	public void afterClass()
	{
		System.out.println("afterclass");
		driver.quit();
	}
}
