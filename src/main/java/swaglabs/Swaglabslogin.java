package swaglabs;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import swaglabs.Reportslog;

public class Swaglabslogin {
	private WebDriver driver;
	public Swaglabslogin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
		
	
	//locator for username
	@FindBy(id="user-name")
	WebElement username;
	
	//locator for password
	@FindBy(id="password")
	WebElement pwd;
	
	//locator for login button
	@FindBy(id="login-button")
	WebElement loginbtn;
	public void loginpage(String user,String password) {
		username.clear();
		
		username.sendKeys(user);
		pwd.clear();
		pwd.sendKeys(password);
		
		loginbtn.click();

//try {
//            driver.switchTo().alert().accept(); // Accept the alert
//            System.out.println("Alert accepted successfully.");
//        } catch (Exception e) {
//            System.out.println("No alert present after clicking the product.");
//        }

		
	}
}

