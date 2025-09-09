package swaglabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sidebar {
	private WebDriver driver;
	public Sidebar(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//locator for sidebar
	@FindBy(id = "react-burger-menu-btn")
	WebElement sidebarr;
	
	//locator for logout
	@FindBy(id = "logout_sidebar_link")
	WebElement logout;
	
	//function for sidebar click
	public void sideclk() {
		sidebarr.click();
		
	}
	
	//function for logout click
	public void logoutt() {
		logout.click();
		driver.quit();
	}

}
