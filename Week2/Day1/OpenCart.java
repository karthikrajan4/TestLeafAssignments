package week2.day1.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("input-username")).sendKeys("UserName");
		
		driver.findElement(By.id("input-firstname")).sendKeys("First Name");
		
		driver.findElement(By.id("input-lastname")).sendKeys("Last Name");
		
		driver.findElement(By.id("input-email")).sendKeys("testmail.mailinator.com");
		
		WebElement country = driver.findElement(By.id("input-country"));
		Select dropdown1 = new Select(country);
		dropdown1.selectByValue("99");
		
		
		driver.findElement(By.id("input-password")).sendKeys("Password$1");
		
		
		
		
		

	}

}
