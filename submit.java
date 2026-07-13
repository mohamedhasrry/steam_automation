package Teamproject_1.steam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class submit {
	public static WebElement con(WebDriver web) {
    	return web.findElement(By.id("submit_payment_info_btn"));
    }
	public static WebElement click(WebDriver web) {
    	return web.findElement(By.id("accept_ssa"));
    }
	public static WebElement confirm(WebDriver web) {
    	return web.findElement(By.partialLinkText("Purchase"));
    }
	
}
