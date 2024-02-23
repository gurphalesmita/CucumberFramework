package com.vtiger.stepdefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDefinitions {
	
	public static Properties prop;
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static Map<String, Map<String,String>> dt;
	public  static ExtentTest logger;
	public static String TCName;
	
	public void initiation()
	{
		if(prop==null)
		prop = readproperties();
		if(extent==null)
		createExtentReport();
		if(dt==null)
		dt = JsonReader();
	}
	
	
	public void launchApp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("ImplictWait"))));
		driver.get(prop.getProperty("AppUrl"));
		driver.manage().window().maximize();
	}
	
	
	public void closeApp()
	{
		driver.quit();
	}
	
	
	
	public Properties readproperties()
	{
		Properties prop=null;;
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Settings/conf.properties");
		    prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return prop;	
	}
	
	
	public Map<String, Map<String,String>> JsonReader()
	{
		Map<String, Map<String,String>> userData = null;
		 ObjectMapper mapper = new ObjectMapper();  
	        // create instance of the File class   
	        File fileObj = new File(System.getProperty("user.dir")+"/src/test/resources/Data/TestData.json");  
	        // use try-catch block to convert JSON data into Map  
	        try {  
	            // read JSON data from file using fileObj and map it using ObjectMapper and TypeReference classes  
	            userData = mapper.readValue(  
	                    fileObj, new TypeReference<Map<String, Map<String,String>>>() {  
	            });   
	            // print all key-value pairs   
	           // System.out.println("TCName : " + userData.get("verifyInvalidLogin_TC04").get("Userid"));  
	           // System.out.println("TCName : " + userData.get("verifyInvalidLogin_TC04").get("Password"));  
	        } catch (Exception e) {  
	            // show error message  
	            e.printStackTrace();  
	        }
	        
	        return userData;
	}
	
	
	public void createExtentReport()
	{
		Date d = new Date();
		DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName = ft.format(d);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport"+fileName+".html");
    	// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test Hub");
		    	extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Rajesh U");
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
		            // Name of the report
		htmlReporter.config().setReportName("Name of the Report Comes here "); 
		            // Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD); 		
		
	}
	
	
	
	
	
	
	
	
	

}
