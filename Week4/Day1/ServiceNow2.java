package week4.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://dev113545.service-now.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// navigate to frame and login
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("w6hnF2FRhwLC");
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(5000);

		// search and click new
		driver.findElement(By.id("filter")).sendKeys("incident");
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		Thread.sleep(1500);
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Enter mandatory fields and submit
		WebElement caller = driver.findElement(By.id("sys_display.incident.caller_id"));

		String numb = driver.findElement(By.id("incident.number")).getAttribute("value");
		caller.sendKeys("Abel");
		Thread.sleep(1000);
		caller.click();
		System.out.println("The captured incident number is: " + numb);
		driver.findElement(By.id("incident.short_description")).sendKeys("Test description");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		Thread.sleep(2000);

		// Search the incident number
		WebElement findd = driver.findElement(By.xpath("(//input[@placeholder='Search'])[2]"));
		findd.sendKeys(numb);
		findd.sendKeys(Keys.ENTER);

		// Verify
		String verifyy = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		if (verifyy.equals(numb)) {
			System.out.println("Record found");

			File src1 = driver.getScreenshotAs(OutputType.FILE);
			File dst = new File("./snaps/image.png");
			FileUtils.copyFile(src1, dst);
		} else {
			System.out.println("Result not found");
		}
	}

}
