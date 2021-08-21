package week2.day2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1g {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 1
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		// 2
		WebElement check1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[6]"));
		Boolean verify1 = check1.isSelected();
		if (verify1 == true) {
			System.out.println("It is checked by default");
		} else {
			System.out.println("it is not");
		}

		// 3
		WebElement check2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[8]"));
		Boolean verify2 = check2.isSelected();
		if (verify2 == true) {
			System.out.println("It is checked by default. Going to uncheck the same");
			check2.click();
		} else {
			System.out.println("it is not checked by default");
		}

		// 4
		driver.findElement(By.xpath("(//input[@type='checkbox'])[9]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[10]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[11]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[12]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[13]")).click();
		System.out.println("All checkbox on 4th category has been checked");
	}

}
