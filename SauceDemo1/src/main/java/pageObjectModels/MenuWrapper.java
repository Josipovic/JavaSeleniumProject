package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuWrapper {
	
	private static WebElement element;

	public WebElement wpMenuWrapper(WebDriver driver) 
	{
		return element=driver.findElement(By.xpath("//div[@class='bm-menu']"));
	}
	
	public WebElement linkAllItems(WebDriver driver) 
	{
		return element=driver.findElement(By.id("inventory_sidebar_link"));
	}
	
	public WebElement linkAbout(WebDriver driver) 
	{
		return element=driver.findElement(By.id("about_sidebar_link"));
	}
	
	public WebElement linkLogout(WebDriver driver) 
	{
		return element=driver.findElement(By.id("logout_sidebar_link"));
	}
	
	public WebElement linkResetAppState(WebDriver driver) 
	{
		return element=driver.findElement(By.id("reset_sidebar_link"));
	}
	
}
