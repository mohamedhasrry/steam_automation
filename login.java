package Teamproject_1.steam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

	public static WebElement acc_name(WebDriver web) {
		return web.findElement(By.id("«r4»"));
	}
	public static WebElement pass(WebDriver web) {
		return web.findElement(By.xpath("//input[@type='password']"));
	}
	public static WebElement sub(WebDriver web) {
		return web.findElement(By.xpath("(//button[@type='submit'])[2]"));
	}

}
