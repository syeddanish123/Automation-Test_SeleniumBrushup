package TestCases;

import org.apache.logging.log4j.Level;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.SearchPage;
import TestBase.BaseClass;

public class TestCase02 extends BaseClass {

	@Test(groups= {"sanity"})
	public void iphone_addcart_StatusCheck() {
		
		logger.info("Test002 started...");
		
		HomePage hp=new HomePage();
		hp.entertext("iphone");
		hp.clicksearch();
		
		SearchPage sp=new SearchPage();
		sp.clickIphone();
		sp.clickAddtoCart();
		sp.clickCart();
		sp.clickCheckout();
		
		System.out.println(sp.getText());
	}
}
