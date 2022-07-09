package swagLabs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Login.LoginPOM;
import Login.Menu;
import Login.addToCart;
import Login.cart;

public class addressDataDriven {
	
	WebDriver driver;
	LoginPOM log;
	Menu menu;
	addToCart cart;
	cart Cart;
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
	@Test(dependsOnMethods = "login")
	public void addToCart() throws InterruptedException {
		cart=new addToCart(driver);
		cart.selectProduct("Sauce Labs Bolt T-Shirt");
		Thread.sleep(2000);
	}
	@Test(dependsOnMethods = "addToCart",dataProvider = "details")
	public void checkOutDetails(String fname, String lname, String zip) throws InterruptedException {
		Cart=new cart(driver);
		Cart.goToCart();
		Thread.sleep(2000);
		String actual=driver.getCurrentUrl();
		String expected="https://www.saucedemo.com/cart.html";
		Assert.assertEquals(actual,expected);
		Cart.checkout();
		Thread.sleep(2000);
		Cart.checkOutDetails(fname,lname,zip);
		Thread.sleep(2000);
		Cart.proceedToPay();
		Thread.sleep(2000);
		Cart.cancel();
		Thread.sleep(2000);
		
	}
//	@Test(dependsOnMethods = "goToCart")
//	public void CheckOut() throws InterruptedException {
//		Cart=new cart(driver);
//		Cart.checkout();
//		Thread.sleep(2000);
//	}
	
//	@Test(dependsOnMethods = "CheckOut",dataProvider = "details")
//	public void checkOutDetails(String fname, String lname, String zip) throws InterruptedException {
//		Cart=new cart(driver);
//		System.out.printf("%s,%s,%s",fname, lname, zip);
//		Cart.checkOutDetails(fname,lname,zip);
//		Thread.sleep(2000);
//		Cart.proceedToPay();
//		Thread.sleep(2000);
//		Cart.cancel();
//		Thread.sleep(2000);
//	}
	@DataProvider(name="details")
	public String[] []details() throws IOException  {
		DataFormatter df;
	File file = new File("C:\\Users\\HCLTSS\\Desktop\\LabCredentials.xlsx");
	FileInputStream fis= new FileInputStream(file);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sh=wb.getSheet("Sheet4");
	int r=sh.getPhysicalNumberOfRows();
	String[][]data=new String[r][3];
	try {
	for(int i=0; i<r; i++) {
		df=new DataFormatter();
		data[i][0]=df.formatCellValue(sh.getRow(i).getCell(0));
		data[i][1]=df.formatCellValue(sh.getRow(i).getCell(1));
		data[i][2]=df.formatCellValue(sh.getRow(i).getCell(2));
	}}catch (Exception e) {
	
	}
	return data;
}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	}
