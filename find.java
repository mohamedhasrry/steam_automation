package Teamproject_1.steam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class find {
        public static WebElement search(WebDriver web) {
        	return web.findElement(By.xpath("//input[@placeholder='Search the store']"));
        }
        public static WebElement click(WebDriver web) {
        	return web.findElement(By.xpath("//button[@type='submit']"));
        }
        public static WebElement sel(WebDriver web) {
        	return web.findElement(By.xpath("//span[text()='The Witcher 3: Wild Hunt']"));
        }
}
