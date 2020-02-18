package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObjects {
	
	WebDriver driver ;
	
	public LoginObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='button is-primary is-large']")
	WebElement login;
	
	public WebElement getEmail() {
		return email;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getLogin() {
		return login;
	}
}
