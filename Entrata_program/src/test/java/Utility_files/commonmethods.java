package Utility_files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.google.common.io.Files;

import Test_classes.test1;

public class commonmethods 
{
    public static String readdataformexcel(int row, int cell) throws EncryptedDocumentException, IOException
	{
		File myfile=new File("C:\\Entrata\\Entrata.xlsx");
	    Sheet sheet=WorkbookFactory.create(myfile).getSheetAt(0);
		String value=sheet.getRow(row).getCell(cell).getStringCellValue();	
		Reporter.log("Reading data from row = "+row+" cell = "+cell+" ", true);
		return value;
	}
   
	public static void implicitlwaits(int time, WebDriver driver)
	{
	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
			Reporter.log("Waiting time = "+time+" ", true);
		
	}
	
	public static void explicitwait(int time,WebElement element, WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));		
	}
	
	public static void takescreenshot(WebDriver driver,String filename) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest=new File("C:\\ss\\"+filename+".png");
		Files.copy(src, dest);
		Reporter.log("Screenshot Captured as "+filename+" ", true);
	}
	
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)", element);
	Reporter.log("scrolling into view to "+element.getText(), true);
	}
	
	public static String readdatafrompropertyfile(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\v-nagaikwad\\eclipse-workspace\\framework_from_scratch\\MyProprty.properties");
		prop.load(fis);
		
		String value=prop.getProperty(key);
		Reporter.log("Read properties from property file");
	
		return value;
		
	}
	
}
