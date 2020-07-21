package methods;



import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjectModels.HomePage;

public class Methods {
	HomePage hp =new HomePage();
	
	public void EnabledAndDisplayed(WebElement element) throws Exception {
		 {
			if(element.isEnabled() && element.isDisplayed()) {
				
				System.out.println(element + ": Is enabled and displayed.");
			}
		    if(!element.isEnabled()) {
		    	throw new Exception ("Element is not enabled.");
			}
		    if(!element.isDisplayed()) {
		    	
		    	throw new Exception ("Element is not displayed.");

		    }
		}
	
		
		
	}
	public void Enabled(WebElement element,boolean enabled) throws Exception {
		
		if(enabled && element.isEnabled()) {
			System.out.println(element + ": Is enabled.");
		}
		if(!enabled && !element.isEnabled())
		{
			System.out.println(element + ": Is not enabled.");

		}
		
		if(enabled && !element.isEnabled()) {
		
			throw new Exception ("Enabled:" + enabled +  " Element is not enabled.");
		}
		if(!enabled && element.isEnabled()) {
			throw new Exception ("Enabled:" + enabled +  " Element is enabled.");

		}
	}

   public void Displayed(WebElement element,boolean displayed) throws Exception {
	   if(displayed && element.isDisplayed()) {
			System.out.println(element + ": Is displayed.");
		}
		if(!displayed && !element.isDisplayed())
		{
			System.out.println(element + ": Is not displayed.");

		}
		if(displayed && !element.isDisplayed()) {
			
			throw new Exception ("Enabled:" + displayed +  " Element is not enabled.");
		}
		if(!displayed && element.isDisplayed()) {
			throw new Exception ("Enabled:" + displayed +  " Element is enabled.");

		}
   }
   
   public void ddlVerifyText(WebElement element,String text) throws Exception {
	   Select select=new Select(element);
	   WebElement First=select.getFirstSelectedOption();
	   String sFirst=First.getText();
	   if(sFirst.equals(text)) {
		   System.out.println(element + " contains corresponding text :" + text);
		   System.out.println(element.getText());
	   }
	   else {
		   throw new Exception(element +  text + " Element does not contain corresponding text.");
	   }
   }
   
   public void WaitForElementToBecomeVisible(WebDriver driver,WebElement element,int time) {
	   
	   WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
   }
   
   public boolean Find(WebElement element) {
	    boolean result = false;
	    int attempts = 0;
	    while(attempts < 10) {
	        try {
	           element.click();
	            result = true;
	            break;
	        } catch(StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    return result;
	}
   
   public int GetRowCountInInventoryList(WebDriver driver) {
	   
	   List<WebElement> lsRows=driver.findElements(By.xpath("//div[@class='inventory_item']"));
	   return lsRows.size();
   }
   
   public void addItems(WebDriver driver, String itemWanted1, String itemWanted2) throws Exception {
       List<WebElement> items = hp.listInventorylist(driver).findElements(By.className("inventory_item"));

             items.forEach(item -> {
           String itemName = item.findElement(By.className("inventory_item_name")).getText();
           WebElement button = item.findElement(By.className("btn_inventory"));
           if (itemName.toLowerCase().equals(itemWanted1.toLowerCase())
                   || itemName.toLowerCase().equals(itemWanted2.toLowerCase())) {
               button.click();
               button.getText();
               if (button.getText().equals("REMOVE")) {
                   System.out.println("Button contains corresponding text");
               } else {
                   
            	   throw new java.lang.IllegalArgumentException("Button does not contain corresponding string");
               }
           }
       });
   }
   public void addItem(WebDriver driver, String sItemName, String sItemPrice) throws Exception {
       List<WebElement> items = hp.listInventorylist(driver).findElements(By.className("inventory_item"));

             items.forEach(item -> {
           String itemName = item.findElement(By.className("inventory_item_name")).getText();
           String itemPrice=item.findElement(By.className("inventory_item_price")).getText();
           WebElement button = item.findElement(By.className("btn_inventory"));
           if (itemName.toLowerCase().equals(sItemName.toLowerCase())
                   && itemPrice.toLowerCase().equals(sItemPrice.toLowerCase())) {
               button.click();
               button.getText();
               if (button.getText().equals("REMOVE")) {
                   System.out.println("Button contains corresponding text");
               } else {
                   
            	   throw new java.lang.IllegalArgumentException("Button does not contain corresponding string");
               }
           }
       });
   }
   
   public void VerifyEmpty(WebElement element,boolean empty) throws Exception {
	   
	   if(StringUtils.isEmpty(element.getAttribute("value")) && empty) {
		   System.out.println(element + " :Is empty,dosen't contain text.");
	   }
	  if(!StringUtils.isEmpty(element.getAttribute("value")) && !empty) {
		  String sElementText=element.getText();
		  System.out.println(element +  " :Is not empty,element contains:" + sElementText);
	  }
	  if(StringUtils.isEmpty(element.getAttribute("value")) && !empty) {
		  throw new Exception(element + " :Is empty.");
	  }
	  if(!StringUtils.isEmpty(element.getAttribute("value")) && empty) {
		  
		  throw new Exception(element + " .Is not empty");
	  }
   }
   
   public void VerifyText(WebElement element,String sText) throws Exception {
	   if(element.getAttribute("value").equals(sText)) {
		   System.out.println(element + " :Contains corresponding text :" + sText);
	   }
	   else {
		   throw new Exception(element + ": Doesn't contain corresponding text.");
	   }
   }
   
 public int GetRowCountInCartList(WebDriver driver) {
	   
	   List<WebElement> lsRows=driver.findElements(By.xpath("//div[@class='cart_item']"));
	   return lsRows.size();
   }
 
 public void VerifyContainsText(WebElement element,String sText) throws Exception {
	 if(element.getText().equals(sText)) {
		 System.out.println(element + " :Contains corresponding text :" + sText);
	 }
	 else {
		   throw new Exception(element + ": Doesn't contain corresponding text.");
	   }
 }
   
   
   
}
