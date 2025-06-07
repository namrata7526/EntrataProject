package POM_files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import Utility_files.commonmethods;

public class detailsforsignup 
{
	
	@FindBy(xpath  = "(//span[contains(text(),\"Select One\")])[1]") private WebElement selectclick;
	
	@FindBy(xpath = "(//input[@placeholder=\"Search properties...\"])[1]")private WebElement entertextinsearchprop;
	
	@FindBy(xpath = "(//div[contains(text(),\"Westland Estates Pomona\")])[1]")private WebElement selecttextfield;
	
	@FindBy(xpath = "(//button[@ng-click=\"handleContinueRegistration()\"])[1]")private WebElement continuebutton;
	
	@FindBy(xpath = "(//input[@id=\"email\"])[1]")private WebElement Email;
	
	@FindBy(xpath = "(//input[@id=\"firstName\"])[1]")private WebElement firstname;

	@FindBy(xpath = "(//input[@id=\"lastName\"])[1]")private WebElement lastname;

	@FindBy(xpath = "(//input[@id=\"birth_date\"])[1]")private WebElement birthdate;
	
	@FindBy(xpath = "(//input[@id=\"password\"])[1]")private WebElement password;

	@FindBy(xpath = "(//span[@class=\"checkbox-custom light-mode\"])[1]")private WebElement checkbox;

	@FindBy(xpath = "(//button[@type=\"submit\"])[1]")private WebElement submitbutton;
	
	@FindBy(xpath = "(//span[@class=\"error-message translate ng-binding\"])[2]")
	private WebElement errormsg;

	public detailsforsignup(WebDriver driver)
	{
	PageFactory.initElements(driver,this );
	}
	
	public void selectproperty(String selecttext, WebDriver driver)
	{
		selectclick.click();
		entertextinsearchprop.click();
		commonmethods.explicitwait(2000, entertextinsearchprop, driver);
		entertextinsearchprop.sendKeys(selecttext);
		Reporter.log("Entered Text",true);
		selecttextfield.click();
		Reporter.log("Select Text",true);
		continuebutton.click();
		Reporter.log("Clicked on continue button",true);
	}

	public void enterdetails(String email, String Firstname,String Lastname, String Birthdate, String Password)
	{
		Email.click();
		Email.sendKeys(email);
		Reporter.log("Entered Email",true);
		
		firstname.click();
		firstname.sendKeys(Firstname);
		Reporter.log("Entered Firstname",true);
		
		lastname.click();
		lastname.sendKeys(Lastname);
		Reporter.log("Entered Lastname",true);
		
		birthdate.click();
		birthdate.sendKeys(Birthdate);
		Reporter.log("Entered Birthdate",true);
		
		password.click();
		password.sendKeys(Password);
		
		checkbox.click();
		
		submitbutton.click();
	}

	public void verifyresult(String actualresult)
	{
		String ExpectedResult="To successfully enroll, call your property to verify that your information is correct in their property management software.";
		actualresult=errormsg.getText();
		
		if(actualresult.equals(ExpectedResult))
		{
			Assert.assertFalse(false, "I don't have proper details thats why unable to Sign up...");
		}
		else
		{
			Assert.assertTrue(true, "Sign up Completed...");
		}
		
	}
	

}
