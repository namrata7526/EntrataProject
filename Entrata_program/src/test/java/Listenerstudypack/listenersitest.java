package Listenerstudypack;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class listenersitest implements ITestListener
{
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String Result=result.getName();
		Reporter.log("TC "+Result+" is Failed", true);
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
