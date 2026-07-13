package Teamproject_1.steam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class payment {
	 public static WebElement meth(WebDriver web) {
    	return web.findElement(By.id("payment_method"));
       }
	 public static WebElement pay(WebDriver web) {
	    	return web.findElement(By.id("payment_method_trigger"));
	    }
	 public static WebElement visa(WebDriver web) {
	    	return web.findElement(By.id("visa"));
	    }
	 public static WebElement card(WebDriver web) {
	    	return web.findElement(By.name("card_number"));
	    }
	 // Month
	    public static WebElement month(WebDriver web) {
	        return web.findElement(By.id("expiration_month_trigger"));
	    }

	    // Option 12
	    public static WebElement month12(WebDriver web) {
	        return web.findElement(By.id("12"));
	    }

	    // Year dropdown button
	    public static WebElement year(WebDriver web) {
	        return web.findElement(By.id("expiration_year_trigger"));
	    }

	    // Option 2030
	    public static WebElement year2030(WebDriver web) {
	        return web.findElement(By.id("2030"));
	    }
	    //security number
	    public static WebElement cvv(WebDriver web) {
	        return web.findElement(By.name("security_code"));
	    }
	    //phone number
	    public static WebElement num(WebDriver web) {
	        return web.findElement(By.name("billing_phone"));
	    }
	
}
