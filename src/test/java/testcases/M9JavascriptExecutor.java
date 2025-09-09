package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class M9JavascriptExecutor {
	WebDriver driver;
	@BeforeClass
	  public void setup() {
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://demoqa.com/text-box");
	  }
	@Test
	public void JSExecutorCommands() throws InterruptedException {
		 JavascriptExecutor js= (JavascriptExecutor) driver;
		 WebElement fullName = driver.findElement(By.cssSelector("input#userName"));
		 WebElement email= null;
		 email = (WebElement) js.executeScript("return document.getElementById('userEmail');",email);
		 String sclassName = js.executeScript("return document.getElementById('userEmail'),getAttribute('class');").toString();
		 By.cssSelector("textarea#currentAddress");
		 By.cssSelector("textarea#permanentAddress");
		 System.out.println("Class Name:" +sclassName);
		 WebElement cAdd= driver.findElement(By.cssSelector("textarea#currentAddress"));
		 WebElement pAdd=driver.findElement(By.cssSelector("textarea#permanentAddress"));
		  WebElement submit=driver.findElement(By.cssSelector("button#submit"));
		  js.executeScript("arguments[0].value='TestUser';", fullName);
		  js.executeScript("arguments[0].value='test@yopmail.com';", email);
		  js.executeScript("arguments[0].scrollIntoView(true);", cAdd);
		  Thread.sleep(2000);
		  js.executeScript("arguments[0].value='India';", cAdd);
		  js.executeScript("arguments[0].value='India';", pAdd);
		  js.executeScript("window.scrollBy(60, 150)");
		  Thread.sleep(2000);
		  js.executeScript("arguments[0].click();", submit);
		  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		  String height=js.executeScript("return window.innerHeight;").toString();
		  String width=js.executeScript("return window.innerWidth;").toString();
		  System.out.println("height: "+height+"\t width: "+width);
		  String title=js.executeScript("return document.title;").toString();
		  System.out.println("Page title is : "+title);
		  String domainName=js.executeScript("return document.domain;").toString();
		  System.out.println("Domain title is : "+domainName);
		  String url=js.executeScript("return document.URL;").toString();
		  System.out.println("URL is : "+url);
		  //changing style attribute
		  js.executeScript("document.getElementById('output').style.borderColor='Red'");
		  Thread.sleep(2000);
		  //navigate to different url
		  js.executeScript("window.location='https://testgrid.io/'");
		  //refresh browser
		  js.executeScript("history.go(0)");
		  //to trigger an alert
		  js.executeScript("alert('This is an alert triggered by JSExecutor!');");
	}
}
