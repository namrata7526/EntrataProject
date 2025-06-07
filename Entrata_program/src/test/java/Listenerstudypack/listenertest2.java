package Listenerstudypack;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class listenertest2 
{
	  @Test
	  public void G() 
	  {
		  Assert.fail();
		  Reporter.log("TC G is running", true);
	  }
	  
	  @Test
	  public void H() 
	  {
		  Reporter.log("TC H is running", true);
	  }
	  
	  @Test(dependsOnMethods = "H")
	  public void I() 
	  {
		  Reporter.log("TC I is running", true);
	  }
	  
	  @Test
	  public void J() 
	  {
		  Reporter.log("TC J is running", true);
	  }
	  
	  @Test
	  public void K() 
	  {
		  Reporter.log("TC K is running", true);
	  }
	  @Test
	  public void L() 
	  {
		  Reporter.log("TC L is running", true);
	  }

}
