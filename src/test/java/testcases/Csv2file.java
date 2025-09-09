package testcases;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.BeforeTest;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class Csv2file {
  
  WebDriver driver;
  //String bookurl="\\C:\\Users\\sivajagan.d\\OneDrive - HCL TECHNOLOGIES LIMITED\\Documents\\sample_keywords.csv";
  
  //String bookurl = "C:\\Users\\sivajagan.d\\OneDrive - HCL TECHNOLOGIES LIMITED\\Documents\\sample_keywords.csv";

  @Test
  public void f() {
	  //CSVReader reader=new CSVReader("C:\\Users\\sivajagan.d\\eclipse-workspace\\testing1\\src\\test\\resources/Book.xlsx");
	  CSVReader reader=null;
	  
	  try {
		
			reader=new CSVReader(new FileReader("\\C:\\Users\\sivajagan.d\\OneDrive - HCL TECHNOLOGIES LIMITED\\Documents\\sample_keywords.csv"));
			String[] cell;
			while((cell=reader.readNext())!=null) {
			  String keyword=cell[0];
			  driver.findElement(By.id("APjFqb")).sendKeys(keyword);
			  System.out.println("sys enter search keyword");
			  Thread.sleep(30);
			  driver.findElement(By.id("APjFqb")).clear();
			  System.out.println("sys clear search keyword");
			  
		  }
	} catch (CsvValidationException | IOException |InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	  }
  @BeforeTest
  
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\sivajagan.d\\eclipse-workspace\\test\\Resource\\ChromeDrive\\chromedriver-win64\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://www.google.com/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
		 }

  @AfterTest
  public void afterTest() {
	  System.out.println("completed");
	  driver.quit();
  }

}

