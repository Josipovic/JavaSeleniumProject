package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private static WebElement element;

	public WebElement btnMenu(WebDriver driver) 
	{
		return element=driver.findElement(By.xpath("//div[@class='bm-burger-button']"));
	}
	
	
	public WebElement btnShoppingCart(WebDriver driver)
	{
		return element=driver.findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']"));
	}
	
	public WebElement ddlSortProducts(WebDriver driver)
	{
		return element=driver.findElement(By.xpath("//select[@class='product_sort_container']"));
	}
	
	public WebElement labelProducts(WebDriver driver) {
		
		return element=driver.findElement(By.xpath("//div[@class='product_label']"));
	}
	
	public WebElement listInventorylist(WebDriver driver) {
		return element=driver.findElement(By.xpath("//div[@class='inventory_list']"));
	}
	
	public WebElement tileInventoryItem(WebDriver driver) {
		return element=driver.findElement(By.xpath("//div[@class='inventory_item']"));
	}
	
	public WebElement imgInventoryItem(WebDriver driver) {
		return element=driver.findElement(By.xpath("//div[@class='inventory_item_img']"));
	}
	
	public WebElement labelInventoryItemName(WebDriver driver) {
		return element=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
	}
	
	public WebElement labelInventoryItemPrice(WebDriver driver) {
		return element=driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
	}
	
	public WebElement btnAddToCart(WebDriver driver)
	{
		return element=driver.findElement(By.xpath("//button[@class='btn_primary btn_inventory']"));
	}
	
	

	
}
