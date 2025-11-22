package testing.demo.project2;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase4 {
	
	WebDriver driver;
	private HomePage homePage;
	
	@BeforeClass
	public void setupClass() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	}

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		homePage = new HomePage(driver);
		homePage.open();
		homePage.searchBox("Women");
	}
	
	@Test
	public void testSearchWomen() {
		WebElement womenHyperLink = driver.findElement(By.linkText("Women for A&M-Texarkana"));
		assertTrue(womenHyperLink.isDisplayed());
	}
	
	@Test
	public void testWomenPage() {
		homePage.clickWomen();
		WomenPage womenPage = new WomenPage(driver);
		
		assertTrue(womenPage.getDonationLink().isDisplayed());
		assertTrue(womenPage.getJoinWomenLink().isDisplayed());
		assertTrue(driver.getTitle().contains("Women for A&M-Texarkana"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@AfterClass
	public void tearDownClass() {
		System.out.println("All search tests completed.");
	}

}
