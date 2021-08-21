package week2.day2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2b {

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

		String homeTitle = driver.getTitle();
		String title = "My Home | opentaps CRM";
		if (title.equals(homeTitle)) {
			System.out.println("Landing page was correct");
		} else {
			System.out.println("Landing page was incorrect");
		}

		// Find Lead
		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.linkText("Find Leads")).click();

		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]")).click();

		driver.findElement(By.xpath("(//input[@name='phoneNumber'])")).sendKeys("8190917893");

		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[7]")).click();
		Thread.sleep(1000);

		WebElement result = driver.findElement(By.xpath("(//a[@class='linktext'])[4]"));
		String ID = result.getText();
		System.out.println("The first ID in the table is: " + ID);
		result.click();
		Thread.sleep(2000);

		//Delete
		driver.findElement(By.linkText("Delete")).click();
		Thread.sleep(2000);
		System.out.println("Deleted");

		driver.findElement(By.linkText("Find Leads")).click();

		driver.findElement(By.xpath("(//input[@name='id'])")).sendKeys(ID);
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[7]")).click();
		Thread.sleep(1000);

		String confirmation = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		if (confirmation.equals("No records to display")) {
			System.out.println("Not record found. Lead Deleted successfully");

		} else {
			System.out.println("lead is still available in the result");
		}
		driver.close();
	}

}
