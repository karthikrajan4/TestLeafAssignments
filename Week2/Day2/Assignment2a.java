package week2.day2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();

		String homeTitle = driver.getTitle();
		String title = "My Home | opentaps CRM";
		if (title.equals(homeTitle)) {
			System.out.println("Landing page was correct");
		} else {
			System.out.println("Landing page was incorrect");
		}

		//Create contact
		driver.findElement(By.linkText("Contacts")).click();

		driver.findElement(By.linkText("Create Contact")).click();

		driver.findElement(By.id("firstNameField")).sendKeys("first name");

		driver.findElement(By.id("lastNameField")).sendKeys("Last name");

		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Local first name");

		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Local last name");

		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Department");

		driver.findElement(By.id("createContactForm_description")).sendKeys("Test description");

		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("Testmail@mailinator.com");

		WebElement dropState = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select state = new Select(dropState);
		state.selectByValue("NY");

		driver.findElement(By.name("submitButton")).click();
		System.out.println("Form created");

		// Edit
		driver.findElement(By.linkText("Edit")).click();

		driver.findElement(By.id("updateContactForm_description")).clear();

		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Updating after clearing description");

		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();

		String currentTitle = driver.getTitle();
		System.out.println("The current page title is: " + currentTitle);

	}

}
