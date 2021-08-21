package week2.day2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3RedBus {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Location search
		WebElement From = driver.findElement(By.id("src"));
		From.sendKeys("Chennai (All Locations)");
		Thread.sleep(1000);
		From.sendKeys(Keys.ENTER);

		WebElement Desti = driver.findElement(By.id("dest"));
		Desti.sendKeys("Bangalore");
		Thread.sleep(1000);
		Desti.sendKeys(Keys.ENTER);

		WebElement picker = driver.findElement(By.id("onward_cal"));
		picker.click();
		driver.findElement(By.xpath("//tr[@class='rb-monthHeader']"));
		driver.findElement(By.xpath("//td[text()='25']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		Thread.sleep(3000);

		// Close popups
		driver.findElement(By.className("close")).click();
		Thread.sleep(4000);
		driver.findElement(By.className("close-primo")).click();

		// Current search result
		String result1 = driver.findElement(By.xpath("//span[@class='w-60 d-block d-found']")).getText();
		System.out.println("Initial search result count:" + result1);

		// Search sleeper only
		driver.findElement(By.xpath("//label[@title='SLEEPER']")).click();
		Thread.sleep(3000);
		String result2 = driver.findElement(By.xpath("//span[@class='w-60 d-block d-found']")).getText();
		System.out.println("Sleeper bus search result count:" + result2);

		// Deselect the sleeper Bus and select the AC bus alone
		driver.findElement(By.xpath("//label[@title='SLEEPER']")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(1000);

		WebElement AC = driver.findElement(By.xpath("//label[@for='bt_AC']"));
		// Thread.sleep(3000);
		AC.click();
		String result3 = driver.findElement(By.xpath("//span[@class='w-60 d-block d-found']")).getText();
		System.out.println("AC bus search result count:" + result3);
		
		//Also select Non AC Bus
		WebElement nonAC = driver.findElement(By.xpath("//label[@for='bt_NONAC']"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,280)");
		nonAC.click();
		String result4 = driver.findElement(By.xpath("//span[@class='w-60 d-block d-found']")).getText();
		System.out.println("AC & Non AC bus search result count:" + result4);
	}

}
