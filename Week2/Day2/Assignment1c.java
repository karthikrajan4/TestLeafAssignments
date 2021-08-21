package week2.day2.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1c {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 1
		driver.findElement(By.xpath("//a[@link='blue']")).click();
		System.out.println("opened homepage");
		driver.findElement(By.xpath("//a[@href='pages/Link.html']")).click();

		// 2
		driver.findElement(By.xpath("//a[@style='color:green']")).click();
		String gettitle = driver.getTitle();
		String title = "TestLeaf - Interact with Buttons";
		if (gettitle.equals(title)) {
			System.out.println("The landing page is correct: " + gettitle);
			driver.findElement(By.xpath("//img[@alt='logo Testleaf']")).click();
			driver.findElement(By.xpath("//a[@href='pages/Link.html']")).click();
			System.out.println("returned to the page");

		} else {
			System.out.println("it is not");
			driver.findElement(By.xpath("//img[@alt='logo Testleaf']")).click();
			driver.findElement(By.xpath("//a[@href='pages/Link.html']")).click();
			System.out.println("returned to the page");
		}

		// 3
		driver.findElement(By.xpath("//a[@href='error.html']")).click();
		String gettitle1 = driver.getTitle();
		String title1 = "HTTP Status 404 – Not Found";
		if (gettitle1.equals(title1)) {
			System.out.println("The page is not found ");
			driver.navigate().back();

		} else {
			System.out.println("it is not");

		}

		// 4
		String link1 = driver.findElement(By.linkText("Go to Home Page")).getAttribute("href");
		String link2 = driver.findElement(By.xpath("//label[@for=\"position\"]/preceding-sibling::a")).getAttribute("href");
		if (link1.equals(link2)) {
			System.out.println("Both the links are same");
			driver.findElement(By.linkText("Go to Home Page")).click();
			driver.navigate().back();
		} else
			System.out.println("Both the links are different");

		// How many links are available in this page
		List<WebElement> tag = driver.findElements(By.tagName("a"));
		System.out.println("Number of links in the page : " + tag.size());

	}

}
