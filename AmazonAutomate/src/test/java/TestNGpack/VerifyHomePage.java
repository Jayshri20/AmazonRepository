package TestNGpack;

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
import setup.Base;

public class VerifyHomePage extends Base {
	private WebDriver driver;
	private HomePage homePage;
	
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
	 
	 
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
	 }

	@BeforeClass
	public void createPOMObjects()
	{
		homePage=new HomePage(driver);
	}
	 @BeforeMethod
	 public void openAmazonHomePage()
	 {
		System.out.println("before method"); 
		driver.get("http://www.amazon.in/");
	   
	 }
	 
	 @Test(priority=1)
	 public void verifyhomepage()
	 {
		
		   homePage.clickonaccountAndList();
		   homePage.moveToyourorder();
		   homePage.clickOnallmenu();
		   homePage.clickOnmobilesAndComputer();
		   homePage.clickOncross();
		   
	 }
	 
	 @Test (priority=2)
	 public void verifySearchBar()
	 {
		 homePage.sendSearchBar();
		 homePage.clickOnSearchBarButton();
	 }
	 @AfterMethod
	 public void logoutFromApplication()
	 {
		System.out.println("logout");
	 }
	 @AfterClass
	 public void clearAll()
	 {
		 homePage=null;
	 }
	 
	 @AfterTest
	 public void closeBrowser()
	 {
		 driver.close();
		 driver=null;
		 // to remove or delete all object without reference
		 System.gc(); //garbage collector
	 }
	 
}

