package swagLabs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Login.Filter;
import Login.LoginPOM;
import Login.Menu;
import Login.addToCart;
import Login.cart;


public class SwagLabs {
	WebDriver driver;
	LoginPOM log;
	addToCart cart;
	Menu menu;
	Filter filter;
	cart Cart;
	SoftAssert sf;
	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HCLTSS\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}
	@Test
	public void login() throws InterruptedException {
		log=new LoginPOM(driver);
		log.Login("standard_user","secret_sauce");
		
	}
	@Test
	public void goToCart() throws InterruptedException {
		Cart=new cart(driver);
		Cart.goToCart();
		Thread.sleep(2000);
		sf=new SoftAssert();
		String actual=driver.getCurrentUrl();
		String expected="https://www.saucedemo.com/cart.html";
		sf.assertEquals(actual,expected);
		sf.assertAll();
	}
	@Test
	public void CheckOut() throws InterruptedException {
		Cart=new cart(driver);
		Cart.checkout();
		Thread.sleep(2000);
	}
	@Test
	public void continueShopping() throws InterruptedException {
		Cart=new cart(driver);
		Cart.continueShopping();
		Thread.sleep(2000);
	}
	@Test
	public void checkOutDetails() throws InterruptedException {
		Cart=new cart(driver);
		Cart.checkOutDetails("Rupesh","Kallepelli","123456");
		Thread.sleep(2000);
	}
	@Test
	public void proceedToPay() throws InterruptedException {
		Cart=new cart(driver);
		Cart.proceedToPay();
		Thread.sleep(2000);
	}
	@Test
	public void finishPayment() throws InterruptedException {
		Cart=new cart(driver);
		Cart.finish();
		Thread.sleep(2000);
	}
	@Test
	public void cancel() throws InterruptedException {
		Cart=new cart(driver);
		Cart.cancel();
		Thread.sleep(2000);
	}
	@Test
	public void backToProduct() throws InterruptedException {
		Cart=new cart(driver);
		Cart.backToProduct();
		Thread.sleep(2000);
	}
	@Test
	public void filter() throws InterruptedException {
		filter=new Filter(driver);
		filter.selectFilter("Price (high to low)");
		Thread.sleep(2000);
	}
	@Test
	public void addToCart() throws InterruptedException {
		cart=new addToCart(driver);
		cart.selectProduct("Sauce Labs Bolt T-Shirt");
		Thread.sleep(2000);
	}
	@Test 
	public void removeFromCart() {
		cart=new addToCart(driver);
		cart.removeProduct("Sauce Labs Bolt T-Shirt");
	}
	@Test
	public void Menu() throws InterruptedException {
		menu=new Menu(driver);
		menu.goToMenu();
		Thread.sleep(2000);
	}
	@Test
	public void MenuFunction_about() throws InterruptedException {
		menu=new Menu(driver);
//		menu.goToMenu();
//		Thread.sleep(2000);
		menu.about();
		SoftAssert sf=new SoftAssert();
		String actual=driver.getCurrentUrl();
		String expected="https://saucelabs.com/";
		sf.assertEquals(actual,expected);
		Thread.sleep(2000);
		driver.navigate().back();
		sf.assertAll();

	}
	@Test
	public void MenuFunction_AllItems() throws InterruptedException {
		menu=new Menu(driver);
//		menu.goToMenu();
//		Thread.sleep(2000);
		menu.allItems();
		Thread.sleep(2000);
		SoftAssert sf=new SoftAssert();
		String actual=driver.getCurrentUrl();
		String expected="https://www.saucedemo.com/inventory.html";
		sf.assertEquals(actual,expected);
		sf.assertAll();
//		menu.closeMenu();
//		Thread.sleep(2000);
	}
	@Test
	public void MenuFunction_Reset() throws InterruptedException {
		menu=new Menu(driver);
//		menu.goToMenu();
//		Thread.sleep(2000);
		menu.reset();
		Thread.sleep(2000);
//		menu.closeMenu();
//		Thread.sleep(2000);
	}
	@Test
	public void MenuFunction_Close() throws InterruptedException {
		menu=new Menu(driver);
//		menu.goToMenu();
//		Thread.sleep(2000);
		menu.closeMenu();
		Thread.sleep(2000);

	}
//	@Test
//	public void verify() throws InterruptedException {
//		  String rs = driver.findElement(By.xpath("//*[@id=\"item_1_title_link\"]/div")).getText();
//	        System.out.println(rs);
//	        String g = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).getText();
//	        System.out.println("Add to cart is present : " + g);
//	        Thread.sleep(2000);
//	        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
//	        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]")).click();
//	        boolean sss = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]"))
//	                .isDisplayed();
//	        System.out.println("Added successfully to the cart : " + sss);
//
//	        String fg = driver.findElement(By.className("inventory_item_name")).getText();
//	        System.out.println("The item is : "+fg);
//	}
	@Test 
	public void logOut() throws InterruptedException {
		menu=new Menu(driver);
		menu.goToMenu();
		Thread.sleep(2000);
		menu.logOut();
		Thread.sleep(2000);
		
	}
	@Test
	public void MenuFunction_Logout() throws InterruptedException {
		menu=new Menu(driver);
//		menu.goToMenu();
//		Thread.sleep(2000);
		menu.logOut();
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}

//<test  name="Login">
//<classes>
//  <class name="swagLabs.SwagLabs">
//  <methods>
//  <include name="login"/>
//  </methods>
//  </class>
//</classes>
//</test>
//<test  name="addToCart">
//<classes>
//  <class name="swagLabs.SwagLabs">
//  <methods>
//  <include name="login"/>
//  <include name="addToCart"/>
//  </methods>
//  </class>
//</classes>
//</test> 
//<test  name="goToCart">
//<classes>
//  <class name="swagLabs.SwagLabs">
//  <methods>
//  <include name="login"/>
//  <include name="addToCart"/>
//  <include name="goToCart"/>
//  </methods>
//  </class>
//</classes>
//</test> 
//<test  name="finishPayment">
//<classes>
//  <class name="swagLabs.SwagLabs">
//  <methods>
//  <include name="login"/>
//  <include name="addToCart"/>
//  <include name="goToCart"/>
//  <include name="CheckOut"/>
//  <include name="checkOutDetails"/>
//  <include name="proceedToPay"/>
//  <include name="finishPayment"/>
//  <include name="backToProduct"/>      
//  </methods>
//  </class>
//</classes>
//</test> 