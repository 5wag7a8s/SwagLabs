package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addToCart {
	WebDriver driver;
	By SauceLabsBackpack=By.id("add-to-cart-sauce-labs-backpack");
	By SauceLabsBikeLight=By.id("add-to-cart-sauce-labs-bike-light");
	By SauceLabsBoltTShirt=By.id("add-to-cart-sauce-labs-bolt-t-shirt");
	By SauceLabsFleeceJacket=By.id("add-to-cart-sauce-labs-fleece-jacket");
	By SauceLabsOnesie=By.id("add-to-cart-sauce-labs-onesie");
	By TestallTheThingsTShirtRed=By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
	
	By SauceLabsBackpackR=By.id("remove-sauce-labs-backpack");
	By SauceLabsBikeLightR=By.id("remove-sauce-labs-bike-light");
	By SauceLabsBoltTShirtR=By.id("remove-sauce-labs-bolt-t-shirt");
	By SauceLabsFleeceJacketR=By.id("remove-sauce-labs-fleece-jacket");
	By SauceLabsOnesieR=By.id("remove-sauce-labs-onesie");
	By TestallTheThingsTShirtRedR=By.id("remove-test.allthethings()-t-shirt-(red)");
	public addToCart(WebDriver driver) {
		this.driver=driver;
	}
	public void selectProduct(String product) {
//		if(product.contains("Sauce Labs Backpack")) {
//			driver.findElement(SauceLabsBackpack).click();
//		}else if(product.contains("Sauce Labs BikeLight")) {
//			driver.findElement(SauceLabsBikeLight).click();
//		}else if(product.contains("Sauce abs Bolt TShirt")) {
//			driver.findElement(SauceabsBoltTShirt).click();
//		}else if(product.contains("Sauce Labs Fleece Jacket")) {
//			driver.findElement(SauceLabsFleeceJacket).click();
//		}else if(product.contains("Sauce Labs Onesie")) {
//			driver.findElement(SauceLabsOnesie).click();
//		}else if(product.contains("Testall The Things TShirt Red")) {
//			driver.findElement(TestallTheThingsTShirtRed).click();
//		}
		switch(product) {
		case "Sauce Labs Backpack":
			driver.findElement(SauceLabsBackpack).click();
			break;
		case "Sauce Labs BikeLight":
			driver.findElement(SauceLabsBikeLight).click();
			break;
		case "Sauce Labs Bolt T-Shirt":
			driver.findElement(SauceLabsBoltTShirt).click();
			break;
		case "Sauce Labs Fleece Jacket":
			driver.findElement(SauceLabsFleeceJacket).click();
			break;
		case "Sauce Labs Onesie":
			driver.findElement(SauceLabsOnesie).click();
			break;
		case "Testall The Things TShirt Red":
			driver.findElement(TestallTheThingsTShirtRed).click();
			break;
			default: System.out.println("select a valid product");

		}
	}
public void removeProduct(String product) {
	switch(product) {
	case "Sauce Labs Backpack":
		driver.findElement(SauceLabsBackpackR).click();
		break;
	case "Sauce Labs BikeLight":
		driver.findElement(SauceLabsBikeLightR).click();
		break;
	case "Sauce Labs Bolt T-Shirt":
		driver.findElement(SauceLabsBoltTShirtR).click();
		break;
	case "Sauce Labs Fleece Jacket":
		driver.findElement(SauceLabsFleeceJacketR).click();
		break;
	case "Sauce Labs Onesie":
		driver.findElement(SauceLabsOnesieR).click();
		break;
	case "Testall The Things TShirt Red":
		driver.findElement(TestallTheThingsTShirtRedR).click();
		break;
		default: System.out.println("select a valid product");

	}
}
}

