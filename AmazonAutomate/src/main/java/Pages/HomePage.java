package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	private WebDriver driver;
	private Actions act;
	
//	private JavascriptExecutor js;
	
	@FindBy(xpath="//span[@class='nav-line-2 ']")
	 private WebElement accountAndList;
	@FindBy(xpath="//span[text()='Your Orders']")
	private WebElement yourorder;
	@FindBy(xpath="//a[@id='nav-hamburger-menu']")
	private WebElement allmenu;
	@FindBy(xpath="(//a[@class='hmenu-item'])[10]")
	private WebElement mobilesAndComputer;
	@FindBy(xpath="//div[@class='nav-sprite hmenu-close-icon']")
	private WebElement cross;
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchbar;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement searchBarutton;
	@FindBy(xpath="(//span[text()='Apple iPhone 12 (64GB) - Blue'])[1]")
	private WebElement appleiphone;
	@FindBy(xpath="//select[@id='searchDropdownBox']")
	private WebElement searchByCatagory;
//	@FindBy(xpath="//select[@id='searchDropdownBox']//option[4]")
//	private WebElement amazonFashion;
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	private WebElement searchBarButton;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		act=new Actions(driver);
		this.driver=driver;

	}
	
	public void clickonaccountAndList()
	{
		act.moveToElement(accountAndList).build().perform();
		
	}
	public void moveToyourorder()
	{
		act.moveToElement(yourorder).build().perform();
		
	}
	public void clickOnallmenu()
	{
		allmenu.click();
	}
	public void clickOnmobilesAndComputer()
	{
		mobilesAndComputer.click();
	}
	public void clickOncross()
	{
		cross.click();
	}
	public void sendSearchBar()
	{
		searchbar.sendKeys("iphone");
	}
	public void clickOnSearchBarButton()
	{
		searchBarutton.click();
	}
	public void clickOnappleiphone()
	{
		appleiphone.click();
	}
	
	public void clickOnsearchByCatagory()
	{
		searchByCatagory.click();
	}
	public void selectamazonFashion()
	{
		Select s=new Select (searchByCatagory);
		s.selectByVisibleText("Amazon Fashion");
	}
    public void clickonsearchBarButton()
    {
    	searchBarButton.click();
    }
	
}
