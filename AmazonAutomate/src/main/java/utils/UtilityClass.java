package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass {

	public static void captureScreenshot(WebDriver driver,int TestId) throws IOException {
		
	File capturescreen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	Date dateRef=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("DD-MM-YYYY hh mm ss");
	sdf.format(dateRef);
	File drc=new File("test-output//testScreenshots//Test-"+TestId+sdf.format(dateRef)+".png");
	FileHandler.copy(capturescreen, drc);
	}
	public static String getDataFormExelSheet(String s, int r,int c) throws EncryptedDocumentException, IOException {
		File file=new File ("src//test//resource//browsers//testData//Book1.xlsx");
		Cell expectedCell=WorkbookFactory.create(file).getSheet(s).getRow(r).getCell(c);
		String cellValue="";
		
		try {
			cellValue=expectedCell.getStringCellValue();
		}
		catch (IllegalStateException ise) {
			double numCellValue=expectedCell.getNumericCellValue();
			cellValue=Double.toString(numCellValue);
		}
		catch(NullPointerException npe) {
			npe.printStackTrace();
			npe.getMessage();
		}
		return cellValue;
	}
}