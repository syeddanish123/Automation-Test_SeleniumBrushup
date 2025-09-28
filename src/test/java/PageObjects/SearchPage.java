package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TestBase.BasePage;

public class SearchPage extends BasePage {

	public SearchPage()
	{
		super();
	}
	
  @FindBy(xpath="//img[@title='iPhone']")
  WebElement link_iphone;
  
  @FindBy(xpath="//button[text()='Add to Cart']")
  WebElement link_addtocart;
  
  @FindBy(xpath="//div[@id='cart']/button")
  WebElement link_cart;
  
  @FindBy(xpath="//strong[normalize-space()='Checkout']")
  WebElement link_checkout;
  
  @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
  WebElement link_Text;
  
 public void clickIphone() {
	 
	 link_iphone.click();
 }
 
 public void clickAddtoCart() {
	 
	 link_addtocart.click();
 }
 
 public void clickCheckout() {
	 
	 link_checkout.click();
 }
 
 public String getText() {
	 
	return link_Text.getText();
 }
 
public void clickCart() {
	
	link_cart.click();
}
}
