package php.travels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;



public class TestRgistrationPage {
	public WebDriver driver;
	String fnam = "Nashwa";
	String lsname = "Nouh";
	String tel = "123456";
	String eml = "d4@gmail.com";
	String Paswrd= "1234567"; 
	String conpw = "1234567";

	@BeforeClass
	public void openUrl() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://phptravels.net/register/en");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}



	@Test
	public void regTest()
	{
		RegistrationClass regObj = new RegistrationClass(driver);
		regObj.registration(fnam, lsname, tel, eml,Paswrd,conpw);
		Assert.assertEquals(regObj.getResultText(), "Hi," + " " + fnam + " "+ lsname);
	}

	@AfterClass
	public void close() {
		driver.close();
	}

}
