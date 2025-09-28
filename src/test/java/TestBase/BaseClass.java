package TestBase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Drivermanager.WebDriverManager;

public class BaseClass {

	public Properties prop;
	public WebDriver driver;
	public FileInputStream fis;
    public Logger logger;
	private String envUrl="";
    
	@Parameters({"group","browser","execution","env"})
	@BeforeClass(alwaysRun = true)
	public void setup(String name,String browser,String execution,String env) throws Exception {

		driver=new ChromeDriver();
        logger=LogManager.getLogger();
        
        logger.info("Setup Started..");
        
		WebDriverManager.setdriver(driver);
		prop=new Properties();
		fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//data.properties");
		prop.load(fis);
		String url=prop.getProperty("url");
		System.out.println(url);
		
		 if (env.equalsIgnoreCase("qa")) {
	            envUrl = "https://tutorialsninja.com/demo";
	        } else if (env.equalsIgnoreCase("staging")) {
	            envUrl = "https://tutorialsninja.com/demo/";
	        } else {
	            envUrl = "https://tutorialsninja.com/demo/";
	        }
		
		driver.get(envUrl);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

	}


	@AfterClass(alwaysRun = true)
	public void teardown() {

		if(!driver.equals(null))
		{
			driver.quit();
		}
	}
}
