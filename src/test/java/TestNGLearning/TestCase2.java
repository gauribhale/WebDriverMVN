package TestNGLearning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 {
	@Test
	public void validateTitle() {
		String actual_title="Yahoo.com";
		String exp_title="Gmail.com";
		
		/*
		 * if(actual_title.equals(exp_title)) { System.out.println("pass"); }else {
		 * System.out.println("fail"); }
		 */
	
	Assert.assertEquals(actual_title, exp_title);
	
	
	
	
	}

}
