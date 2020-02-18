package FinanceVal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomeObjects;
import PageObjects.NewsObjects;
import resources.Base;

public class NewsTest extends Base{
	@BeforeTest
	public void init() throws IOException {
		driver = initDriver();
		System.out.println(prop.getProperty("url"));

		driver.get(prop.getProperty("url"));
		
		//get to news page
		HomeObjects ho = new HomeObjects(driver);
		ho.getNews().click();
	}
	
	@Test
	public void checNewsLink() {
		NewsObjects no = new NewsObjects(driver);
		List<WebElement> newsTitles = no.getNewsTitles();
		Actions a = new Actions(driver);
		List<String> newsTS= new ArrayList<String>();
		List<String> newsTSW= new ArrayList<String>();

		for(int i = 0; i< 5 ; i++) {
			newsTS.add(newsTitles.get(i).getText());
			a.keyDown(Keys.CONTROL).click(newsTitles.get(i)).build().perform();;
		}
		
		Set<String> handlers = driver.getWindowHandles();
		
//		Assert.assertTrue(handlers.size()==newsTitles.size());

		
		Iterator<String> it = handlers.iterator();
		it.next();
		
		while(it.hasNext()){
			String window = it.next();
			newsTSW.add(driver.switchTo().window(window).getTitle());		
		}
		System.out.println(newsTS.size());
		System.out.println(newsTSW.size());
		
	}
	
	@AfterTest
	public void terminate() {
		
		driver.quit();
		driver = null;
	}
}
