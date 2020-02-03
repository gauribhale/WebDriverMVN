package TestCases;

//dropdown and URL handling on a webPage
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestLogin {
	// TestNG -->TO create test cases
	
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// driver.findElement(By.xpath("//select[@id='searchLanguage']")).sendKeys("Eesti");
		// -->sendkeys not to be used with dropdown

		Select select = new Select(driver.findElement(By.xpath("//select[@id='searchLanguage']")));
		//select.selectByVisibleText("Eesti");
		// select.selectByValue("hi");
		select.selectByIndex(0);
		// select.getOptions();

		List<WebElement> values = driver.findElements(By.tagName("option"));
		System.out.println(values.size());

		System.out.println(values.get(7).getText()); // getAttribute

		/*
		 * for (int i = 0; i < values.size(); i++) {
		 * System.out.println(values.get(i).getAttribute("lang")); }
		 */

		System.out.println("---printing all link in a block---");

		WebElement block = driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[3]"));
		List<WebElement> blocks = block.findElements(By.tagName("a"));
		System.out.println(blocks.size());
		
		for (WebElement b : blocks) {
			System.out.println(b.getText() + "---URL IS---" + b.getAttribute("href"));
		}

		/*
		 * List<WebElement> links = driver.findElements(By.tagName("a")); // tagName a
		 * (anchor tag) to find the links System.out.println(links.size());
		 * 
		 * for(WebElement link:links) {
		 * System.out.println(link.getText()+"--URL is--"+link.getAttribute("href")); }
		 */
	}

}
