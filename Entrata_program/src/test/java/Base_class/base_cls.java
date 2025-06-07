package Base_class;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import com.github.dockerjava.api.model.Driver;

import Utility_files.commonmethods;

public class base_cls 
{
	protected static WebDriver driver;
	
	public void launchingbrowser() throws EncryptedDocumentException, IOException
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();	
		//String Url=commonmethods.readdataformexcel(2, 0);
		
		driver.get(commonmethods.readdataformexcel(1,0));
		//driver.get(Url);	
		Reporter.log("Launched Browser", true);
		commonmethods.implicitlwaits(2000, driver);	
	}

}
