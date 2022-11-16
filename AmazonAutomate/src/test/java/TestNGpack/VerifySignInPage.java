package TestNGpack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

import Pages.SignInPage;
import setup.Base;
import utils.UtilityClass;

public class VerifySignInPage extends Base{
	 private WebDriver driver;
	 private SignInPage signInPage;
	 int testId;
	 static ExtentTest test;
	static ExtentHtmlReporter reporter;
@Parameters("browser")
@BeforeTest
public void launchTheBrowser(String browsername)
{
	reporter=new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
	ExtentReports extend = new ExtentReports();
	extend.attachReporter(reporter);
	if(browsername.equals("chrome"))
	{
		driver=openChromeBrowser();
	}
	if(browsername.equals("Edge"))
	{
		driver=openEdgeBrowser();
	}
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
@BeforeClass
public void createPOMObjects()
{
	  
	    signInPage=new SignInPage(driver);
}
@BeforeMethod
public void openSignInPage()
{
	driver.get("http://www.amazon.in/");
}
@Test
public void test() throws EncryptedDocumentException, IOException
{
	   signInPage.clickOnaccountAndList();
	   String data=UtilityClass.getDataFormExelSheet("sheet1", 2, 1);
	   signInPage.enteremailOrMobileNo(data);
	   signInPage.clickOncontinueButton();
	    data=UtilityClass.getDataFormExelSheet("sheet1", 2, 2);
	   signInPage.enterpassword(data);
	   signInPage.clickOnsignin();
}
@AfterMethod
public void logOutFromApplication()
{
	System.out.println("logOut");
}
@AfterClass()
public void closeTheBrowser()
{
	 signInPage=null;
}
@AfterTest()
public void closeBrowser()
{
	driver.close();
	driver=null;
	System.gc();
}
}
