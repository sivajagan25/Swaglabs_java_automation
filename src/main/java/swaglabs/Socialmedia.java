package swaglabs;

import static org.testng.Assert.assertEquals;

import java.awt.Window;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Socialmedia {
	private WebDriver driver;
	public Socialmedia(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//locator for twitter link
	@FindBy(partialLinkText = "Twit")
	WebElement twitter;
	
	//locator for facebook link
	@FindBy(linkText  = "Facebook")
	WebElement Facebook;
	
	//locator for Linkedin link
	@FindBy(partialLinkText = "Link")
	WebElement LinkedIn;
	
	//function for facebook page
	
	public void facee() {
		Assert.assertTrue(Facebook.isDisplayed(), "link is not visible on the page");
		Facebook.click();
		System.out.println("link visible");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(driver -> driver.getWindowHandles().size() > 1);
		
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		

		// Switch to the new tab (usually the second one)
		driver.switchTo().window(tabs.get(1));

		// Close the new tab
		driver.close();

		// Switch back to the original tab
		driver.switchTo().window(tabs.get(0));
		
	}
	
	//function for Twitter page
	public void twitt() {
		twitter.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(driver -> driver.getWindowHandles().size() > 1);
		// Wait for the new tab to open (optional:use WebDriverWait if needed)
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

		// Switch to the new tab (usually the second one)
		driver.switchTo().window(tabs.get(1));

		// Assert the URL in the new tab
		String url = driver.getCurrentUrl();
		String expected = "https://twitter.com/saucelabs";
		Assert.assertEquals(url, expected, "URL does not match");
		System.out.println(driver.getCurrentUrl());

		// Close the new tab
		driver.close();

		// Switch back to the original tab
		driver.switchTo().window(tabs.get(0));

	}
	
	//function for Linkedin page
	public void inked() {
		LinkedIn.click();
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

		// Switch to the new tab (usually the second one)
		driver.switchTo().window(tabs.get(1));

		// Close the new tab
		driver.close();

		// Switch back to the original tab
		driver.switchTo().window(tabs.get(0));
		
		
	}

}
