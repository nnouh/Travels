package php.travels;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Link;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilites.SpreedSheet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class TestRgistrationPage {
	public WebDriver driver;
	Properties prop;


	@BeforeClass
	public void openUrl() throws IOException {
		prop = new Properties();
		prop.load(new FileReader("resourcse/config.properties"));
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}



	@Test
	@Description("test for registration from group 2")
	@Link("www.google.com")
	public void regTest()
	{

		String fileName = "resourcse/signup.xlsx";
		var spreadsheet = new SpreedSheet(new File(fileName));
		spreadsheet.switchToSheets("user2");
		int row = 1;
		String firstname = spreadsheet.GetCellData("fnam",row);
		String lastName = spreadsheet.GetCellData("lsname",row);
		String telephone = spreadsheet.GetCellData("tel",row);
		String mail = spreadsheet.GetCellData("email",row);
		String password = spreadsheet.GetCellData("Password",row);
		String repassword = spreadsheet.GetCellData("repassword",row);

		RegistrationClass regObj = new RegistrationClass(driver);
		regObj.registration(firstname, lastName, telephone, mail,password,repassword);
		Assert.assertEquals(regObj.getResultText(), "Hi," + " " + firstname + " "+ lastName);
	}

	@AfterClass
	public void close() {
		driver.close();
	}

}
