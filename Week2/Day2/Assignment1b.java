package week2.day2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 2
		WebElement position = driver.findElement(By.id("position"));
		Point p = position.getLocation();
		int x = p.getX();
		int y = p.getY();
		System.out.println("Coordinates of an element is : " + x + " and " + y);

		// 3
		String color = driver.findElement(By.id("color")).getCssValue("color");
		System.out.println("Colour is:" + color);

		// 4
		WebElement dimension = driver.findElement(By.id("size"));
		int h = dimension.getSize().getHeight();
		int w = dimension.getSize().getWidth();
		System.out.println("height is:" + h + " and width is:" + w);
		
		//1
		driver.findElement(By.id("home")).click();
	}

}
