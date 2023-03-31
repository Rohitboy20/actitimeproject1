package com.Actitime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.pom.HomePage;
import com.Actitime.pom.TaskPage;

public class TaskTest extends BaseClass {
  @Test
  public void creatcustomer() throws EncryptedDocumentException, IOException {
	  HomePage hp=new HomePage(driver);
	  hp.getTasklnk().click();
	  
	  TaskPage TP=new TaskPage(driver);
	  TP.getAddnewbtn().click();
	  
	  TP.getNewcust().click();
	  FileLibrary f=new FileLibrary();
	  String name  = f.readDataFromExcel("Sheet1", 4, 1);
	  TP.getCustname().sendKeys(name);
	String disc = f.readDataFromExcel("Sheet1", 4, 2);
	TP.getCustdisc().sendKeys(disc);
	TP.getClickcust().click();
  }
}
