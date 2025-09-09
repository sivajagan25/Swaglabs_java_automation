package form;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Forms {
		private WebDriver driver;
		public Forms(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
		
		@FindBy(id="name")
		WebElement names;
		
		@FindBy(id="email")
		WebElement emails;
		@FindBy(css = "input[type='radio']")
		List<WebElement> radio;
		
		@FindBy(id="mobile")
		WebElement mobilenumber;
		


		@FindBy(name="subjects")
		WebElement subject;
		@FindBy(css = "input[type='checkbox']")
		List<WebElement> hobbies;
		
		@FindBy(xpath = "//*[@placeholder=\"Currend Address\"]")
		WebElement address;
		
		@FindBy(xpath = "//*[@id=\"dob\"]")
		WebElement dataofbirth;
		@FindBy(id="picture")
		WebElement pic;
		
		@FindBy(xpath = "//*[@id=\"state\"]")
		WebElement dw;
		
		
		@FindBy(xpath = "//*[@id=\"city\"]")
		WebElement city;
		
		@FindBy(css = ".btn.btn-primary")
		WebElement loginbutton;
		
		public void sendkeyss(String n,String e) {
			
			names.sendKeys(n);
			emails.sendKeys(e);
			
			//loginbutton.click();
		}
			
public void belowradio(String m,String s,String a,String dobb,String dob,String d) {
			


			// Scroll into view
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView(true);", loginbutton);
//
//			// Wait and click using JS to avoid interception
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.elementToBeClickable(loginbutton));
//			js.executeScript("arguments[0].click();", loginbutton);

//			    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//				wait.until(ExpectedConditions.elementToBeClickable(loginbutton));
//				
//				JavascriptExecutor js =(JavascriptExecutor) driver;
//				js.executeScript("arguments[0].scrollIntoView(true);",loginbutton);
//				loginbutton.click();
			
			mobilenumber.sendKeys(m);
			subject.sendKeys(s);
			address.sendKeys(a);
			dataofbirth.sendKeys(dobb);
			dataofbirth.sendKeys(dob);
			dataofbirth.sendKeys(d);
			//loginbutton.click();
		}
		public void ratiobutton() {
		    // Select radio button with value "Male"

        

			for (WebElement radios : radio) {
					if (!radios.isSelected()) {
						radios.click();
    }
}
}
		public void checkboxx() {
			for(WebElement ck:hobbies) {
				ck.click();
				
			}
		}
		
public void piccc(String picc) {
			
			pic.sendKeys(picc);
			
			
		}
			public void down() {
				Select sct=new Select(dw);
				List<WebElement> option=sct.getOptions();
				for(int i=0;i<option.size();i++) {
					sct.selectByIndex(i);
					
				}
				
			}
			
			public void cityy() {
				Select sct=new Select(city);
				List<WebElement> option=sct.getOptions();
				for(int i=0;i<option.size();i++) {
					sct.selectByIndex(i);
					
				}
				
			}
			
			
			
		}
		
		

