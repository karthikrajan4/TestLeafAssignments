package week2.day2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2d {

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
			System.out.println("Home Landing page was correct");
		} else {
			System.out.println("Home Landing page was incorrect");
		}

		// Find Lead
		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.linkText("Find Leads")).click();

		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("catt");
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[7]")).click();
		Thread.sleep(1000);

		// Edit
		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();

		String title1 = "View Lead | opentaps CRM";
		String currTitle = driver.getTitle();
		if (title1.equals(currTitle)) {
			System.out.println("The landing page is:" + currTitle);
		} else {
			System.out.println("It is not a desired page.");
		}

		driver.findElement(By.linkText("Edit")).click();
		Thread.sleep(1000);
		String change = "Edited_company_value";
		WebElement updateField = driver.findElement(By.id("updateLeadForm_companyName"));
		updateField.clear();
		Thread.sleep(500);
		updateField.sendKeys(change);
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(1000);

		String verify = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(verify);
		String[] splitStr = verify.split("\\s+");
		// System.out.println(splitStr[0]);
		String finall = splitStr[0];
		System.out.println(finall);

		if (change.equals(finall)) {
			System.out.println("The value has been changed.");
		} else {
			System.out.println("The edit is not done properly.");
		}

	}

}
