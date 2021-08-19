package week2.day1.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("UserFirstName")).sendKeys("Hai");
		
		driver.findElement(By.name("UserLastName")).sendKeys("Hello");
		
		driver.findElement(By.name("UserEmail")).sendKeys("hai.hello@mailinator.com");
		
		driver.findElement(By.name("CompanyName")).sendKeys("Testing comp");
		
		driver.findElement(By.name("UserPhone")).sendKeys("9876543210");
		
		//Pending 3 dropdowns;
		
		WebElement JobTitle = driver.findElement(By.name("UserTitle"));
		Select dropdown1 = new Select(JobTitle);
		dropdown1.selectByValue("Customer_Service_Manager_AP");
		
		WebElement Employee = driver.findElement(By.name("CompanyEmployees"));
		Select dropdown2 = new Select(Employee);
		dropdown2.selectByValue("250");
		
		WebElement Country = driver.findElement(By.name("CompanyCountry"));
		Select dropdown3 = new Select(Country);
		dropdown3.selectByVisibleText("Bhutan");
		
		driver.findElement(By.className("checkbox-ui")).click();
		
		
		

	}

}
