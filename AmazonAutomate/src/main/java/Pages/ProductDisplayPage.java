package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDisplayPage {
	private WebDriver driver;
	private Actions act;
//@FindBy(xpath="//input[@id='twotabsearchtextbox']")
//private WebElement searchBar;
//@FindBy(xpath="//input[@id='nav-search-submit-button']")
//private WebElement searchButton;
//@FindBy(xpath="//span[text()='Apple iPhone 12 (128GB) - Blue']")
//private WebElement iphone12;
	
@FindBy(xpath="(//input[@class='a-button-input'])[15]")
private WebElement image1;
@FindBy(xpath="(//input[@class='a-button-input'])[16]")
private WebElement image2;
@FindBy(xpath="(//input[@class='a-button-input'])[17]")
private WebElement image3;
@FindBy(xpath="(//input[@class='a-button-input'])[18]")
private WebElement image4;
@FindBy(xpath="(//input[@class='a-button-input'])[19]")
private WebElement image5;
@FindBy(xpath="(//input[@class='a-button-input'])[20]")
private WebElement image6;

@FindBy(xpath="(//img[@class='imgSwatch'])[3]")
private WebElement imgcolourblue;
@FindBy(xpath="(//img[@class='imgSwatch'])[6]")
private WebElement imgcolourwhite;

@FindBy(xpath="//p[text()='128GB']")
private WebElement sizeinGB;

@FindBy(xpath="//i[@class='a-icon a-accordion-radio a-icon-radio-inactive']")
private WebElement withExchange;
@FindBy(xpath="(//div[@class='a-row'])[4]")
private WebElement withoutExchange;

@FindBy(xpath="//input[@id='add-to-cart-button']")
private WebElement addToCart;


@FindBy(xpath="//input[@id='buy-now-button']")
private WebElement buyNowButton;

public ProductDisplayPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	act=new Actions (driver);
	
}

public void moveToImg1()
{
	act.moveToElement(image1).build().perform();
}
public void moveToImg2() {
	act.moveToElement(image2);
}
public void moveToImg3()
{
	act.moveToElement(image3);
}
public void moveToImg4()
{
	act.moveToElement(image4);
}
public void moveToImg5()
{
	act.moveToElement(image5);
}
public void moveToImg6()
{
	act.moveToElement(image6);
}

public void clickonimgcolourblue()
{
	imgcolourblue.click();
}
public void clickonimgcolourwhite()
{
	imgcolourwhite.click();
}

public void clickonwithExchange()
{
	withExchange.click();
}
public void clickonwithoutExchange()
{
	withoutExchange.click();
}

public void clickonaddToCart()
{
	addToCart.click();
}
public void clickonBuyNowButton()
{
	buyNowButton.click();
}
}
