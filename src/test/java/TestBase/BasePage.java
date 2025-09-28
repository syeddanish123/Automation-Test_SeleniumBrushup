package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Drivermanager.WebDriverManager;

public class BasePage {

	WebDriver driver;
	
	public BasePage() {
		
		this.driver=WebDriverManager.getdriver();
		PageFactory.initElements(driver,this);
	}
}
