package Teamproject_1.steam;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		WebDriver web = new ChromeDriver();
		web.manage().window().maximize();
		web.get("https://store.steampowered.com/login/?redir=login%2F%3Fredir%3D%26redir_ssl%3D1%26snr%3D1_4_seasonalsale__global-header&redir_ssl=1");
		Thread.sleep(2000);
		//login
		login.acc_name(web).sendKeys("johan_harris333");
		Thread.sleep(1500);
		login.pass(web).sendKeys("@frith333");
		Thread.sleep(1500);
		login.sub(web).click();
		Thread.sleep(25000);
		//search
        find.search(web).sendKeys("witcher");
        Thread.sleep(1500);
        find.click(web).click();
        Thread.sleep(1500);
        //select
        find.sel(web).click();
        Thread.sleep(1500);
        //enter age
		Select day = new Select(enter.sel_1(web));
		day.selectByVisibleText("3");
		Thread.sleep(1500);
		Select month = new Select(enter.sel_2(web));
		month.selectByIndex(2);
		Thread.sleep(1500);
		Select year = new Select(enter.sel_3(web));
		year.selectByContainsVisibleText("2003");
		enter.view(web).click();
		Thread.sleep(1500);
		//javascriptexecutor
		WebElement addButton = purchase.add(web);
		JavascriptExecutor js = (JavascriptExecutor) web;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", addButton);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", addButton);
		Thread.sleep(1500);
		purchase.purch(web).click();
		Thread.sleep(1500);
		//payment gateway
		WebDriverWait wait = new WebDriverWait(web, Duration.ofSeconds(10));
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("payment_method_trigger")));
		dropdown.click();
		WebElement visa = wait.until(ExpectedConditions.elementToBeClickable(By.id("visa")));
		visa.click();
		//WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("payment_method_trigger")));
		//.moveToElement(payment.upi(web)).click().perform();
		//payment details
		payment.card(web).sendKeys("4111 1111 1111 1111");
		WebDriverWait wait_1 = new WebDriverWait(web, Duration.ofSeconds(10));
		// Month
		wait_1.until(ExpectedConditions.elementToBeClickable(payment.month(web))).click();

		wait_1.until(ExpectedConditions.elementToBeClickable(payment.month12(web))).click();
		// Year
		wait_1.until(ExpectedConditions.elementToBeClickable(payment.year(web))).click();

		wait_1.until(ExpectedConditions.elementToBeClickable(payment.year2030(web))).click();
		//security number
		payment.cvv(web).sendKeys("123");
		Thread.sleep(1500);
		//number
		//payment.num(web).sendKeys("6379782689");
	    //submission
		submit.con(web).click();
		Thread.sleep(1500);
		submit.click(web).click();
		Thread.sleep(1500);
		submit.confirm(web).click();
		
		
		

	}

}
