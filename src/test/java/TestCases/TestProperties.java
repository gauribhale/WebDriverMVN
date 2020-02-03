package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestProperties {

	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;

	public static Logger log = Logger.getLogger(TestLogs.class);

	public static void click(String key) {

		try {
			if (key.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(key))).click();
			} else if (key.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(key))).click();
			}

			else if (key.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(key))).click();
			}

			log.info("clicked on element: " + key);
		} 
		
		catch (Throwable t) {
			System.out.println(t.getMessage());
			log.info("error while clicking on: " + key);

			log.info("error message:", t);
		}

	}

	public static void type(String key, String value) {

		try {
			if (key.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
			} else if (key.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
			}

			else if (key.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(key))).sendKeys(value);
			}

			log.info("typed in an element: " + key + " -->value: " + value);
		} 
		
		catch (Throwable t) {
			System.out.println(t.getMessage());
			log.info("error while typing in: " + key);
			// log.info("error message:", t);
			log.error("error: ", t);
		}

	}

	public static void main(String[] args) throws IOException {

		PropertyConfigurator
				.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\log4j.properties");

		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\OR.properties");
		OR.load(fis);

		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\Config.properties");
		config.load(fis);

		if (config.getProperty("browser").equalsIgnoreCase("chrome")) {

			System.setProperty(config.getProperty("chromedriverkey"),
					System.getProperty("user.dir") + config.getProperty("chromedriverpath"));
			driver = new ChromeDriver();
			log.info("chrome launched!!");

		} else if (config.getProperty("browser").equalsIgnoreCase("firefox")) {

			System.setProperty(config.getProperty("geckodriverkey"),
					System.getProperty("user.dir") + config.getProperty("geckodriverpath"));
			driver = new FirefoxDriver();

		} else if (config.getProperty("browser").equalsIgnoreCase("ie")) {

			System.setProperty(config.getProperty("iedriverkey"),
					System.getProperty("user.dir") + config.getProperty("iedriverpath"));
			driver = new InternetExplorerDriver();

		}

		driver.get(config.getProperty("testsiteurl"));
		log.info("navigated to: " + config.getProperty("testsiteurl"));
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);

		type("email_ID", "gouribhale@gmail.com");
		click("nextBtn_XPATH");

		/*
		 * driver.findElement(By.xpath(OR.getProperty("email_XPATH"))).sendKeys(
		 * "gouribhale@gmail.com");
		 * driver.findElement(By.xpath(OR.getProperty("nextBtn_XPATH"))).click();
		 */

		/*
		 * //driver.get(config.getProperty("testsiteurl"));
		 * System.out.println(config.getProperty("testsiteurl"));
		 * 
		 * System.out.println(OR.getProperty("email_XPATH"));
		 * //driver.findElement(By.xpath(OR.getProperty("email_XPATH"))).sendKeys(
		 * "value");
		 */ }

}
