package pages;

import java.net.http.WebSocket;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pagefactoryprofile {
	final WebDriver driver;
	public Pagefactoryprofile(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindAll({
		@FindBy(className = "form-label"),
		@FindBy(id="userName-value")
	
	})
	WebElement user;
	@FindBy(xpath= "(//button[normalize-space()='Log out'])[1]")
	WebElement logoutBtn;
	public void verifUser(String usrNm) {
		if(user.getText().equalsIgnoreCase(usrNm)){
			System.out.println("correct username:"+user.getText());
			}
		else {
			System.out.println("Incorrect username"+user.getText());
		}
	}
		public void logout_Action() {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
			
			JavascriptExecutor js =(JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);",logoutBtn);
			logoutBtn.click();
			System.out.println("Log off successfully");
			
		}
		
	

}
