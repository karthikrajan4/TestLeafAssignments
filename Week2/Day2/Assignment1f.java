package week2.day2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1f {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//1
		driver.findElement(By.id("yes")).click();
		
		//2
		WebElement radio = driver.findElement(By.name("news"));
		boolean state = radio.isSelected();
		if(state == true) {
			System.out.println("The selected option is: Unchecked");
			
		}
		else{
			System.out.println("The selected option is: checked");
		}
		
		//3
		WebElement radio2 = driver.findElement(By.xpath("(//input[@class='myradio'])[4]"));
		boolean Agerange = radio2.isSelected();
		if(Agerange== true) {
			System.out.println("My age range is elected");
		}
		else {
			System.out.println("other range got selected");
			driver.findElement(By.xpath("(//input[@class='myradio'])[4]"));
		}
	}

}
