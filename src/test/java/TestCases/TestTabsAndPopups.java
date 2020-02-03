package TestCases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestTabsAndPopups {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait =new WebDriverWait(driver, 10);
		driver.get("https://www.hdfcbank.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("---generating window id from first window---");
		Set<String> winids = driver.getWindowHandles();

		Iterator<String> iterator = winids.iterator();
		System.out.println(iterator.next());

		// System.out.println(iterator.next());

		// driver.findElement(By.xpath("//*[@id='popupBoxClose']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary login-btn ng-scope']")).click();

		driver.findElement(By.xpath("//a[@class='btn-primary login-url']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[3]/div/div/div[4]/div/a")));
		driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div[4]/div/a")).click();

		driver.findElement(By.xpath("//div[@id='tab1']//div[@class='col1']//a[1]")).click();

		/*
		 * String second_window=iterator.next(); System.out.println(second_window);
		 * driver.switchTo().window(second_window);
		 */
		System.out.println(driver.getTitle()
				.contains("NetBanking, Internet Banking, Online Banking, E-banking India - HDFC Bank"));

		//driver.quit();

		// winids = driver.getWindowHandles();
		// System.out.println(iterator.next()); // first
		// String second_window=iterator.next(); //second
		// System.out.println(second_window);
		// driver.switchTo().window(second_window);
	}

}
