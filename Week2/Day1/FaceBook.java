package week2.day1.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("(//a[@class='_sv4'])[10]")).click();
		
		driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
		
		driver.findElement(By.name("firstname")).sendKeys("FirstName");
		
		driver.findElement(By.name("lastname")).sendKeys("LastName");
		
		driver.findElement(By.name("reg_email__")).sendKeys("9876543210");
		
		driver.findElement(By.id("password_step_input")).sendKeys("Password$1");
		
		WebElement Day = driver.findElement(By.id("day"));
		Select dropdown1 = new Select(Day);
		dropdown1.selectByValue("10");
		
		WebElement Month = driver.findElement(By.id("month"));
		Select dropdown2 = new Select(Month);
		dropdown2.selectByValue("7");
		
		WebElement Year = driver.findElement(By.id("year"));
		Select dropdown3 = new Select(Year);
		dropdown3.selectByValue("2000");
		
		driver.findElement(By.className("_8esa")).click();
		
		//driver.findElement(By.name("websubmit")).click();
		
	}

}
