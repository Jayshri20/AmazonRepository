package Testpack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.HomePage;
import Pages.ProductDisplayPage;

public class VerifyBuyNowButton {
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\JAYSHRI WASEKAR\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	   WebDriver driver=new ChromeDriver();
	   driver.get("http://www.amazon.in/");
	   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	   
	   HomePage homePage=new HomePage(driver);
	   homePage.sendSearchBar();
	   homePage.clickOnSearchBarButton();
	   homePage.clickOnappleiphone();
	   
	   ArrayList<String>addr=new ArrayList<String>(driver.getWindowHandles());
	   driver.switchTo().window(addr.get(1));
	   
	   ProductDisplayPage productDisplayPage =new ProductDisplayPage(driver);
	   productDisplayPage.clickonBuyNowButton();
}
}