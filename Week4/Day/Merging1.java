package week4.day1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Merging1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Contacts")).click();

		driver.findElement(By.linkText("Merge Contacts")).click();

		// Merge Contacts
		//From Contact
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Thread.sleep(2000);
		Set<String> WindowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesSet = new ArrayList<String>(WindowHandlesSet);
		driver.switchTo().window(windowHandlesSet.get(1));
		String title = driver.getTitle();
		System.out.println("Moved page title is: " + title);

		WebElement result = driver.findElement(By.xpath("(//a[@class='linktext'])[1]"));
		String ID = result.getText();
		System.out.println("The first ID in the table is: " + ID);
		result.click();
		Thread.sleep(2000);

		driver.switchTo().window(windowHandlesSet.get(0));
		Thread.sleep(2000);

		//To Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Thread.sleep(2000);
		Set<String> WindowHandlesSet1 = driver.getWindowHandles();
		List<String> windowHandlesSet1 = new ArrayList<String>(WindowHandlesSet1);
		driver.switchTo().window(windowHandlesSet1.get(1));
		String title1 = driver.getTitle();
		System.out.println("Moved page title is: " + title1);
		
		WebElement result1 = driver.findElement(By.xpath("(//a[@class='linktext'])[5]"));
		String ID1 = result1.getText();
		System.out.println("The Second ID in the table is: " + ID1);
		result1.click();
		Thread.sleep(2000);

		driver.switchTo().window(windowHandlesSet.get(0));
		Thread.sleep(2000);
		
		//Merge
		driver.findElement(By.className("buttonDangerous")).click();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
		//Verify title
		String title2 = driver.getTitle();
		System.out.println("Final page title is: " + title2);


	}

}
