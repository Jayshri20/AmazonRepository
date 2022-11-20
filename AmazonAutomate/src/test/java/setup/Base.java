package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {
 public static WebDriver openChromeBrowser()
 {
	 System.setProperty("webdriver.chrome.driver","src//test//resources//browsers//chromeBrowser");
	 WebDriver driver=new ChromeDriver();
	 return driver;
 }
 public static WebDriver openEdgeBrowser()
 {
	 System.setProperty("webdriver.edge.driver","src//test//resources//browsers//edgeBrowser");
	  WebDriver driver=new EdgeDriver();
	  return driver;
 
}

}
 