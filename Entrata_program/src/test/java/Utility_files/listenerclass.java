package Utility_files;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.github.dockerjava.api.model.Driver;

import Base_class.base_cls;

public class listenerclass extends base_cls implements ITestListener
{ 
	//WebDriver driver;
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String Result=result.getName();
		Reporter.log("TC "+Result+" is Failed", true);
		try {
			
			String failedssname="TC"+result.getName();
			commonmethods.takescreenshot(driver, failedssname);
		} catch (IOException e) {
			
		}
		
	}
	
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
	String Result=result.getName();
	Reporter.log("Tc "+Result+" is Passed", true);
	}
	
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String Result=result.getName();
		Reporter.log("TC "+Result+" is Skipped", true);
	}

}
