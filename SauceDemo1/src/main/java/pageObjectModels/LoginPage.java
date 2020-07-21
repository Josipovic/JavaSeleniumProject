package pageObjectModels;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.BaseClass;

public class LoginPage extends BaseClass {
	

	//public static WebDriver driver;
	private static WebElement element;
    
	
	
	public  WebElement txtUsername(WebDriver driver) {
		
		return element=driver.findElement(By.id("user-name"));
	}
	
	public WebElement txtPassword(WebDriver driver) {
		return element=driver.findElement(By.id("password"));

	}
	
	public WebElement btnLogin(WebDriver driver) {
		return element=driver.findElement(By.id("login-button"));

	}

	
	
	public void Login(WebDriver driver1) throws Exception {
		
		txtUsername(driver1).sendKeys(prop.getProperty("username"));
		VerifyText(txtUsername(driver1),prop.getProperty("username"));
		txtPassword(driver1).sendKeys(prop.getProperty("password"));
		VerifyText(txtPassword(driver1),prop.getProperty("password"));
		btnLogin(driver1).click();
		
	}
	
	private void VerifyText(WebElement element,String sText) throws Exception {
		   if(element.getAttribute("value").equals(sText)) {
			   System.out.println(element + " :Contains corresponding text.");
		   }
		   else {
			   throw new Exception(element + ": Doesn't contain corresponding text.");
		   }
	   }
	
}
