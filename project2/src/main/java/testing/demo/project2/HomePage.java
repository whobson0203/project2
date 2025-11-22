package testing.demo.project2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;
	private final String URL = "https://tamut.edu";
	
	@FindBy(xpath = "//a[@title = 'About TAMUT']")
	private WebElement aboutMenu;
	
	@FindBy(linkText = "Visit Us")
	private WebElement visitUsItem;
	
	@FindBy(id = "searchBox")
	private WebElement searchBox;
	
	@FindBy(xpath = "//a[contains(@href, 'computer-science')]")
	private WebElement computerScienceItem;
	
	@FindBy(linkText = "Academics")
	private WebElement academicsItem;
	
	@FindBy(linkText = "Women for A&M-Texarkana")
	private WebElement womenItem;
	
	@FindBy(linkText = "Alumni & Friends")
	private WebElement alumniItem;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void open() {
		driver.get(URL);
	}
	
	public void hoverOverAbout() {
		Actions actions = new Actions(driver);
		actions.moveToElement(aboutMenu).perform();
	}
	
	public void clickVisitUs() {
		visitUsItem.click();
	}
	
	public void searchBox(String searchInput) {
		searchBox.sendKeys(searchInput + Keys.ENTER);
	}
	
	public void clickComputerScience() {
		computerScienceItem.click();
	}
	
	public void clickAcademics() {
		academicsItem.click();
	}
	
	public void clickWomen() {
		womenItem.click();
	}
	
	public void clickAlumni() {
		alumniItem.click();
	}
}
