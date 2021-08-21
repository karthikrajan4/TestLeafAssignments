package week2.day2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2c {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();

		String homeTitle = driver.getTitle();
		String title = "My Home | opentaps CRM";
		if (title.equals(homeTitle)) {
			System.out.println("Landing page was correct");
		} else {
			System.out.println("Landing page was incorrect");
		}

		//Find Lead
		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.linkText("Find Leads")).click();

		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[3]")).click();

		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("testlead@gmail.com");

		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[7]")).click();
		Thread.sleep(1000);

		WebElement result = driver.findElement(By.xpath("(//a[@class='linktext'])[6]"));
		String fName = result.getText();
		System.out.println("The first ID in the table is: " + fName);
		result.click();
		Thread.sleep(2000);
		
		//Duplicate
		driver.findElement(By.xpath("//a[@class='subMenuButton']")).click();

		String currentPage = driver.getTitle();
		String heading = "Duplicate Lead | opentaps CRM";
		if (heading.equals(currentPage)) {
			System.out.println("The current landing page is: " + currentPage);
		} else {
			System.out.println("The page is not correct");
			driver.close();
		}
		
		driver.findElement(By.className("smallSubmit")).click();
		Thread.sleep(1500);
		
		String confoName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if(confoName.equals(fName)) {
			System.out.println("The selected record is duplicated.");
		}
		else {
			System.out.println("The result is not correct");
		}
	}

}
