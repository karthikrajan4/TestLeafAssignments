package week5.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateIncident extends BaseService {
	@Test
	public void createInci() throws InterruptedException {
		System.out.println("*****Create Incident Initiated*****");
		//Create incident
		driver.findElement(By.id("filter")).sendKeys("incident");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		Thread.sleep(1500);
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame2);
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
		WebElement findd = driver.findElement(By.xpath("//input[@class='form-control']"));
		findd.click();
		findd.sendKeys(numb);
		findd.sendKeys(Keys.ENTER);

		// Verify
		String verifyy = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		if (verifyy.equals(numb)) {
			System.out.println("*****Created Incident found*****");

		} else {
			System.out.println("*****Incident not found*****");
		}
	}
}
