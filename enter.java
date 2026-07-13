package Teamproject_1.steam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sun.org.apache.bcel.internal.generic.Select;

public class enter {
            public static WebElement sel_1(WebDriver web) {
            	return web.findElement(By.id("ageDay"));
            }
            public static WebElement sel_2(WebDriver web) {
            	return web.findElement(By.id("ageMonth"));
            }
            public static WebElement sel_3(WebDriver web) {
            	return web.findElement(By.id("ageYear"));
            }
            public static WebElement view(WebDriver web) {
            	return web.findElement(By.partialLinkText("View Page"));
            }
}           

