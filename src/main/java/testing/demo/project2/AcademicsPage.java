package testing.demo.project2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcademicsPage {

	WebDriver driver;
	
	@FindBy(linkText = "Undergraduate Programs")
	private WebElement undergraduateProgramsLink;
	
	@FindBy(linkText = "Graduate Programs")
	private WebElement graduateProgramsLink;
	
	@FindBy(linkText = "Doctorate Program")
	private WebElement doctorateProgramLink;
	
	@FindBy(linkText = "Online Programs")
	private WebElement onlineProgramsLink;
	
	@FindBy(xpath = "//a[contains(@href, 'computer-science')]")
	private WebElement computerScienceLink;
	
	public AcademicsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUndergraduateProgramsLink() {
		return undergraduateProgramsLink;
	}
	
	public WebElement getGraduateProgramsLink() {
		return graduateProgramsLink;
	}
	
	public WebElement getDoctorateProgramLink() {
		return doctorateProgramLink;
	}
	
	public WebElement getOnlineProgramsLink() {
		return onlineProgramsLink;
	}
	
	public void clickComputerScienceLink() {
		computerScienceLink.click();
	}
}
