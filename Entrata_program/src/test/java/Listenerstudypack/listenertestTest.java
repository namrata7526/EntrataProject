package Listenerstudypack;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class listenertestTest {
  @Test
  public void A() 
  {
	  Assert.fail();
	  Reporter.log("TC A is running", true);
  }
  
  @Test
  public void B() 
  {
	  Reporter.log("TC B is running", true);
  }
  
  @Test(dependsOnMethods = "A")
  public void C() 
  {
	  Reporter.log("TC C is running", true);
  }
  
  @Test
  public void D() 
  {
	  Reporter.log("TC D is running", true);
  }
  
  @Test
  public void E() 
  {
	  Reporter.log("TC E is running", true);
  }
  @Test
  public void F() 
  {
	  Reporter.log("TC F is running", true);
  }
}
