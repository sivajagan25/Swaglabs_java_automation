package swaglabs;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Yourinformation {
	private WebDriver driver;
	public Yourinformation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//locators for firstname 
	
	@FindBy(id = "first-name")
	WebElement firstname;
	
	//locators for lastname 
	@FindBy(id = "last-name")
	WebElement lastname;
	
	//locators for postalcode 
	@FindBy(id = "postal-code")
	WebElement postalcode;
	
	//locators for contine button  
	@FindBy(id = "continue")
	WebElement con;
	
	//function for firstname
	public void fname(String fnamee) {
		firstname.sendKeys(fnamee);
		
	}
	
	//function for postal code
	public void postal(String postall) {
		postalcode.sendKeys(postall);
		
	}
	//function for lastname
	public void lname(String lnamee) {
		lastname.sendKeys(lnamee);
		
	}
	//function for continue button
	public void continueee() {
		con.click();
		
	}
	
	//function for screenshot
	
	public void screen() {	
	File src =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	File des = new File("src/test/resources/Screenshot/screenshot.png");
	try {
            FileUtils.copyFile(src, des);
            System.out.println("Screenshot saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
}	
}
