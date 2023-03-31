package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.pom.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	FileLibrary f=new FileLibrary();
	
	static {
		System.setProperty("webdriver.chrome.driver", "./driver./chromedriver.exe");
	}

    @BeforeSuite
    public void databaseconnection() {
    	Reporter.log("database connected successfully",true);
    	
    }
    
    @AfterSuite
    public void databasedisconnection() {
    	Reporter.log("database disconnected successfully",true);
    	
    }
    @BeforeClass
    public void launchbrowser() throws IOException {
    	ChromeOptions option=new ChromeOptions();
    	option.addArguments("--remote-allow-origins=*");
    	 driver=new ChromeDriver(option);
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	String URL = f.readDataFromProperty("url");
    	driver.get(URL);
    	Reporter.log("browser launched",true);
    	
    }
    @AfterClass
    public void closebrowser() {
    	driver.close();
    	Reporter.log("browser closed",true);
    }
    @BeforeMethod
    public void login() throws IOException {
    	String UN = f.readDataFromProperty("username");
    	String PW = f.readDataFromProperty("password");
    	LoginPage lp=new LoginPage(driver);
    	lp.getUntbx().sendKeys(UN);
    	lp.getPwtbx().sendKeys(PW);
    	lp.getLgbtn().click();
    	Reporter.log("login successfully");
    	
    }
    @AfterMethod
    public void logout() {
    	driver.findElement(By.id("logoutLink")).click();
    	Reporter.log("logout successfully");
    }
}
