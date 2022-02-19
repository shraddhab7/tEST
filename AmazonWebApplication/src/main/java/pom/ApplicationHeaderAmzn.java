package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationHeaderAmzn {

	@FindBy (xpath = " //a[@id='nav-hamburger-menu'] ") 
	private WebElement all ;
	
	@FindBy (xpath = " //a[text()='Sign In'] ") 
	private WebElement signIn ;
	
	@FindBy (xpath = " //a[text()='Sign Out'] ") 
	private WebElement signOut ;
	
	@FindBy (xpath = " //a[text()='Gift Cards'] ") 
	private WebElement giftCard ;
	
	@FindBy (xpath = " //a[text()='Amazon Pay'] ") 
	private WebElement amazonPay ;
	
	@FindBy (xpath = " //a[text()='Buy Again'] ") 
	private WebElement buyAgain ;
	
	@FindBy (xpath = " //a[text()='Baby'] ") 
	private WebElement baby ;
	
	@FindBy (xpath = " (//a[text()='Kindle eBooks'])[1] ") 
	private WebElement kindleEBooks ;
	
    @FindBy (xpath = "  ") 
	private WebElement browsingHistory ;
	
	@FindBy (xpath = " //a[text()='AmazonBasics'] ") 
	private WebElement amazonBasics ;
	
	@FindBy (xpath = " //a[text()='Grocery & Gourmet Foods'] ") 
	private WebElement grocerynGourmetFoods ;
		
	@FindBy (xpath = "  ") 
	private WebElement accountnList ;
	
	@FindBy (xpath = "  ") 
	private WebElement returnnOrders ;
	
	@FindBy (xpath = "  ") 
	private WebElement cart ;
	
	public ApplicationHeaderAmzn(WebDriver driver123)
	{
		PageFactory.initElements(driver123,this);
	}
	

	public void openAllPopp()
	{
		all.click();
	}
	
	public void clickSignIn()
	{
		signIn.click();
	}
		
	public void openGiftCardPage()
	{
		giftCard.click();
	}
	
	public void openAmazonPayPage()
	{
		amazonPay.click();
	}
	
	public void openBuyAgainPage()
	{
		buyAgain.click();
	}
	
	public void openBabyPage()
	{
		baby.click();
	}
	
	public void openKindleEBooksPage()
	{
		kindleEBooks.click();
	}
	
	public void openBrowsingHistoryPage()
	{
		browsingHistory.click();
	}
	
	public void openAmazonBasicsPage()
	{
		amazonBasics.click();
	}
	
	public void openGrocerynGourmetFoodsPage()
	{
		grocerynGourmetFoods.click();
	}
	
	
	public void openAccountnListPopp()
	{
		accountnList.click();
	}
	
	public void openReturnnOrdersPage()
	{
		returnnOrders.click();
	}
	
	public void openCartPage()
	{
		cart.click();
	}


	public void clickOnSignOut() {
		
		signOut.click();
	}


	
	
}


