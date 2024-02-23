package com.vtiger.tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();		
		driver.get("http://localhost:100");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();
		driver.findElement(By.linkText("New Lead")).click();
		driver.findElement(By.name("button")).click();
		Alert alt = driver.switchTo().alert();
		//driver.switchTo().alert().getText();
		System.out.println(alt.getText());;
		alt.accept();
		//alt.dismiss();
		driver.findElement(By.name("lastname")).sendKeys("Modi");
		

	}

}
