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

public class TestCase2 {

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
		homePage.searchBox("Computer Science");
	}
	
	@Test
	public void testSearchCS() {
		WebElement csHyperLink = driver.findElement(By.xpath("//a[contains(@href, 'computer-science')]"));
		assertTrue(csHyperLink.isDisplayed());
	}
	
	@Test
	public void testComputerSciencePage() {
		homePage.clickComputerScience();
		ComputerSciencePage computerSciencePage = new ComputerSciencePage(driver);
		
		assertTrue(computerSciencePage.getAccreditationLink().isDisplayed());
		assertTrue(computerSciencePage.getFacultyLink().isDisplayed());
		assertTrue(computerSciencePage.getApplyHereLink().isDisplayed());
		assertTrue(computerSciencePage.getVisitUsLink().isDisplayed());
	}
	
	@Test
	public void testVisitUs() {
		homePage.clickComputerScience();
		ComputerSciencePage computerSciencePage = new ComputerSciencePage(driver);
		
		computerSciencePage.clickVisitUs();
		VisitUsPage visitUsPage = new VisitUsPage(driver);
		
		assertTrue(visitUsPage.getUpcomingEventsLink().isDisplayed());
		assertTrue(visitUsPage.getCampusTourLink().isDisplayed());
		assertTrue(visitUsPage.getVirtualTourLink().isDisplayed());
		assertTrue(driver.getTitle().contains("Visit Us"));
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
