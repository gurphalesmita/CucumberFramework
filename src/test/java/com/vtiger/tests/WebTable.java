package com.vtiger.tests;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();	    
	    driver.get("http://localhost:100");
	    driver.manage().window().maximize();
	    driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");        
        driver.findElement(By.name("Login")).click();
        driver.findElement(By.linkText("Leads")).click();
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter first name");
        String fname = scan.next();
        System.out.println("Please enter Last name");
        String lname = scan.next();
        
        String name = fname+" "+lname;
        System.out.println("hi");
        String xpath = "";
        
        for(int i=5;i<=24;i++)
        {
        	String name2 = driver.findElement(By.xpath("//table[@class='FormBorder']/tbody/tr["+i+"]/td[4]")).getText();
        	if(name2.equals(name))
        	{
        		driver.findElements(By.name("selected_id")).get(i-5).click();
        		break;
        	}
        }
         
        

	}

}
