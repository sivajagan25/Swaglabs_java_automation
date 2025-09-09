package swaglabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cartpage {
	private WebDriver driver;
	public Cartpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//locators for shopping cart link 
	@FindBy(className = "shopping_cart_link")
	WebElement cartpagee;
	
	//locators for checkout
	@FindBy(id = "checkout")
	WebElement checkout;
	
	//function for cart page
	public void cartpageee() {
		cartpagee.click();
		
	}
	//function for checkout
	public void checkoutt() {
		checkout.click();
		
	}

}
