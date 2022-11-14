package Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.UtilityClass;

public class SignInPage {
@FindBy(xpath="(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]")
private WebElement accountAndList;
@FindBy(xpath="//input[@id='ap_email']")
private WebElement emailOrMobileNo;
@FindBy(xpath="//input[@id='continue']")
private WebElement continueButton;
@FindBy(xpath="//input[@id='ap_password']")
private WebElement password;
@FindBy(xpath="//input[@id='signInSubmit']")
private WebElement signin;

public SignInPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}

public void clickOnaccountAndList()
{
	accountAndList.click();
}
public void enteremailOrMobileNo(String mobno) 
{
	
	emailOrMobileNo.sendKeys(mobno);
}
public void clickOncontinueButton()
{
	continueButton.click();
}
public void enterpassword(String pass) 
{
	
	password.sendKeys(pass);
}
public void clickOnsignin()
{
	signin.click();
}
}
