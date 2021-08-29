package week4.day1.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CherCher3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// navigate to frame1
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Text in topic field");

		// navigate to frame3
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@id='a']")).click();

		// Back to main content
		driver.switchTo().defaultContent();

		// navigate to frame2
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frame2);
		WebElement drop1 = driver.findElement(By.id("animals"));
		Select drpDown = new Select(drop1);
		drpDown.selectByValue("babycat");

		// Back to main content
		driver.switchTo().defaultContent();

	}

}
