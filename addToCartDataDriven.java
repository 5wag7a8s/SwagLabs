package swagLabs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Login.LoginPOM;
import Login.Menu;
import Login.addToCart;

public class addToCartDataDriven {
	WebDriver driver;
	LoginPOM log;
	Menu menu;
	addToCart cart;
	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HCLTSS\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}

	@Test
	public void login() throws InterruptedException {
		log = new LoginPOM(driver);
		log.Login("standard_user", "secret_sauce");
	}
	@Test(dataProvider = "products", dependsOnMethods = "login")
	public void addToCart(String productname) throws InterruptedException {
		cart=new addToCart(driver);
		cart.selectProduct(productname);
		Thread.sleep(2000);
	}
	@DataProvider(name="products")
	public Object[] products() throws IOException  {
	File file = new File("C:\\Users\\HCLTSS\\Desktop\\LabCredentials.xlsx");
	FileInputStream fis= new FileInputStream(file);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sh=wb.getSheet("Sheet2");
	int r=sh.getPhysicalNumberOfRows();
	Object[]data=new Object[r];
	try {
	for(int i=0; i<r; i++) {
		data[i]=sh.getRow(i).getCell(0).getStringCellValue();
		data[i]=sh.getRow(i).getCell(0).getStringCellValue();
	}}catch (Exception e) {
	
	}
	return data;
}
	@Test(dependsOnMethods = "addToCart", dataProvider = "products")
	public void removeFromCart(String product) throws InterruptedException {
		cart=new addToCart(driver);
		cart.removeProduct(product);
		Thread.sleep(3000);
	}
	@Test(dependsOnMethods = "removeFromCart")
	public void logout() throws InterruptedException {
		menu=new Menu(driver);
		menu.goToMenu();
		Thread.sleep(2000);
		menu.logOut();
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
