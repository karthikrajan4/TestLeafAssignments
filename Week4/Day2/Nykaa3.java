package week4.day2.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Hover on men and click jackets
		WebElement ele = driver.findElement(By.id("brand_arrowUp"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		driver.findElement(By.xpath("(//a[@target='_blank'])[10]")).click();

		// Verify L'Oreal
		Set<String> WindowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesSet = new ArrayList<String>(WindowHandlesSet);
		driver.switchTo().window(windowHandlesSet.get(1));
		Thread.sleep(1000);
		String title = driver.getTitle();
		String verify = "L'Oreal Paris - Buy L'Oreal Paris Products Online at Best Price | Nykaa";
		if (verify.equals(title)) {
			System.out.println("The title is L'Oreal");
		} else {
			System.out.println("The title is different");

		}

		// Open Shampoo
		WebElement ele1 = driver.findElement(By.xpath("//a[text()='hair']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(ele1).perform();
		driver.findElement(By.xpath("//a[text()='Shampoo']")).click();

		Set<String> WindowHandlesSet1 = driver.getWindowHandles();
		List<String> windowHandlesSet1 = new ArrayList<String>(WindowHandlesSet1);
		driver.switchTo().window(windowHandlesSet1.get(2));
		Thread.sleep(1000);

		// sort by customer
		WebElement ele2 = driver.findElement(By.id("sortComponent"));
		ele2.click();
		Actions action2 = new Actions(driver);
		action2.moveToElement(ele2).perform();
		driver.findElement(By.xpath("(//div[@class=\"control-box sort-control-box\"])[4]")).click();

		// verify the page
		String title1 = driver.getTitle();
		String verify2 = "Hair Shampoo: Buy Shampoo Online at Low Prices in India | Nykaa";
		if (title1.equals(verify2)) {
			System.out.println("The webpage is for shampoo");
		} else {
			System.out.println("The page is not correct.");
		}
		Thread.sleep(2500);
		// select loreal
		WebElement ele3 = driver.findElement(By.xpath("//div[text()='Brand']"));
		ele3.click();
		Actions action3 = new Actions(driver);
		action3.moveToElement(ele3).perform();
		driver.findElement(By.xpath("//div[@class='control__indicator']")).click();
		Thread.sleep(1000);

		// open loreal color protect
		driver.findElement(By.xpath("(//span[contains(text(), 'Oreal Paris Colour Protect Shampoo')])[1]")).click();

		// select 360ml
		Set<String> WindowHandlesSet2 = driver.getWindowHandles();
		List<String> windowHandlesSet2 = new ArrayList<String>(WindowHandlesSet2);
		driver.switchTo().window(windowHandlesSet2.get(3));
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//span[@class='size-pallets'])[3]")).click();

		String mrp = driver.findElement(By.xpath("(//span[@class='post-card__content-price-offer'])")).getText();
		String price = mrp.replaceAll("[^0-9]", "");
		System.out.println("The selected bottle price is: Rs." + price);

		// Add to Cart
		WebElement cart = driver.findElement(By.xpath("//div[@class='pull-left']"));
		Actions action4 = new Actions(driver);
		action4.moveToElement(cart).perform();
		Thread.sleep(2000);
		cart.click();
		System.out.println("The item added in the cart");

		// Open cart
		Thread.sleep(1000);
		driver.findElement(By.className("AddBagIcon")).click();
		String grand = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		String total1 = grand.replaceAll("[^0-9]", "");
		Thread.sleep(500);
		System.out.println("The grand total is: Rs." + total1);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();

		//
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		String grandd = driver.findElement(By.xpath("//div[text()='Grand Total']")).getText();
		String total2 = grandd.replaceAll("[^0-9]", "");

		if (total1.equals(total2)) {
			System.out.println("the price is correct");
		} else {
			System.out.println("The price value has difference.");
		}
		driver.close();
	}

}
