package week2.day1.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadFull {

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

		// Navigation to create lead
		String homeTitle = driver.getTitle();
		String title = "My Home | opentaps CRM";
		if (title.equals(homeTitle)) {
			System.out.println("Landing page was correct");
		} else {
			System.out.println("Landing page was incorrect");
		}

		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.linkText("Create Lead")).click();

		// Mandatory fields
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestCompany");

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("FirstName");

		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("LastName");

		// Dropdown - Source
		WebElement drop1 = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select drpDown = new Select(drop1);
		drpDown.selectByIndex(1);

		// Dropdown - Industry
		WebElement drop2 = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select drpDown2 = new Select(drop2);
		drpDown2.selectByVisibleText("Health Care");

		// Dropdown - Ownership
		WebElement drop3 = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select drpDown3 = new Select(drop3);
		drpDown3.selectByValue("OWN_LLC_LLP");

		// Dropdown - Marketing Campaign
		WebElement drop4 = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select drpDown4 = new Select(drop4);
		drpDown4.selectByValue("CATRQ_CAMPAIGNS");

		// Dropdown - Preferred Currency
		WebElement drop5 = driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select drpDown5 = new Select(drop5);
		drpDown5.selectByValue("BMD");

		// Other fields
		driver.findElement(By.id("createLeadForm_parentPartyId")).sendKeys("854523");

		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("FN Local");

		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("LN Local");

		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Personal Title");

		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("08/11/21");

		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Title");

		driver.findElement(By.name("departmentName")).sendKeys("Department");

		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("23432423");

		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("20-50");

		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("SIC-alks23432");

		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("Check Mark");

		driver.findElement(By.id("createLeadForm_description")).sendKeys("Test description");

		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("Nothing for now");

		// Contact Info
		// Country code
		WebElement CCode = driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode"));
		CCode.clear();
		CCode.sendKeys("91");

		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("000");

		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("04562");

		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("testmail@mailinator.com");

		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("452253");

		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Main user");

		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("www.testweb.com");

		// Primary address
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Receiver");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("Address 1");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Virudhunagar");
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("626001");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("000");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("456");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Address 2");
		
		WebElement drop6 = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select DropDown6 = new Select(drop6);
		DropDown6.selectByValue("IND");
		
		WebElement drop7 = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select DropDown7 = new Select(drop7);
		DropDown7.selectByValue("IN-TN");
		
		//driver.findElement(By.name("submitButton")).click();
	
		System.out.println("The applicaiton is done");
	}

}
