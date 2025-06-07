package POM_files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class demopage 
{
	@FindBy(xpath = "//input[@id=\"FirstName\"]")
	private WebElement fname;
	
	@FindBy(xpath = "//input[@id=\"LastName\"]")
	private WebElement lname;
	
	@FindBy(xpath = "//input[@id=\"Email\"]")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id=\"Company\"]")
	private WebElement company;
	
	@FindBy(xpath = "//input[@id=\"Phone\"]")
	private WebElement phone;
	
	@FindBy(xpath = "//input[@id=\"Title\"]")
	private WebElement title;
	
	@FindBy(xpath = "//select[@id=\"Unit_Count__c\"]")
	private WebElement units;
	
	@FindBy(xpath = "//select[@id=\"demoRequest\"]")
	private WebElement request;
	
	@FindBy(xpath = "//button[contains(text(),\"Watch Demo\")]")
	private WebElement demobtn;
	
	public demopage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
public void verifydemoelements(String Fname,String Lname, String Mail, String Companyname, String mobileno, String Units, String Title, String Res)
{
	fname.click();
	fname.sendKeys(Fname);
	Reporter.log("Entered "+Fname,true);
	
	
	lname.click();
	lname.sendKeys(Lname);
	Reporter.log("Entered "+Lname,true);
	
	email.click();
	email.sendKeys(Mail);
	Reporter.log("Entered "+Mail,true);
	
	company.click();
	company.sendKeys(Companyname);
	Reporter.log("Entered "+Companyname,true);
	
	phone.click();
	phone.sendKeys(mobileno);
	Reporter.log("Entered "+mobileno,true);
	
	//units.click();
	Select sel= new Select(units);
	sel.selectByValue(Units);
	Reporter.log("Entered "+Units,true);
	
	title.click();
	title.sendKeys(Title);
	Reporter.log("Entered "+Title,true);
	
	Select sel1=new Select(request);
	sel1.selectByValue(Res);
	Reporter.log("Entered "+Res,true);
	
	if(demobtn.isDisplayed())
	{
		Assert.assertTrue(true, "If demobutton is displayed then its passed");
	}
	else
	{
		Assert.assertFalse(false, "Failed");
	}
}
}
