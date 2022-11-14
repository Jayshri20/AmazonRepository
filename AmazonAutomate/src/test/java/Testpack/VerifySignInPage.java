package Testpack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.SignInPage;
import utils.UtilityClass;

public class VerifySignInPage {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\JAYSHRI WASEKAR\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	   WebDriver driver=new ChromeDriver();
	   driver.get("http://www.amazon.in/");
	   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	   
	   SignInPage signInPage=new SignInPage(driver);
	   signInPage.clickOnaccountAndList();
	   String emailOrMobNo=UtilityClass.getDataFormExelSheet("sheet1", 2, 1);
	   signInPage.enteremailOrMobileNo(emailOrMobNo);
	   signInPage.clickOncontinueButton();
	   String password=UtilityClass.getDataFormExelSheet("sheet1", 2, 2);
	   signInPage.enterpassword(password);
	   signInPage.clickOnsignin();
}
}
