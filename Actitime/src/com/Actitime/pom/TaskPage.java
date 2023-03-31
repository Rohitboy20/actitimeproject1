package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
   //decleration
	
	@FindBy(xpath="//div[.='Add New']")
	private WebElement addnewbtn;
	
	@FindBy(xpath="//div[.='+ New Customer']")
	private WebElement newcust;
	
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement custname;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement custdisc;
	
	@FindBy(xpath="//div[.='Create Customer']")
	private WebElement clickcust;
	
	//initialization
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
      //utilization
	public WebElement getAddnewbtn() {
		return addnewbtn;
	}

	public WebElement getNewcust() {
		return newcust;
	}

	public WebElement getCustname() {
		return custname;
	}

	public WebElement getCustdisc() {
		return custdisc;
	}

	public WebElement getClickcust() {
		return clickcust;
	}
	
	
}
