package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScreenerObjects {

	WebDriver driver;
	
	public ScreenerObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="fs_sh_price")
	WebElement price;
	
	@FindBy(xpath="//*[contains(text(),'Technical')]")
	WebElement technical;
	
	@FindBy(id="fs_ta_change")
	WebElement change;
	
	@FindBy(xpath="//*[@id='screener-content']/table/tbody/tr[3]/td/table/tbody/tr/td")
	WebElement total;
	
	@FindBy(id="pageSelect")
	WebElement pageSelect;
	
	@FindBy(xpath="//*[@id='screener-content']/table/tbody/tr[4]/td/table/tbody/tr/td[1]")
	List<WebElement> rows;
	
	@FindBy(xpath="//*[@id='screener-content']/table/tbody/tr[4]/td/table/tbody/tr/td[9]")
	List<WebElement> prices;
	
	@FindBy(xpath="//*[@id='screener-content']/table/tbody/tr[4]/td/table/tbody/tr/td[10]")
	List<WebElement> changes;
	
	private WebElement last;
	
	public WebElement getPrice() {
		return price;
	}
	
	public WebElement getTechnical() {
		return technical;
	}
	
	public WebElement getChange() {
		return change;
	}
	
	public WebElement getTotal() {
		return total;
	}
	
	public WebElement getPageSelect() {
		return pageSelect;
	}
	
	public WebElement getLast() {
		last = rows.get(rows.size()-1);
		return last;
	}
	public List<WebElement> getPrices() {
		return prices;
	}
	public List<WebElement> getChanges() {
		return changes;
	}
}
