package testing.demo.project2;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase3 {

	WebDriver driver;
	private HomePage homePage;
	private AcademicsPage academicsPage;
	private ComputerSciencePage computerSciencePage;
	private VisitUsPage visitUsPage;

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
		homePage.clickAcademics();
		academicsPage = new AcademicsPage(driver);
	}
	
	@Test
	public void testAcademics() {
		assertTrue(academicsPage.getUndergraduateProgramsLink().isDisplayed());
		assertTrue(academicsPage.getGraduateProgramsLink().isDisplayed());
		assertTrue(academicsPage.getDoctorateProgramLink().isDisplayed());
		assertTrue(academicsPage.getOnlineProgramsLink().isDisplayed());
	}
	
	@Test
	public void testComputerScience() {
		academicsPage.clickComputerScienceLink();
		computerSciencePage = new ComputerSciencePage(driver);
		
		assertTrue(computerSciencePage.getAccreditationLink().isDisplayed());
		assertTrue(computerSciencePage.getFacultyLink().isDisplayed());
		assertTrue(computerSciencePage.getApplyHereLink().isDisplayed());
		assertTrue(computerSciencePage.getVisitUsLink().isDisplayed());
	}
	
	@Test
	public void testVisitUs() {
		academicsPage.clickComputerScienceLink();
		computerSciencePage = new ComputerSciencePage(driver);
		
		computerSciencePage.clickVisitUs();
		visitUsPage = new VisitUsPage(driver);
		
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
