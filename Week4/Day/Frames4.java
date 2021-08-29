package week4.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// navigate to frame 1 and click the button
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@src='default.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.id("Click")).click();

		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/image.png");
		FileUtils.copyFile(src1, dst);

		// Count the frames
		List<WebElement> count = driver.findElements(By.tagName("iframe"));
		System.out.println("The number of inside frames are : " + count.size());
		
		//Count the overall frames
		driver.switchTo().defaultContent();
		List<WebElement> count1 = driver.findElements(By.tagName("iframe"));
		System.out.println("The number of overall frames are : " + count1.size());
	}

}
