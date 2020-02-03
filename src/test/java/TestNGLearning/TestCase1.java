package TestNGLearning;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
	@BeforeMethod
	public void launchBrowser() {
		System.out.println("launching browser");
	}
	@AfterMethod
	public void closeBrowser() {
		System.out.println("closing browser");
	}
	@Test(priority=2)
	public void doLogin() {
		System.out.println("executing login test");
		Assert.fail();
	}

	@Test(priority=1)
	public void doRegi() {
		System.out.println("user registration");
	}
	@BeforeTest
	public void createDBConn() {
		System.out.println("creating db conn");
	}
	@AfterTest
	public void closeDBConn() {
		System.out.println("closing db conn");
	}
}
