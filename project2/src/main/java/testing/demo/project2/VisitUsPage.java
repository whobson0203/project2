package testing.demo.project2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VisitUsPage {
	
	WebDriver driver;
	
	@FindBy(linkText = "Upcoming Events")
	private WebElement upcomingEventsLink;
	
	@FindBy(linkText = "Schedule a Campus Tour")
	private WebElement campusTourLink;
	
	@FindBy(linkText = "Virtual Tour")
	private WebElement virtualTourLink;
	
	public VisitUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUpcomingEventsLink() {
		return upcomingEventsLink;
	}
	
	public WebElement getCampusTourLink() {
		return campusTourLink;
	}
	
	public WebElement getVirtualTourLink() {
		return virtualTourLink;
	}
}
