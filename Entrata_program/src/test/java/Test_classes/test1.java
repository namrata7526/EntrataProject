package Test_classes;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base_class.base_cls;
import POM_files.Homepage;
import POM_files.demopage;
import POM_files.detailsforsignup;
import Utility_files.commonmethods;

@Listeners(Utility_files.listenerclass.class)
public class test1 extends base_cls
{
	Homepage home;
	detailsforsignup signup;
    demopage demo;
	String s="TC001";
	
	@BeforeMethod
	public void launchbrowser() throws EncryptedDocumentException, IOException
	{
		launchingbrowser();
	
		home=new Homepage(driver);
		signup=new detailsforsignup(driver);
		demo=new demopage(driver);

		
	}
	
	@Test(priority = 1)
	public void verifyingsignupbutton() throws EncryptedDocumentException, IOException, InterruptedException
	{
		commonmethods.implicitlwaits(1000, driver);
		home.signinbutton();
		commonmethods.implicitlwaits(1000, driver);
		home.residentloginbutton();
		commonmethods.implicitlwaits(1000, driver);
		home.signupbtn();		
		//for signing up select properties
		signup.selectproperty(commonmethods.readdataformexcel(2, 0), driver);
		commonmethods.implicitlwaits(2000, driver);

		//for entertext
		signup.enterdetails(commonmethods.readdataformexcel(3, 0), commonmethods.readdataformexcel(4, 0), commonmethods.readdataformexcel(5, 0), commonmethods.readdataformexcel(6, 0), commonmethods.readdataformexcel(7, 0));	    
	}
	
	@Test(priority = 2)
	public void verifyingwatchdemodetails() throws EncryptedDocumentException, IOException
	{
		commonmethods.implicitlwaits(1000, driver);
	    //home.entrabutton();
	    home.watchdemo();
	    
	    //for entering data
	    demo.verifydemoelements(commonmethods.readdataformexcel(1, 1), commonmethods.readdataformexcel(2, 1), commonmethods.readdataformexcel(3, 1), commonmethods.readdataformexcel(4, 1), commonmethods.readdataformexcel(5, 1), commonmethods.readdataformexcel(6, 1), commonmethods.readdataformexcel(7, 1), commonmethods.readdataformexcel(8, 1));    
	}
	
	@Test(priority = 3)
	public void verifylistofLinkstopresent() 
	{
		home.Listoflinks(driver);
		
	}
	
	@Test(priority = 4)
	public void clickandverifyelement() throws EncryptedDocumentException, IOException 
	{
		home.clickandverifylinkonproduct(driver);
		//home.clickandverifyElement(driver, commonmethods.readdataformexcel(1, 2));
		
	}
	
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
		Reporter.log("Closing browser", true);
	}

}
