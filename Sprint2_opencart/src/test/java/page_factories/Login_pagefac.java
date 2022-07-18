package page_factories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import cucumber.api.Scenario;
import junit.framework.Assert;
/*
 * 1.this class is used as a page factory for login.feature
 * 
 */
public class Login_pagefac{
	//global variables
	WebDriver driver;
	String result;
	//initiating the page factory
	public Login_pagefac(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
				
	}

	@FindBy(partialLinkText="My Account")//my account button
	WebElement myaccount;
	@FindBy(linkText ="Login")//login button for login page
	WebElement login;
	@FindBy(id="input-email")//input for email
	WebElement inpemail;
	@FindBy(id="input-password")//input for password
	WebElement inppass;
	@FindBy(xpath="//input[@value='Logins']")//login button to log in
	WebElement logbutton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")//error message for invalid email
	WebElement invalidemail;
	 SoftAssert softassert = new SoftAssert();
	 //this method used for verifying home page
	public void homepage() {
		String home=driver.getTitle();
		 softassert.assertEquals(home, "Your Store");
		 
	}
	//this method opens the login page
	public void openloginpage() {
		
		myaccount.click();
		login.click();
	}
	//this method used to pass the parameters i.e email and password
	public String enter_email_and_pass(String em,String pass) {
		inpemail.sendKeys(em);
		inppass.sendKeys(pass);
		logbutton.click();
		result=driver.getTitle();//capturing the title
		
		return result;
		
	}
	//this method is used to get the error message for invalid mailid or password
	public String capturemessage() {
		String errmsg=invalidemail.getText();
		return errmsg;
	}
	//this method validate for successful log in
	  @SuppressWarnings("deprecation")
	public boolean authentication(String res) {
		  boolean out=res.equals("My Account");
		  
		  Assert.assertEquals("My Account", res);
		  return out;
		  }
	  //this method validate for unsuccessful login
	  public boolean invalid_authentication(String res) {
		  boolean out=res.equals("Warning: No match for E-Mail Address and/or Password.");
		  Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", res);
		  return out;
	  }
	  //this method return the current web driver
	  public WebDriver closebrowser() {
		 return driver;
	  }
	
	
}
