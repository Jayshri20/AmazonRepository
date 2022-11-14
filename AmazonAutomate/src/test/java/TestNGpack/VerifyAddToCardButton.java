package TestNGpack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductDisplayPage;
import setup.Base;

public class VerifyAddToCardButton extends Base{
	private WebDriver driver;
	private HomePage homePage;
	private ProductDisplayPage productDisplayPage;
	private ArrayList<String> addr;
@Parameters("browser")	
@BeforeTest
public void launchBrowser(String browsername)
{
	if (browsername.equals("Chrome"))
    {
	  driver=openChromeBrowser();
    }
	if(browsername.equals("Edge"))
	{
	  driver=openEdgeBrowser();
	}
	
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
}

@BeforeClass
public void createPOMObjects()
{
	homePage=new HomePage(driver);
	productDisplayPage=new ProductDisplayPage(driver);
    
}

@BeforeMethod
public void openAmazonHomePage()
{
	
	driver.get("http://www.amazon.in/");
    addr= new ArrayList<String>(driver.getWindowHandles());
}

@Test(priority=1)
public void verifySearchBar()
{
	
	homePage.sendSearchBar();
	homePage.clickOnSearchBarButton();
	homePage.clickOnappleiphone();
}

@Test(priority=2)
public void verifyAddToCardButton() throws InterruptedException
{
	Thread.sleep(2000);
    
	driver.switchTo().window(addr.get(1));
	productDisplayPage.clickonaddToCart();
}

@Test (priority=3)
//public void verifyBuyNowButton() throws InterruptedException
//{
//	Thread.sleep(2000);
//	driver.switchTo().window(addr.get(1));
//	productDisplayPage.clickonBuyNowButton();
//}
@AfterMethod
public void logOutFromApplication()
{
	System.out.println("logout");
	
}
@AfterClass
public void clearAll()
{
	homePage=null;
	productDisplayPage=null;
}

@AfterTest
public void closeTheBrowser()
{
	driver.close();
	driver=null;
	System.gc();
}
}
