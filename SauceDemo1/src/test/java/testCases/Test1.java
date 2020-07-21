package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModels.HomePage;
import pageObjectModels.LoginPage;
import pageObjectModels.MenuWrapper;
import pageObjectModels.ShoppingCartPage;
import methods.Methods;

public class Test1  {

	LoginPage lp=new LoginPage();
	HomePage hp=new HomePage();
	ShoppingCartPage sp=new ShoppingCartPage();
	MenuWrapper mw=new MenuWrapper();
	Methods m=new Methods();
	
	public static WebDriver driver;
	
	@BeforeTest
	public void Initialise() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	    driver.get("https://www.saucedemo.com/");
	    driver.manage().window().maximize();
	}
	
	
	@Test(priority=1)
	public void TestLogin() throws Exception {
		
		String sItemName="Sauce Labs Bike Light";
		String sItemPrice="$9.99";
		String sItemPrice1="9.99";
		String sItemQuantity="1";
		
	    Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
	    Assert.assertEquals(driver.getTitle(),"Swag Labs");
		m.EnabledAndDisplayed(lp.txtUsername(driver));
		m.VerifyEmpty(lp.txtUsername(driver),true);
		m.EnabledAndDisplayed(lp.txtPassword(driver));
		m.VerifyEmpty(lp.txtPassword(driver), true);
		m.EnabledAndDisplayed(lp.btnLogin(driver));
       
		lp.Login(driver);
		
		 Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
		m.EnabledAndDisplayed(hp.btnMenu(driver));
		m.EnabledAndDisplayed(hp.btnShoppingCart(driver));
		m.EnabledAndDisplayed(hp.ddlSortProducts(driver));
		m.ddlVerifyText(hp.ddlSortProducts(driver),"Name (A to Z)");
		m.Displayed(hp.labelProducts(driver),true);
		m.Displayed(hp.listInventorylist(driver),true);
		
		int iRowsCountInInventoryList=m.GetRowCountInInventoryList(driver);
		
		if(iRowsCountInInventoryList>1) {
			
			m.Displayed(hp.imgInventoryItem(driver), true);
			m.Displayed(hp.labelInventoryItemName(driver),true);
			m.Displayed(hp.labelInventoryItemPrice(driver),true);
			m.EnabledAndDisplayed(hp.btnAddToCart(driver));
			m.addItem(driver,sItemName,sItemPrice);
		}
		
		hp.btnShoppingCart(driver).click();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
		m.Displayed(sp.labelCartQuantity(driver), true);
		m.VerifyContainsText(sp.labelCartQuantity(driver),"QTY");
		m.Displayed(sp.labelCartDesc(driver),true);
		m.VerifyContainsText(sp.labelCartDesc(driver),"DESCRIPTION");
		m.Displayed(sp.listCartList(driver),true);
		int iRowsCountInCartList=m.GetRowCountInCartList(driver);
		if(iRowsCountInCartList>0) {
			m.Displayed(sp.labelItemQuantity(driver),true);
			m.VerifyContainsText(sp.labelItemQuantity(driver), sItemQuantity);
			m.Displayed(sp.labelInventoryItemName(driver),true);
			m.VerifyContainsText(sp.labelInventoryItemName(driver), sItemName);
			m.Displayed(sp.labelInventoryItemPrice(driver),true);
			m.VerifyContainsText(sp.labelInventoryItemPrice(driver), sItemPrice1);
			
			m.EnabledAndDisplayed(sp.btnRemove(driver));
			m.EnabledAndDisplayed(sp.btnContinueShopping(driver));
			m.EnabledAndDisplayed(sp.btnCheckOut(driver));
			
			sp.btnRemove(driver).click();
			
			int iRowsCountInCartListAfterRemovingAnItem=m.GetRowCountInCartList(driver);
			
			if(iRowsCountInCartListAfterRemovingAnItem==0) {
				
				System.out.println("Corresponding item is succesfully removed from the shopping cart.");
			}
			
		}
		
		hp.btnMenu(driver).click();
		m.Displayed(mw.wpMenuWrapper(driver),true);
		m.EnabledAndDisplayed(mw.linkAllItems(driver));
		m.EnabledAndDisplayed(mw.linkAbout(driver));
		m.EnabledAndDisplayed(mw.linkLogout(driver));
		m.EnabledAndDisplayed(mw.linkResetAppState(driver));
		
		mw.linkLogout(driver).click();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/index.html");

		
	}
	
	
	
	
	@AfterTest
	public void TearDown() {
		driver.close();
	}
}
