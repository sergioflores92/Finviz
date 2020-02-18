package FinanceVal;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomeObjects;
import PageObjects.QuoteObjects;
import resources.Base;

public class SearchBoxTest extends Base{
	
	@BeforeTest
	public void init() throws IOException {
		driver = initDriver();
		System.out.println(prop.getProperty("url"));

		driver.get(prop.getProperty("url"));

	}
	
	@Test(dataProvider="sendQuotes")
	public void verifySearchBoxResults(String quote, String price) {

		HomeObjects ho = new HomeObjects(driver);
		
		Actions a = new Actions(driver);
		a.click(ho.getSearchBox()).sendKeys(quote).sendKeys(Keys.ENTER).build().perform();
		
		QuoteObjects qo = new QuoteObjects(driver);		
		Assert.assertEquals(qo.getQuotePrice().getText(), price);
		
		
	}
	
	@DataProvider
	public Object[][] sendQuotes() {
		Object[][] stocks = {{"AMZN","2134.87"},
							 {"AAPL","324.95"},
							 {"TSLA","800.03"},
							 {"INTC","67.27"},
							 {"NVDA","289.79"},};
		return stocks;
	}
	
	@AfterTest
	public void terminate() {
		driver.close();
		driver = null;
	}
}
