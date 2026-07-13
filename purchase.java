package Teamproject_1.steam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class purchase {
	public static WebElement add(WebDriver web) {
    	return web.findElement(By.id("btn_add_to_cart_68476"));
    }
	public static WebElement purch(WebDriver web) {
    	return web.findElement(By.xpath("(//button[text()='Continue to payment'])[3]"));
    }

}
