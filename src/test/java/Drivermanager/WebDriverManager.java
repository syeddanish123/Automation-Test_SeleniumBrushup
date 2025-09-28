package Drivermanager;
import org.openqa.selenium.WebDriver;


public class WebDriverManager {

	private static  ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	
	public static void setdriver(WebDriver driverinstance)
	{
		driver.set(driverinstance);
	}
	
	public static  WebDriver getdriver() {
		
		return driver.get();
	}
}
