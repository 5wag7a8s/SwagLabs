package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Filter {
WebDriver driver;
Select dropdown;
By list=By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select");
public Filter(WebDriver driver) {
	this.driver=driver;
}
public void selectFilter(String filter) {
	dropdown=new Select(driver.findElement(list));
	dropdown.selectByVisibleText(filter);
}

}
