package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.Level;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import TestBase.BaseClass;
import utility.ScreenshotUtility;

public class TestCase01 extends BaseClass {

	@Test(dataProvider="dp2",dataProviderClass=utility.Dataprovider01.class
		 ,groups= {"smoke"})
	public void test001(String m) throws Exception {
		
		logger.info("Test001 started...");
		
		HomePage hp=new HomePage();
		hp.entertext(m);		
		hp.clicksearch();
		
		Thread.sleep(2000);
		hp.cleartextbox();
	}
}
