package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPOM {
	WebDriver driver;
By username=By.id("user-name");
By pass=By.id("password");
By login=By.id("login-button");
 public LoginPOM(WebDriver driver){
	this.driver=driver;
}
public void Login(String Uname, String password) {
	driver.findElement(username).sendKeys(Uname);
	driver.findElement(pass).sendKeys(password);
	driver.findElement(login).click();
}
public void clearCredentials() {
	driver.findElement(username).clear();;
	driver.findElement(pass).clear();
}
}
