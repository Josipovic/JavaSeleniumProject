package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {

	private static WebElement element;
	
	public WebElement listCartList(WebDriver driver) {
		return element=driver.findElement(By.className("cart_list"));
	}
	
	public WebElement tileCartItem(WebDriver driver) {
		return element=driver.findElement(By.className("cart_item"));
	}
	
	
	public WebElement labelCartQuantity(WebDriver driver) {
		return element=driver.findElement(By.className("cart_quantity_label"));
	}
	
	public WebElement labelCartDesc(WebDriver driver) {
		return element=driver.findElement(By.className("cart_desc_label"));
	}
	
	public WebElement labelItemQuantity(WebDriver driver) {
		return element=driver.findElement(By.className("cart_quantity"));
	}
	
	public WebElement labelInventoryItemName(WebDriver driver) {
		return element=driver.findElement(By.className("inventory_item_name"));
	}
	
	public WebElement labelInventoryItemPrice(WebDriver driver) {
		return element=driver.findElement(By.className("inventory_item_price"));
	}
	
	public WebElement btnRemove(WebDriver driver) {
		return element=driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[1]/div[3]/div[2]/div[2]/button"));
	}
	
	public WebElement btnContinueShopping(WebDriver driver) {
		return element=driver.findElement(By.className("btn_secondary"));
	}
	
	public WebElement btnCheckOut(WebDriver driver) {
		return element=driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/a[2]"));
	}
	
	
	
}
