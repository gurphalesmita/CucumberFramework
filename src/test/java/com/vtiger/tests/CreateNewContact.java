package com.vtiger.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateNewContact {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:100");
        driver.manage().window().maximize();

        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.name("Login")).click();
        driver.findElement(By.partialLinkText("New Contact")).click();
        driver.findElement(By.name("firstname")).sendKeys("Shubham");
        driver.findElement(By.name("lastname")).sendKeys("Jangali");
        driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
    }
}
