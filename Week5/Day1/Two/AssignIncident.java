package week5.day1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AssignIncident extends BaseService {
	@Test
	public void assignInci() throws InterruptedException {
		System.out.println("*****Assigned Incident Initiated*****");
		//search and open the record
		driver.findElement(By.id("filter")).sendKeys("incident");
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		Thread.sleep(1500);
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame2);
		WebElement find = driver.findElement(By.xpath("//input[@class='form-control']"));
		find.click();
		Thread.sleep(1000);
		find.sendKeys("INC0010");
		Thread.sleep(1500);
		find.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//td[@class='vt']")).click();

		// Assign
		String numb = driver.findElement(By.id("incident.number")).getAttribute("value");
		Thread.sleep(1000);
		String originalHandle = driver.getWindowHandle();
		Thread.sleep(1000);
		WebElement assign = driver.findElement(By.id("sys_display.incident.assignment_group"));
		assign.clear();
		assign.sendKeys("Software");
		Thread.sleep(500);
		assign.sendKeys(Keys.ENTER);
		Thread.sleep(2500);
		driver.findElement(By.id("lookup.incident.assigned_to")).click();
		Set<String> WindowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesSet = new ArrayList<String>(WindowHandlesSet);
		driver.switchTo().window(windowHandlesSet.get(1));
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[2]")).click();
		driver.switchTo().window(originalHandle);
		Thread.sleep(2000);
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.id("incident.description")).click();
		driver.findElement(By.id("sysverb_update")).click();
		Thread.sleep(1500);

		// Verify
		WebElement findd = driver.findElement(By.xpath("//input[@class='form-control']"));
		findd.click();
		findd.sendKeys(numb);
		findd.sendKeys(Keys.ENTER);
		String progress = "Software";
		String text = driver.findElement(By.xpath("(//td[@class='vt'])[8]")).getText();
		System.out.println(text);
		if (progress.equals(text)) {
			System.out.println("*****Incident is Assigned*****");
		} else {
			System.out.println("*****Incident is not Assigned*****");
		}

	}

}
