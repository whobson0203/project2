package testing.demo.project2;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase5 {

	WebDriver driver;
	private HomePage homePage;
	private AlumniPage alumniPage;
	
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
		homePage.clickAlumni();
		alumniPage = new AlumniPage(driver);
	}
	
	@Test
	public void testAlumniPage() {
		assertTrue(alumniPage.getAlumniBrickLink().isDisplayed());
		assertTrue(alumniPage.getAlumniAssociationLink().isDisplayed());
		assertTrue(alumniPage.getUpdateAlumniInfoLink().isDisplayed());
		assertTrue(alumniPage.getWomenLink().isDisplayed());
	}
	
	@Test
	public void testWomenPage() {
		alumniPage.clickWomenLink();
		
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
		System.out.println("All Case 5 tests completed.");
	}
}
