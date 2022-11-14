package Testpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.HomePage;

public class VerifyHomePage {
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\JAYSHRI WASEKAR\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	   WebDriver driver=new ChromeDriver();
	   driver.get("http://www.amazon.in/");
	   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	   HomePage homePage=new HomePage(driver);
	   homePage.clickonaccountAndList();
	   homePage.moveToyourorder();
	   homePage.clickOnallmenu();
	   homePage.clickOnmobilesAndComputer();
	   homePage.clickOncross();
	   homePage.sendSearchBar();
	   homePage.clickOnSearchBarButton();
}
}