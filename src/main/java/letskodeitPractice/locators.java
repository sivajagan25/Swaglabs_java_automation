package letskodeitPractice;

import java.awt.Desktop.Action;
import java.lang.foreign.Linker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class locators {
	
	 WebDriver driver;
	public locators(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//locators for radio button 
	@FindBy(name = "cars")
	List<WebElement> bmw;
	
	//locators for checkbox
	@FindBy(id = "bmwcheck")
	WebElement bmwchk;
	//locators for open new window
	@FindBy(id = "openwindow")
	WebElement openwin;
	//locators for open new tab
		@FindBy(id = "opentab")
		WebElement opntab;
		//locators for dropdown
		@FindBy(xpath = "*//select[@id='carselect']")
		WebElement dropp;
		
		//locators for multiple select
		@FindBy(xpath = "//select[@id='multiple-select-example']")
		WebElement multi;
		
		//locators for auto suggest
		@FindBy(id = "autosuggest")
		WebElement auto;
		
		//locators for altertext
		@FindBy(id = "name")
		WebElement altertext;
		//locators for alterbtn
		@FindBy(id = "alertbtn")
		WebElement alterbtn;
		//mouse hover
		@FindBy(id = "mousehover")
		WebElement mh;
		//suboption mouse hover
		@FindBy(xpath = "//div[@class='mouse-hover-content']")
		WebElement submh;
	
	//methods for locators radio button 
	public void ratiobtnn() {
		
		System.out.println(bmw.size());
		for (WebElement btn:bmw){
//			String ele=btn.getText();
//			System.out.println(ele);
			btn.click();
		}
	}
		
		//methods for locators checkbox
		public void checkboxx() {
			List<WebElement>ckbox=driver.findElements(By.xpath("input[@type='checkbox' and @name='cars' ]"));
			//System.out.println(rbtn.size());
			for (WebElement ckbtn:ckbox){
				String ele=ckbtn.getText();
				System.out.println(ele);
				ckbtn.click();
				
			}		
	}
		
		
		//method for handle for openning the tab
		public void opentabbb() {
			String parentWindow = driver.getWindowHandle();
			Set<String> allwin=driver.getWindowHandles();
			for(String winhandel:allwin) {
			if(!winhandel.equals(parentWindow)) {
				driver.switchTo().window(winhandel);
				
				driver.close();
				driver.switchTo().window(parentWindow);
				
			}
			}
		}
		//method for checkboxx
		public void openwinn() {
			openwin.click();
			opentabbb();
			
			}
		
		public void opennewtab() {
			opntab.click();
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

			// Switch to the new tab (usually the second one)
			driver.switchTo().window(tabs.get(1));
			
			 //System.out.println("Switched to new tab: " + driver.getCurrentUrl());

			// Close the new tab
			driver.close();

			// Switch back to the original tab
			driver.switchTo().window(tabs.get(0));
			
			
		}
		
		
		//method for dropdown
		public void drop() {
			Select s=new Select(dropp);
			List<WebElement>opt=s.getOptions();
			for(int i=0;i<opt.size();i++) {
			System.out.println(opt.get(i).getText());		
				s.selectByIndex(i);
			}
			
			
		}
		
		//method for multiple select
				public void multii() {
					Select s=new Select(multi);
					List<WebElement>opt=s.getOptions();
					for(int i=0;i<opt.size();i++) {
					System.out.println(opt.get(i).getText());		
						s.selectByIndex(i);
					}
					
					
				}
				
				public void autosuggest() {
					auto.sendKeys("java");
				}
				
				public void alterr() {
					altertext.sendKeys("jagan");
					System.out.println("inside");
					alterbtn.click();
					
					driver.switchTo().alert().accept();
					
					
					
				}
				//Action for mouse hover
				public void hover() throws InterruptedException {
					List<WebElement>sub=driver.findElements(By.xpath("//div[@class='mouse-hover-content']"));
					
						Actions actions =new Actions(driver);
						//System.out.println(hoverr.getText());
						actions.moveToElement(mh).perform();
						for(WebElement hoverr:sub) {
							System.out.println(hoverr.getText());
							hoverr.click();
							Thread.sleep(5000);
							
						}
				
					
				}
				
		
		
		

			
		}
		
		


