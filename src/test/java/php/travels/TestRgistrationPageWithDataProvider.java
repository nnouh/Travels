package php.travels;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRgistrationPageWithDataProvider {
	public WebDriver driver;

	@BeforeClass
	public void openUrl() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://phptravels.net/register/en");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@DataProvider(name="testdata")
	public static Object [][] userData (){
		return new Object[][] {
				{"Nashwa","Nouh","1234567","tx@gmail.com","1234567", "1234567"},
				{"Nouh","Nouh","1234567","yu@gmail.com","1234567", "1234567"}
			
				};
		
	}

	@Test(dataProvider ="testdata")
	public void regTest(String fnam, String lsname,String tel, String eml, String Paswrd, String conpw)
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
