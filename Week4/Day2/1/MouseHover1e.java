package week4.day2.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover1e {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/mouseOver.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement ele = driver.findElement(By.xpath("//a[text()='TestLeaf Courses']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(1000);

		// 1 Get the list of links from the button
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		for (WebElement link : allLinks) {
			System.out.println(link.getText());
		}

		// 2 Get the detail of selected link
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Selenium']")).click();
		Alert alert = driver.switchTo().alert();
		String alrtmsg1 = alert.getText();
		System.out.println(alrtmsg1);
		alert.accept();
	}

}
