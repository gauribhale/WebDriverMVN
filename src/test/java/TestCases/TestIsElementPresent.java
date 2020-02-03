package TestCases;

//to find if element is present on a webpage
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestIsElementPresent {

	public static WebDriver driver;

	public static boolean isElementPresent(String xpath) {
		/*
		 * try { driver.findElement(By.xpath(xpath)); return true; } catch (Throwable t)
		 * { return false; }
		 */

		int size = driver.findElements(By.xpath(xpath)).size();
		System.out.println(size);
		if (size == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isElementPresentBy(By by) {
		int size = driver.findElements(by).size();
		System.out.println("count: " + size);

		try {
			driver.findElement(by);
			return true;
		} catch (Throwable t) {
			return false;
		}

	}

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.gmail.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// System.out.println(driver.findElement(By.xpath("//input[@id='identifierId']")).isDisplayed());
		System.out.println(isElementPresent("//*[@id='identifierd']"));

		System.out.println(isElementPresentBy(By.tagName("input")));

	}

}
