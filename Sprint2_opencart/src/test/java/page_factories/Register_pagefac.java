package page_factories;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencart.utilities.ReadRegister;
/*
 * this class is used as page factory for account_register.feature file
 */
public class Register_pagefac {
	//driver declaration
WebDriver driver;
public static List<String> result=new ArrayList<String>();
@FindBy(linkText="My Account")//my account button
WebElement myaccount;

@FindBy(linkText ="Register")//register button
WebElement register;

@FindBy(xpath="//input[@name='firstname']")//first name field
WebElement fname;
@FindBy(name="lastname")//last name field
WebElement lname;
@FindBy(name="email")//email field
WebElement em;
@FindBy(name="telephone")//telephone field
WebElement tele;
@FindBy(name="password")//password field
WebElement pass;
@FindBy(name="confirm")//password confirmation field
WebElement cpass;
@FindBy(css="#content > form > div > div > input[type=checkbox]:nth-child(2)")//check box field
WebElement ckbox;
@FindBy(xpath="//input[@value='Continue']")//continue button
WebElement search;
//initiating the page factory

public Register_pagefac(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

//validating the home page
public void homepage() {
	boolean home=driver.getTitle().equals("Your Store");
	Assert.assertTrue(home);
}
//opening register page
public void selectregister() {
	myaccount.click();
	register.click();
}
//validating the registration page
public void registertest() {
	boolean regpage=driver.getTitle().equals("Register Account");
	Assert.assertTrue(regpage);
}
//entering valid data from the excel file
public String registerforvalid(List<String> fnames,List<String> lnames,List<String> ems,List<String> teles,List<String> passw) {
String result;
System.out.println("out of the loop"+fnames.size());
		fname.click();
		fname.sendKeys(fnames.get(0));
		lname.sendKeys(lnames.get(0));
		em.sendKeys(ems.get(0));
		tele.sendKeys(teles.get(0));
		pass.sendKeys(passw.get(0));
		cpass.sendKeys(passw.get(0));
		ckbox.click();
		search.click();
		result=driver.getTitle();//capturing the page title
		
		
	return result;
	
}
//entering invalid data from the excel file
public String registerforinvalid(List<String> fnames,List<String> lnames,List<String> ems,List<String> teles,List<String> passw) {
String result;
System.out.println("out of the loop"+fnames.size());
		fname.click();
		fname.sendKeys(fnames.get(1));
		lname.sendKeys(lnames.get(1));
		em.sendKeys(ems.get(1));
		tele.sendKeys(teles.get(1));
		pass.sendKeys(passw.get(1));
		cpass.sendKeys(passw.get(1));
		ckbox.click();
		search.click();
		result=driver.getTitle();
		//Your Account Has Been Created!,register account
		System.out.println(result);

	return result;
	
}
//validating the account creation for valid inputs
public void valid(String res) {
	Assert.assertEquals("Your Account Has Been Created!", res);
	
}
//validating the results for invalid inputs
public void invalid(String res) {
	Assert.assertEquals("Register Account", res);
	
}
//returning the current web driver
public WebDriver closebrowsers() {
	return driver;
	
}


}
