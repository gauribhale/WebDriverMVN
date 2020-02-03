package TestCases;
//do this once again
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestKeyboardEvents {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver",
		"C:\\Executables\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("identifierId")).sendKeys("gouribhale@gmail.com");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]")).click();

		new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL + "A")).perform();
		new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL + "C")).perform();
		driver.findElement(By.id("identifierId")).click();
		// new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL+"a")).perform();
		new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL + "V")).perform();
		// new Actions(driver).sendKeys(Keys.ENTER).perform();
	}

}
