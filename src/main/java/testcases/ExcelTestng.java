package testcases;
import org.testng.annotations.Test;
import com.utility.Parameterisation;
import SeleniumProject.testing1.LoginPage;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
public class ExcelTestng {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.edge.driver","C:\\Users\\sivajagan.d\\eclipse-workspace\\test\\Resource\\msedgedriver.exe");
		 driver=new EdgeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}
	//@Test
	@DataProvider(name="testData")
	public Object[][] testDataprovider() throws IOException {
		 String filePath="C:\\Users\\sivajagan.d\\Downloads\\Book (1).xlsx";
		 return Parameterisation.readExcelData(filePath,"Sheet1");
	}
  @Test(dataProvider = "testData")
  public void testLogin(String username,String password) {
  LoginPage login=new LoginPage(driver);
	  login.typeusername(username);
	  login.typePassword(password);
	  login.clicksignIn();
  }
}
