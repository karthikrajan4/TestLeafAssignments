package week5.day1.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseService {
	public ChromeDriver driver;

	@BeforeMethod
	public void preCondition() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev87559.service-now.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement frame1 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Rocket@1");
		driver.findElement(By.id("sysverb_login")).click();
		System.out.println("Executed PreCondition.");

	}

	@AfterMethod
	public void postCondition() {
		driver.close();
		System.out.println("Executed Post Condition.");
	}

}
