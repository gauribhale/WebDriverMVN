package TestCases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestTryIt {
	public static WebDriver driver;
	
	public static void screenshot() throws IOException {
		Date d = new Date();
		String FileName=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir")+"//screenshot//"+FileName));
	
	}

	public static void main(String[] args) throws IOException {
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Set<String> winids= driver.getWindowHandles();
		Iterator<String> iterator=winids.iterator();
		String first_window = iterator.next();
		
		driver.switchTo().window(first_window);
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());

		for (WebElement frame : frames) {
			System.out.println(frame.getAttribute("id"));
		}
		

		driver.switchTo().frame("iframeResult");
		((JavascriptExecutor)driver).executeScript("myFunction()");
		//driver.findElement(By.xpath("/html[1]/body[1]/button[1]")).click();

		driver.switchTo().defaultContent();
		System.out.println("switched back to first window");
	
		screenshot();
		
	}

}
