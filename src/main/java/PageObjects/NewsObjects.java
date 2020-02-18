package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsObjects {

	WebDriver driver;
	
	public NewsObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='news']/table/tbody/tr[2]/td[1]/table/tbody/tr/td[3]/a")
	List<WebElement> newsTitles;
	
	public List<WebElement> getNewsTitles() {
		return newsTitles;
	}

}
