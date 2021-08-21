package week2.day2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 1
		driver.findElement(By.id("email")).sendKeys("Test enter");

		// 2
		WebElement append = driver.findElement(By.xpath("//input[@value='Append ']"));
		append.sendKeys("after");
		append.sendKeys(Keys.TAB);

		// 3
		WebElement gettext = driver.findElement(By.name("username"));
		String val = (gettext.getAttribute("value"));
		System.out.println("The input field value is:" + val);

		// 4
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();

		// 5
		boolean enabled = driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled();
		if (enabled == false)
			System.out.println("The field is disabled");
		else
			System.out.println("The field is enabled");

	}

}
