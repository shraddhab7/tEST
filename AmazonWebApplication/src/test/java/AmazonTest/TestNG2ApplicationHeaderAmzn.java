package AmazonTest;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utils.Utility;
import base.Browsers;
import pom.ApplicationHeaderAmzn;
import pom.LoginPageAmzn;

public class TestNG2ApplicationHeaderAmzn extends Browsers{

	
	private WebDriver driver;
	private ApplicationHeaderAmzn applicationHeaderAmzn;
	private LoginPageAmzn loginPageAmzn;
	private SoftAssert softAssert;
	private int testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser)
	{
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = launchChromeBrowser();
		}
		if(browser.equalsIgnoreCase("opera"))
		{
			driver = launchOperaBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
		

	@BeforeClass
	public void createPOMObjects()
	{
		System.out.println("beforeClass");
		
		ApplicationHeaderAmzn applicationHeaderAmzn = new ApplicationHeaderAmzn(driver);
		LoginPageAmzn loginPageAmzn = new LoginPageAmzn(driver);
		SoftAssert softAssert = new SoftAssert();
		
	}
	
	@BeforeMethod
	public void launchLoginPage() throws IOException, Exception
	{
		System.out.println("Before Method");
		driver.get(" https://www.amazon.in/ ");
		
		ApplicationHeaderAmzn applicationHeaderAmzn = new ApplicationHeaderAmzn(driver);
		LoginPageAmzn loginPageAmzn = new LoginPageAmzn(driver);
		applicationHeaderAmzn.openAllPopp();
		applicationHeaderAmzn.clickSignIn();
		Thread.sleep(1000);
		String userName2= Utility.getDataFromExcelSheet("Sheet2",1,0);
		
		loginPageAmzn.sendUserName(userName2);
		loginPageAmzn.clickOnContinue();
		
		String password2 = Utility.getDataFromExcelSheet("Sheet2",1,0);
		loginPageAmzn.sendPassword(password2);
		loginPageAmzn.clickOnSignInButton();
		
	}

	@Test
	public void toVerifyAmazonPayButton()
	{
		testID=101;
		ApplicationHeaderAmzn applicationHeaderAmzn = new ApplicationHeaderAmzn(driver);
		
		applicationHeaderAmzn.openAmazonPayPage();
		String url = driver.getCurrentUrl();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(url, "https://www.amazon.in/gp/sva/dashboard?ref_=nav_cs_apay", "AmazonPay URL is Incorrect");
		
		softAssert.assertAll();
		
		System.out.println("Test1");
	}
	
	@Test
	public void toVerifyGrocerynGourmetFoods()
	{
		testID=102;
		ApplicationHeaderAmzn applicationHeaderAmzn = new ApplicationHeaderAmzn(driver);
		applicationHeaderAmzn.openGrocerynGourmetFoodsPage();
		String url = driver.getCurrentUrl();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(url, "https://www.amazon.in/Gourmet-Specialty-Foods/b/?ie=UTF8&node=2454178031&ref_=nav_cs_grocery","GrocerynGourmetFoods URL is Incorrect");
		
		softAssert.assertAll();
		
		System.out.println("Test2");
		
	}
	
	@Test
	public void toVerifyBuyAgainButton()
	{
		testID=103;
		ApplicationHeaderAmzn applicationHeaderAmzn = new ApplicationHeaderAmzn(driver);
		applicationHeaderAmzn.openBuyAgainPage();
		String url = driver.getCurrentUrl();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(url, "https://www.amazon.in/gp/buyagain?ie=UTF8&ref_=nav_cs_buy_again","BuyAgain URL is Incorrect");
		
		softAssert.assertAll();
		
		System.out.println("Test3");
				
	}
	
	@Test
	public void toVerifyGiftCardButton()
	{
		testID=104;
		ApplicationHeaderAmzn applicationHeaderAmzn = new ApplicationHeaderAmzn(driver);
		applicationHeaderAmzn.openGiftCardPage();
		String url = driver.getCurrentUrl();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(url, "https://www.amazon.in/gift-card-store/b/?ie=UTF8&node=3704982031&ref_=nav_cs_gc","GiftCard URL is Incorrect");
		
		softAssert.assertAll();
		
		System.out.println("Test4");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.getScreenShot(driver,testID);
		}
		ApplicationHeaderAmzn applicationHeaderAmzn = new ApplicationHeaderAmzn(driver);
		applicationHeaderAmzn.openAllPopp();
		applicationHeaderAmzn.clickOnSignOut();
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class");
		applicationHeaderAmzn=null;
		loginPageAmzn=null;
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Class");
		driver.quit();
		driver=null;
		System.gc();
	}
}
