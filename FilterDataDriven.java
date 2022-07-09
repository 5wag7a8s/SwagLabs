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

import Login.*;

public class FilterDataDriven {
	WebDriver driver;
	LoginPOM log;
	Filter filter;
	Menu menu;
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
	@Test(dependsOnMethods = "login", dataProvider = "filters")
	public void filter(String filters) throws InterruptedException {
		filter=new Filter(driver);
		filter.selectFilter(filters);
		Thread.sleep(2000);
	}
	@DataProvider(name="filters")
	public Object[] filters() throws IOException {
		File file = new File("C:\\Users\\HCLTSS\\Desktop\\LabCredentials.xlsx");
		FileInputStream fis= new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet("Sheet3");
		int r=sh.getPhysicalNumberOfRows();
		Object[]data=new Object[r];
		try {
		for(int i=0; i<r; i++) {
			data[i]=sh.getRow(i).getCell(0).getStringCellValue();
			data[i]=sh.getRow(i).getCell(0).getStringCellValue();
		}}catch (Exception e) {
			// TODO: handle exception
		}
		return data;
	}
	@Test(dependsOnMethods = "filter")
	public void logout() throws InterruptedException {
		menu=new Menu(driver);
		menu.goToMenu();
		Thread.sleep(2000);
		menu.logOut();
		Thread.sleep(2000);
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
