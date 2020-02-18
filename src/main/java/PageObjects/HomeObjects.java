package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeObjects {

	WebDriver driver;
		
	public HomeObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Screener']")
	WebElement screener;
	
	@FindBy(xpath="//a[text()='News']")
	WebElement news;
	
	@FindBy(css="#search > div > form > input[type=text]")
	WebElement searchBox;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement login;
	

	public WebElement getScreener() {
		return screener;
	}

	public WebElement getNews() {
		// TODO Auto-generated method stub
		return news;
	}

	public WebElement getSearchBox() {
		// TODO Auto-generated method stub
		return searchBox;
	}

	public WebElement getLogin() {
		// TODO Auto-generated method stub
		return login;
	}
	
}
