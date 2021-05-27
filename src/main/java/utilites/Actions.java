package utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Actions {
	
  //public static WebDriver driver;

  public static void click(WebDriver driver, By buton) {
	  driver.findElement(buton).click();
	  
  }
  public static void sendText(WebDriver driver ,By elemnt, String text) {
	  driver.findElement(elemnt).sendKeys(text);
	  
	  
  }
	

}
