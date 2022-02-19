package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Browsers {

	
	
	public static WebDriver launchChromeBrowser()
	{
		
			System.setProperty("webdriver.chrome.driver", "D:\\SHraddha\\ChromeDriver98-80\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			return driver;
	}
	
	public static WebDriver launchOperaBrowser()
	{
		
			System.setProperty("webdriver.opera.driver", "D:\\SHraddha\\Operadriver\\operadriver_win64\\operadriver.exe");
			WebDriver driver = new OperaDriver();
			return driver;
	}
}
