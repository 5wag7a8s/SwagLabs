package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Menu {
WebDriver driver;
By goToMenu=By.id("react-burger-menu-btn");
By allItems=By.id("inventory_sidebar_link");
By about=By.id("about_sidebar_link");
By reset=By.id("reset_sidebar_link");
By logout=By.id("logout_sidebar_link");
By close=By.id("react-burger-cross-btn");
public Menu(WebDriver driver) {
	this.driver=driver;
}
public void goToMenu() {
	driver.findElement(goToMenu).click();
}
public void allItems() {
	driver.findElement(allItems).click();
}
public void about() {
	driver.findElement(about).click();
}
public void reset() {
	driver.findElement(reset).click();
}
public void closeMenu() {
	driver.findElement(close).click();
}
public void logOut() {
	driver.findElement(logout).click();
}
}
