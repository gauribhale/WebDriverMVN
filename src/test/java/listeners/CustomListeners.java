package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener {

	public void onTestFailure(ITestResult arg0) {
		Reporter.log("screenshot link");
	}
}
