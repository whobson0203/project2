package testing.demo.project2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlumniPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[contains(@href, 'brick')]")
	private WebElement brickLink;
	
	@FindBy(xpath = "//a[contains(@href, 'alumni-membership')]")
	private WebElement associationLink;
	
	@FindBy(xpath = "//a[contains(@href, 'update-info')]")
	private WebElement updateLink;
	
	@FindBy(xpath = "//a[@href = 'wam/index.html']")
	private WebElement womenLink;
	
	public AlumniPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAlumniBrickLink() {
		return brickLink;
	}
	
	public WebElement getAlumniAssociationLink() {
		return associationLink;
	}
	
	public WebElement getUpdateAlumniInfoLink() {
		return updateLink;
	}
	
	public WebElement getWomenLink() {
		return womenLink;
	}
	
	public void clickWomenLink() {
		womenLink.click();
	}
}
