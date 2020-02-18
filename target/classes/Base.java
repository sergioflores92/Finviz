package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {

	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initDriver() throws IOException {
		prop = new Properties();
		String userPath = System.getProperty("user.dir");
		userPath = userPath.replace("\\", "\\\\");
		String browserName = System.getProperty("browser");

		
		FileInputStream fis = new FileInputStream(userPath+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

//		browserName="chrome";
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", userPath+"\\src\\main\\java\\resources\\chromedriver.exe");
			
			if(browserName.equals("chromeHeadless")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				
				driver = new ChromeDriver(options);
			}else {
				System.out.println("chrome successfully initialized, normal mode");
				driver = new ChromeDriver();
			}
			
		}
		else if(browserName.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", userPath+"\\src\\main\\java\\resources\\geckodriver.exe");
			
			if(browserName.equals("firefoxHeadless")) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("headless");
				
				driver = new FirefoxDriver(options);
			}else {
				driver = new FirefoxDriver();
			}
			
		}else {
			//change to log
			System.out.println("no browser argument given, the command is: mvn test -Dbrowser=browser. Browser paramenters are chrome and firefox at the moment");
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}
}
