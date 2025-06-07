package POM_files;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Utility_files.commonmethods;
import io.reactivex.rxjava3.functions.Action;
import junit.framework.Assert;

public class Homepage 
{
	@FindBy(xpath = "(//a[@href=\"/sign-in\"])[2]")
	private WebElement signinbutton;

	@FindBy(xpath = "//a[@href=\"https://www.residentportal.com/\"]")
	private WebElement residentloginbtn;
	
	@FindBy(xpath = "(//span[contains(text(),\"Need to sign up?\")])[1]")
	private WebElement signupbtn;
	
	@FindBy(xpath = "//a[@href=\"#w-tabs-1-data-w-pane-1\"]")
	private WebElement entrataosbtn;
	
	@FindBy(xpath = "(//a[@href=\"/demo\"])[2]")
	private WebElement watchdemobtn;
	
	@FindBy(xpath = "//*[@id=\"w-dropdown-toggle-0\"]")
	private WebElement productdropdown;
	
	@FindBy(xpath = "//a[@href=\"/products/prospectportal\"]")
	private WebElement el1;
	
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void signinbutton()
	{
		signinbutton.click();
	}
	
	public void residentloginbutton() 
	{
	      residentloginbtn.click();	
	}
	
	public void signupbtn() 
	{
	      signupbtn.click();	
	}
	
	public void entrabutton() 
	{
	    entrataosbtn.click();	
	}
	
	public void watchdemo()
	{
		watchdemobtn.click();
		Reporter.log("Clicked on watch demo", true);
	}
	
	public void clickandverifylinkonproduct(WebDriver driver)
	{
		//productdropdown.click();
		Actions act=new Actions(driver);
        //act.moveToElement(productdropdown);
		productdropdown.click();
		Reporter.log("Clicked on Product dropdown ", true);	
		commonmethods.explicitwait(2, el1, driver);
		el1.click();
		Reporter.log("Clicked on Prospect portal ", true);		
		
	    String urlon=driver.getTitle();
	    if(urlon.contains("ResidentPay"))
	      {
    		   Assert.assertTrue("Testcase Passed", true);
	      }
	      else
	      {
               Assert.assertFalse("Testcase Failed", false);
	      }
		

//		//commonmethods.implicitlwaits(5, driver);
//		//commonmethods.implicitlwaits(5, driver);
//		commonmethods.explicitwait(5, el1, driver);
//		String dynamicText = "ResidentPay";
//        String xpathTemplate = "//div[contains(text(),\"%s\")]";
//        
//        String finalXPath = String.format(xpathTemplate, dynamicText);
//        
//        System.out.println("Final XPath: " + finalXPath);
//        WebElement element=driver.findElement(By.xpath(finalXPath));
//   //commonmethods.implicitlwaits(3, driver);
//   commonmethods.explicitwait(3, element, driver);
//   element.click();
//   


	}
	
	public void Listoflinks(WebDriver driver)
	{
		//productdropdown.click();
		
		Actions act=new Actions(driver);
		
		act.moveToElement(productdropdown);
		
		 List<WebElement> links = driver.findElements(By.tagName("a"));

	        // Print all href attributes
	        for (WebElement link : links) 
	        {
	            String href = link.getAttribute("href");
	            if (href != null && !href.isEmpty())
	            {
	                System.out.println(href);
	            }		
	        }
		
		Reporter.log("Clicked on private dropdown", true);
	        
	}


}
