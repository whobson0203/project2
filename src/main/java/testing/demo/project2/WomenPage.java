package testing.demo.project2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenPage {

	WebDriver driver;
	
	@FindBy(linkText = "Make a Scholarship Donation")
	private WebElement donationLink;

	@FindBy(linkText = "Join Women for A&M-Texarkana")
	private WebElement joinWomenLink;
	
	public WomenPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getDonationLink() {
		return donationLink;
	}
	
	public WebElement getJoinWomenLink() {
		return joinWomenLink;
	}
}
