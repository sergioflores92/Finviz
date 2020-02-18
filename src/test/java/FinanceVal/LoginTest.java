package FinanceVal;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomeObjects;
import PageObjects.LoginObjects;
import resources.Base;

public class LoginTest extends Base{

	@BeforeTest
	public void init() throws IOException {
		driver = initDriver();
	}
	
	@Test(dataProvider="getUsers")
	public void testLogin(String username, String password) {
		driver.get(prop.getProperty("url"));
		
		//get to login page
		HomeObjects ho = new HomeObjects(driver);
		ho.getLogin().click();
		
		LoginObjects lo = new LoginObjects(driver);
		lo.getEmail().sendKeys(username);
		
		lo.getPassword().sendKeys(password);
		
		lo.getLogin().click();
	}
	
	
	
	@DataProvider
	public Object[][] getUsers(){
		//this data provider passes the data to test
		//at the time passes to diferent usernames and their passwords
		Object[][] data =  {{"Matameromas","123456"},
							{"MiniLicwxyz","997068"}};
		
		return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;

	}
}
