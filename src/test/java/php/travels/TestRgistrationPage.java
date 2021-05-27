package php.travels;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRgistrationPage {
	public WebDriver driver;
  @BeforeClass
  public void openUrl() {
	  WebDriverManager.chromedriver().setup();
	  driver= new ChromeDriver();
	  driver.navigate().to("https://phptravels.net/register/en");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
	  
  }
  @Test
  public void regTest(){
	  RegistrationClass regObj =new RegistrationClass(driver);
	  regObj.registration("nashwa", "Noh", "12345", "uuw@gmail.com", "1234566", "1234566");
	 	Assert.assertEquals(regObj.getResultText(), "Hi, nashwa Noh");
  }
  
  
}
