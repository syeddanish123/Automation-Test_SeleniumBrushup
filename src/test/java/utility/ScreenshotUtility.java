package utility;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Drivermanager.WebDriverManager;

public class ScreenshotUtility {

   public static TakesScreenshot ts;
   public WebDriver driver;
   
   public static String takeScreenshot(String Name) throws IOException {
	   
	  SimpleDateFormat sdf=new SimpleDateFormat("YY.MM.DD.hh.mm.ss"); 
	  Date dt=new Date();
	  sdf.format(dt);
	  
	  WebDriver driver=WebDriverManager.getdriver();
	  ts=(TakesScreenshot)driver;
	  
	 File source=ts.getScreenshotAs(OutputType.FILE);
	 String target=System.getProperty("user.dir")+"//Screenshot//Name+ screenshot"+dt.getTime()+".png";
   
     FileUtils.copyFile(source,new File(target));
     
     return target;
   }
	
}
