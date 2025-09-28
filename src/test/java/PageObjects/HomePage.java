package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TestBase.BasePage;

public class HomePage extends BasePage {

	public HomePage(){
		
		super();
	}
	
 @FindBy(xpath="//input[@name='search']")
 WebElement link_searchbox;
 
 @FindBy(xpath="//div[@id='search']//button")
 WebElement link_clicksearch;
 
 @FindBy(xpath="//input[@name='search']")
 WebElement link_clrsearchbox;
 
 public void entertext(String msg) {
	 
	 link_searchbox.sendKeys(msg);
	 
 }
 
 public void clicksearch() {
	 
	 link_clicksearch.click();
 }
 
 public void cleartextbox() {
	 
	link_clrsearchbox.clear();
	 
 }
}
