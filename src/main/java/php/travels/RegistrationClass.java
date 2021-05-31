package php.travels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilites.Actions;

public class RegistrationClass {
	WebDriver driver;

	public RegistrationClass(WebDriver driver) {

		this.driver = driver;
		// String resultIndex;

	}

	private By firstName = By.xpath("//input[@name='firstname']");
	private By secondName = By.xpath("//input[@name='lastname']");
	private By phone = By.xpath("//input[@name='phone']");
	private By email = By.name("email");
	private By passWord = By.name("password");
	private By confPw = By.name("confirmpassword");
	private By cookies = By.xpath("//button[@class='cc-btn cc-dismiss']");
	private By signUp = By.xpath("//button[contains(.,'Sign Up')]");
	private By welcomeText = By.xpath("//h3[@class='text-align-left']");

	public void registration(String Nam, String lnam, String phon, String eml, String pw, String cpw) {
		Actions.sendText(driver, firstName, Nam);
		Actions.sendText(driver, secondName, lnam);
		Actions.sendText(driver, phone, phon);
		Actions.sendText(driver, email, eml);
		Actions.sendText(driver, passWord, pw);
		Actions.sendText(driver, confPw, cpw);
		Actions.click(driver, cookies);
		Actions.click(driver, signUp);
	}

	public String getResultText() {
		return driver.findElement(welcomeText).getText();
	}

}
