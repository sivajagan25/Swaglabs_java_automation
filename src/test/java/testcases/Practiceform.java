package testcases;

import java.text.Normalizer.Form;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import form.Forms;



public class Practiceform {
	 WebDriver driver;
	@BeforeClass
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sivajagan.d\\eclipse-workspace\\test\\Resource\\ChromeDrive\\chromedriver-win64\\chromedriver.exe");
		 driver=new ChromeDriver();
		 
		 driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		 driver.manage().window().maximize();
	}
  @Test
  public void f() {
	  Forms aa=new Forms(driver);
	  aa.sendkeyss("jaganjagan", "sivajagan@gmail.com");
	  aa.belowradio("1234","wertyuiojhg","qwdfgh","May","10","2009");
	  aa.ratiobutton();
	  aa.checkboxx();
	  aa.piccc("C:\\Users\\sivajagan.d\\OneDrive - HCL TECHNOLOGIES LIMITED\\Desktop\\Hcl bgv");
	  aa.down();
	  aa.cityy();
  }
}
