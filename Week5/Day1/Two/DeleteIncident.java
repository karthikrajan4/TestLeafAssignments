package week5.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteIncident extends BaseService {
	@Test
	public void deleteInci() throws InterruptedException {
		System.out.println("*****Delete Incident Initiated*****");
		// search and open the record
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

		// delete
		String numb = driver.findElement(By.id("incident.number")).getAttribute("value");
		Thread.sleep(1000);
		driver.findElement(By.id("sysverb_delete")).click();
		Thread.sleep(1500);
		WebElement alert = driver.findElement(By.id("delete_confirm_form"));
		Thread.sleep(2000);
		String alrtmsg = alert.getText();
		System.out.println("the sweet alert message is:" + alrtmsg);
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		Thread.sleep(1500);

		// Verify the deleted
		WebElement findd = driver.findElement(By.xpath("//input[@class='form-control']"));
		findd.click();
		findd.sendKeys(numb);
		findd.sendKeys(Keys.ENTER);
		String text = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
		String record = "No records to display";
		if (text.equals(record)) {
			System.out.println("*****Incident is deleted.*****");
		} else {
			System.out.println("*****The incident is not deleted.*****");
		}

	}

}
