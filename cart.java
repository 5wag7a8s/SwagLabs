package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class cart {
	WebDriver driver;
	By cart=By.id("shopping_cart_container");
	By checkout=By.id("checkout");
	By continueShopping=By.id("continue-shopping");
	By firstName=By.id("first-name");
	By lastName=By.id("last-name");
	By zipCode=By.id("postal-code");
	By cancelCheckout=By.id("cancel");
	By Continue=By.id("continue");
	By finish=By.id("finish");
	By backToProduct=By.id("back-to-products");
	public cart(WebDriver driver) {
		this.driver=driver;
	}
	public void goToCart() {
		driver.findElement(cart).click();
	}
	public void checkout() {
		driver.findElement(checkout).click();
	}
	public void continueShopping() {
		driver.findElement(continueShopping).click();
	}
	public void checkOutDetails(String fname, String lname, String  zip) {
		driver.findElement(firstName).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lname);
		driver.findElement(zipCode).sendKeys(zip);
	}
	public void cancel() {
		driver.findElement(cancelCheckout).click();
	}
	public void proceedToPay() {
		driver.findElement(Continue).click();
	}
	public void finish() {
		driver.findElement(finish).click();
	}
	public void backToProduct() {
		driver.findElement(backToProduct).click();
	}
}
