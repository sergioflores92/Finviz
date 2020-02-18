package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuoteObjects {

	WebDriver driver;
	
	public QuoteObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/table[3]/tbody/tr[1]/td/table/tbody/tr[7]/td/table/tbody/tr[11]/td[12]")
	WebElement price;
	
	public WebElement getQuotePrice() {
		return price;
	}
}
