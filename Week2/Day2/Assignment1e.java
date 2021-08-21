package week2.day2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1e {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//drop1
		WebElement drop1 = driver.findElement(By.id("dropdown1"));
		Select drpDown1 = new Select(drop1);
		drpDown1.selectByIndex(1);
		
		//drop2
		WebElement drop2 = driver.findElement(By.name("dropdown2"));
		Select drpDown2 = new Select(drop2);
		drpDown2.selectByVisibleText("Appium");

		
		//drop3
		WebElement drop3 = driver.findElement(By.id("dropdown3"));
		Select drpDown3 = new Select(drop3);
		drpDown3.selectByValue("3");
		
		//drop4
		WebElement drop4 = driver.findElement(By.className("dropdown"));
		Select drpDown4 = new Select(drop4);
		int size = drpDown4.getOptions().size();
		System.out.println("The number of options are:" + size);
		
		//drop5
		driver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[5]/select")).sendKeys("Selenium");
	}

}
