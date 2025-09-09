package swaglabs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductPage {
	private WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//locators for product click
	@FindBy(className = "inventory_item_name")
	WebElement productclk;
	
	//locators for product link click
	@FindBy(id = "item_4_title_link")
	WebElement productlink;
	
	//locators for Add to cart button 
	@FindBy(id = "add-to-cart")
	WebElement addtobtnproduct;
	
	//locators for All Add to cart button 
	@FindBy(xpath= "//button[text()='Add to cart']")
	List<WebElement> addtocartbtn;
	
	//locators for remove button 
	@FindBy(xpath = "//*[@id='remove']")
	WebElement productpageremove;
	
	
	//locators for back to click
	@FindBy(id="back-to-products")
	WebElement back;
	
	//locators for All remove button
	@FindBy(xpath = "//button[text()='Remove']")
	List<WebElement>remove;
	
	//locators for Filter 
	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select")
	WebElement filter;
	
	//function for All Add to cart  button
	public void addtocartbtnn() {
		//List<WebElement>pp=driver.findElements((By.className(addtocartbtn));
		for(WebElement clk:addtocartbtn) {
			Assert.assertTrue(clk.isDisplayed(), "Button is not visible on the page");
			System.out.println("visible");
			clk.click();
			
		}
		
	}
	
	//function for All remove button to be click
	public void clickremove()  {
		//List<WebElement>pp=driver.findElements((By.className(addtocartbtn));
		for(WebElement clkrem:remove) {
			
			clkrem.click();
			
		}
		
	}
	
	//function for product click
	public void prductlink() {
		
		//Assert.assertEquals(true,isD);
		productlink.click();
		
	}
	//function for backproduct button click
	
	public void backproduct() {
		back.click();
		
	}
	
	//function for remove button click
	public void remove() {
		productpageremove.click();
	}
	
	//function for Dropdown options click
	public void dropdown() {
		Select select=new Select(filter);
		List<WebElement>option=select.getOptions();
		
		
		for(int i=0;i<option.size();i++) {

			//System.out.println(i);
			//System.out.println(option.get(i).getText());  
			select.selectByIndex(i);
			 
			
		}
		
	}
	
		

}
