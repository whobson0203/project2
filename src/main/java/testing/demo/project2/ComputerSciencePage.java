package testing.demo.project2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputerSciencePage {
	
	WebDriver driver;
	
	@FindBy(linkText = "Accreditation")
	private WebElement accreditationLink;
	
	@FindBy(linkText = "Faculty")
	private WebElement facultyLink;
	
	@FindBy(linkText = "Apply Here")
	private WebElement applyHereLink;
	
	@FindBy(linkText = "Visit Us")
	private WebElement visitUsLink;
	
	public ComputerSciencePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAccreditationLink() {
		return accreditationLink;
	}

	public WebElement getFacultyLink() {
		return facultyLink;
	}

	public WebElement getApplyHereLink() {
		return applyHereLink;
	}

	public WebElement getVisitUsLink() {
		return visitUsLink;
	}
	
	public void clickVisitUs() {
		visitUsLink.click();
	}

}
