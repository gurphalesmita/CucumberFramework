package com.vtiger.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActivity {
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();		
		driver.get("http://localhost:100");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("showSubMenu"))).perform();
		Thread.sleep(2000);
		act.click(driver.findElement(By.linkText("New Vendor"))).perform();
		driver.findElement(By.xpath("//*[text()='Vendor Name:']")).isDisplayed();
		
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.name("Customise")).click();
		act.dragAndDrop(driver.findElement(By.id("cl2")), driver.findElement(By.id("cl8"))).perform();
		driver.findElement(By.id("cl8")).getText().equals("Calendar");
		
		
		
		
		
		
	}

}
