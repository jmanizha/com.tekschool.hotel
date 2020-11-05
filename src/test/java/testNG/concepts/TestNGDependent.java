package testNG.concepts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDependent {
	
	
	// In TestNg we can make tests dependent on each other.
	// for example if Open browser Test case is failed, sign in test case will not execute.
	// It means test case which is depended on main test case will only execute if main test case is pass.
	
	
	@Test (groups = {"test"})
	public void test_OpenBrowser() {
		
		Assert.assertTrue(true);
		
		System.out.println("This is OpenBrowser Test");
		
	}
	
	@Test(dependsOnMethods = {"test_OpenBrowser" })
	public void test_NavigateToURL() {
		
	
		System.out.println("This method will be executed if OpenBrowser Test is passed");
		Assert.assertTrue(true);
		
	}
	
	@Test (dependsOnMethods = {"test_NavigateToURL"} , dependsOnGroups = {"test"})
	public void test_SignINtoApplication() {
		System.out.println("Thhis method will be executed if the two other test case or methos are execute succesfully");
	}
	
	
	

}
