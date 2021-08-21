package week2.day2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//1
		driver.findElement(By.xpath("//label[@for=\"home\"]/following-sibling::img")).click();
		driver.navigate().back();
		
		//2
		driver.findElement(By.xpath("//label[@for=\"position\"]/following-sibling::img")).click();
		String title = driver.getTitle();
		String currentTitle = "TestLeaf - Interact with Images";
		if(title.equals(currentTitle)) {
			System.out.println("The clicked image is broken.");
			
		}
		else {
			System.out.println("The image is fine");
		}
		
	}

}
