package TestNGLearning;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase3 {
	@Test(priority=2)
	public void doLogin() {
		System.out.println("executing login test");
		Assert.fail("user not register successfully");
	
	}

	@Test(priority=1)
	public void doRegi() {
		System.out.println("user registration");
	}
	@Test(priority=3)
	public void isSkip() {
		throw new SkipException("Skipping the test as the condition is not met");
	}
}
