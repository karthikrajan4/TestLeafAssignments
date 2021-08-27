package week3.day2.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// open ajio
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Search bags
		WebElement one = driver.findElement(By.name("searchVal"));
		one.sendKeys("bags");
		Thread.sleep(5000);
		one.sendKeys(Keys.ENTER);

		// click Men & Fashion bags
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		Thread.sleep(3000);

		// Get count
		String result1 = driver.findElement(By.xpath("//div[@Class='length']")).getText();
		System.out.println("The search result for Fashion bags/men is:" + result1);

		// List of brands
		System.out.println("List of Brands");
		List<WebElement> bagBrandList = driver.findElements(By.className("brand"));
		System.out.println("Size :" + bagBrandList.size());
		for (WebElement webElement : bagBrandList) {

			String text = webElement.getText();
			System.out.println(text);
		}

		// list of names of the bags
		List<WebElement> bagNameList = driver.findElements(By.className("name"));
		System.out.println("Size :" + bagNameList.size());
		System.out.println("Names of the Bags");
		for (WebElement webElement : bagNameList) {
			String text = webElement.getText();
			System.out.println(text);
		}
	}

}
