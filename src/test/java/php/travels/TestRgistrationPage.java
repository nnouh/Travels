package php.travels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilites.SpreedSheet;

import java.io.File;
import java.util.concurrent.TimeUnit;



public class TestRgistrationPage {
	public WebDriver driver;

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
		String fileName = "resourcse/signup.xlsx";
		var spreadsheet = new SpreedSheet(new File(fileName));
		spreadsheet.switchToSheets("user1");
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
