package week4.day2.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement men = driver.findElement(By.xpath("(//span[@class='catText'])[6]"));
		Actions action = new Actions(driver);
		action.moveToElement(men).perform();
		driver.findElement(By.xpath("//span[(text()='Sports Shoes')]")).click();

		// count sport shoes
		String Shoes = driver.findElement(By.xpath("//div[(text()='Sports Shoes')]")).getText();

		driver.findElement(By.xpath("//div[(text()='Training Shoes')]")).click();

		// sort
		WebElement sort = driver.findElement(By.xpath("//div[@class='sort-drop clearfix']"));
		sort.click();
		Actions action1 = new Actions(driver);
		action1.moveToElement(sort).perform();
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
		Thread.sleep(1500);

		// Check whether the price is low to high
		Thread.sleep(1000);
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		int size = price.size();
		int old = 0;
		for (int i = 0; i < size; i++) {
			String oldprice = price.get(i).getText();
			String replace = oldprice.replaceAll("[^0-9]", "");
			int neww = Integer.parseInt(replace);
			if (old <= neww) {
				old = neww;
			}
			else {
				System.out.println("The list is covered.");
			}

		}

		// Hover on first product and click quick view
		Thread.sleep(2000);
		WebElement prod = driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(prod).perform();
		driver.findElement(By.xpath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']")).click();

		// Checking the price
		Thread.sleep(250);
		String actual = driver.findElement(By.xpath("//span[@class='strikee ']")).getText();
		Thread.sleep(250);
		String disc = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Picking the first product form the list for Quick view.");
		Thread.sleep(200);
		System.out.println("The actual price is: " + actual);
		System.out.println(disc + " is the discount.");

		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		Thread.sleep(1000);

		// Click the brand Asian
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1250)");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//label[@for='Brand-ASIAN']")).click();
		System.out.println("Asian brand selected.");

	}

}
