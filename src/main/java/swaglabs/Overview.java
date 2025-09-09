package swaglabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Overview {
	private WebDriver driver;
	public Overview(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//locators for finish
	@FindBy(id = "finish")
	WebElement finishh;
	
	//locators for backtoproduct
	@FindBy(id = "back-to-products")
	WebElement backhomee;
	
	//function for finish button
	public void finishhclick() {
		finishh.click();
		
	}
	
	//function for backhome button
	public void backhome() {
		backhomee.click();
		
	}

}
