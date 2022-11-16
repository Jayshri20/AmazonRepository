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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.HomePage;
import Pages.ProductDisplayPage;
import setup.Base;


public class VerifyProductDetailspage extends Base {
	private WebDriver driver;
	private HomePage homePage;
	private ProductDisplayPage productDisplayPage;
	private ArrayList<String>addr;
	
	int testId;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
@Parameters("browser")
@BeforeTest
	public void launchBrowser(String browsername)
	{
	  reporter = new ExtentHtmlReporter ("test-output/ExtendReporter/Extent.html");
	  ExtentReports extend = new ExtentReports();
	  extend.attachReporter(reporter);
		if(browsername.equals("Chrome"))
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
	productDisplayPage =new ProductDisplayPage(driver);  
	   
}
@BeforeMethod
public void openAmazoneHomePage()
{
	   driver.get("http://www.amazon.in/");
	   addr=new ArrayList<String>(driver.getWindowHandles());
}
@Test(priority=1)
public void vefiySearchBarButton()
{
	 homePage.sendSearchBar();
	 homePage.clickOnSearchBarButton();
	 homePage.clickOnappleiphone();
}
@Test(priority=2)
public void verifyProductDitails() throws InterruptedException
{
	Thread.sleep(2000);
	   driver.switchTo().window(addr.get(1));
	   productDisplayPage.moveToImg1();
	   productDisplayPage.moveToImg2();
	   productDisplayPage.moveToImg3();
	   productDisplayPage.moveToImg4();
	   productDisplayPage.moveToImg5();
	   productDisplayPage.moveToImg6();
	   productDisplayPage.clickonimgcolourblue();
	   productDisplayPage.clickonimgcolourwhite();
	  
}
@Test(priority=3)
public void verifyColourOfProduct() throws InterruptedException
{
	Thread.sleep(2000);
	productDisplayPage.clickonimgcolourblue();
    productDisplayPage.clickonimgcolourwhite();
}
@AfterMethod
public void logoutApplication()
{
	System.out.println("logout");
}
@AfterClass
public void clearAll()
{
	homePage=null;
	productDisplayPage =null;
}
@AfterTest
public void closeBrowser()
{
	driver.close();
	driver=null;
	System.gc();
}
}
