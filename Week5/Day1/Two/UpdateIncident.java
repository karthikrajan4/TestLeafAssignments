package week5.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateIncident extends BaseService {

	@Test
	public void updateInci() throws InterruptedException {
		System.out.println("*****Update Incident Initiated*****");
		// Search incident and select the first record
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
		find.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//td[@class='vt']")).click();

		// Update the data: Urgency - High; State - In progress
		String numb = driver.findElement(By.id("incident.number")).getAttribute("value");
		Thread.sleep(1000);
		WebElement drop1 = driver.findElement(By.xpath("//select[@name='incident.urgency']"));
		Select drpDown1 = new Select(drop1);
		drpDown1.selectByIndex(0);

		WebElement drop2 = driver.findElement(By.xpath("//select[@name='incident.state']"));
		Select drpDown2 = new Select(drop2);
		drpDown2.selectByIndex(1);

		driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click();
		Thread.sleep(1500);

		// verify the changed data
		WebElement findd = driver.findElement(By.xpath("//input[@class='form-control']"));
		findd.click();
		findd.sendKeys(numb);
		findd.sendKeys(Keys.ENTER);
		String progress = "In Progress";
		String text = driver.findElement(By.xpath("(//td[@class='vt'])[6]")).getText();
		System.out.println("Modified state is: " + text);
		if (progress.equals(text)) {
			System.out.println("*****Incident is updated*****");
		} else {
			System.out.println("*****Incident is not updated*****");
		}

	}

}
