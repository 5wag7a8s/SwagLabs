package swagLabs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Login.LoginPOM;
import Login.Menu;

public class LoginDataDriven {
	WebDriver driver;
	LoginPOM log;
	Menu menu;

	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.edge.driver","C:\\Users\\HCLTSS\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com/");
	}

	@Test(dataProvider = "credentials")
	public void login(String username, String pass) throws InterruptedException {
		log = new LoginPOM(driver);
		log.Login(username, pass);
		Thread.sleep(2000);
		if ((driver.getCurrentUrl() != "https://www.saucedemo.com/inventory.html"))
			driver.get("https://www.saucedemo.com/");
		else
			driver.navigate().back();
		Thread.sleep(2000);
		log.clearCredentials();
		// menu = new Menu(driver);
		// menu.goToMenu();
		// Thread.sleep(2000);
		// menu.logOut();
		// driver.navigate().refresh();
	}

	@DataProvider
	public Object[][] credentials() throws IOException {
//				Object[][]data=new Object[3][2];
//				data[0][0]="standard_user";
//				data[0][1]="secret_sauce";
//				data[1][0]="performance_glitch_user";
//				data[1][1]="secret_sauce";
//				data[2][0]="problem_user";
//				data[2][1]="secret_sauce";
		DataFormatter df=new DataFormatter();
		File file = new File("C:\\Users\\HCLTSS\\Desktop\\LabCredentials.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Sheet1");
		int r = sh.getPhysicalNumberOfRows();
		Object[][] data = new Object[r][2];
		try {
			for (int i = 0; i < r; i++) {
				data[i][0] =df.formatCellValue(sh.getRow(i).getCell(0));
				data[i][1] = df.formatCellValue(sh.getRow(i).getCell(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return data;
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
