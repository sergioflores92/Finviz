package FinanceVal;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomeObjects;
import PageObjects.ScreenerObjects;
import junit.framework.Assert;
import resources.Base;

public class ScreenerTest extends Base{


	@BeforeTest
	public void init() throws IOException {
		driver = initDriver();
		System.out.println(prop.getProperty("url"));

		driver.get(prop.getProperty("url"));

	}
	
	@Test
	public void total() {
		// this test that the total number of options that it gives you for the filters is actually
		// the total number of results displayed
		HomeObjects ho = new HomeObjects(driver);
		ho.getScreener().click();
		//log.info(Click on home page on screener tab to test the screener);
		
		ScreenerObjects so = new ScreenerObjects(driver);
		Select sp = new Select(so.getPrice());
		sp.selectByValue("u10");
		//log.info(Successfully selected price value of stocks under 10 dollars);
		
		so.getTechnical().click();
		//log.info(Change to technical tabs to select different parameters);
		
		Select sc = new Select(so.getChange());
		sc.selectByValue("u10");
		//log.info(Successfully selected change value of stocks up 10%);

		String total = so.getTotal().getText();
		List<String> items = Arrays.asList(total.split(" "));
		//log.info("Successfully got the total results of this specific search");

		
		Select sps = new Select(so.getPageSelect());
		sps.selectByIndex(sps.getOptions().size()-1);
		//log.info("Successfully selected last table page, to get last value");
		
		// Assert if value from total is equal to the last of the last element in the table 
		// then my test is correct 
		Assert.assertEquals(items.get(1), so.getLast().getText());


	}
	
	@Test
	public void filterAndValues() {
		HomeObjects ho = new HomeObjects(driver);
		ho.getScreener().click();
		//log.info(Click on home page on screener tab to test the screener);
		
		ScreenerObjects so = new ScreenerObjects(driver);
		Select sp = new Select(so.getPrice());
		sp.selectByValue("u10");
		//log.info(Successfully selected price value of stocks under 10 dollars);
		
		so.getTechnical().click();
		//log.info(Change to technical tabs to select different parameters);
		
		Select sc = new Select(so.getChange());
		sc.selectByValue("u10");
		//log.info(Successfully selected change value of stocks up 10%);
		Select sps = new Select(so.getPageSelect());
		int size = sps.getOptions().size();
		float filteredPrice = 10.0f;
		float filteredChange = 10.0f;

		for(int i = 0 ; i< size ; i++) {
			sps.selectByIndex(i);
			List<WebElement> prices = so.getPrices();
			List<WebElement> changes = so.getChanges();

			for (int j = 1 ; j< prices.size() ; j++) {

				String changeVal = changes.get(j).getText();
				changeVal = changeVal.substring(0, changeVal.length()-1);
				float change = Float.parseFloat(changeVal);
				float price = Float.parseFloat(prices.get(j).getText());
				if(filteredPrice < price || filteredChange > change) {
//					debug.info("this case shouldn't happen, so the filters are not working properly");
				}
				Assert.assertTrue(filteredPrice > price);
//				log.info("this value is under the filtered price");
				Assert.assertTrue(filteredChange < change);
//				log.info("this value is above the filtered change");


			}
		}
	}
	
	@AfterTest
	public void terminate() {
		driver.quit();
		driver = null;
	}
}
