package Step_Definitions;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.opencart.utilities.Hooks;

import Baseclass.Testbase;
import cucumber.api.Scenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import page_factories.Login_pagefac;
/*
 * this is the step definition class for login feature 
 */
public class Login_cl {
	//creating object for base class
	Testbase wd=new Testbase();
	//creating object for login page factory
	Login_pagefac loginpage=new Login_pagefac(wd.openbrowser());
	String result,errormsg;
	//softassert for verifying home and login page
	SoftAssert softassert = new SoftAssert();

	@Given("The user should be in home page")
	public void the_user_should_be_in_home_page() {
		loginpage.homepage();//verifying home page
	 
	}
	@When("User opened the login page")
	public void user_opened_the_login_page() {
		
	    loginpage.openloginpage();//opening login page
	}
	@And("User entered email {string} and password {string}")
	public void user_entered_email_and_password(String string, String string2) {
	 
	    String email=string;
	    String password=string2;
	    result=loginpage.enter_email_and_pass(email, password);//passing email and password as a parameter
	    
	  
	}

	
	@And("capture the result of authentication")
	public void capture_the_result_of_authentication() {
	   System.out.println("the captured result is "+result);//printing the result
}
	//validating the authentication results
	@Then("authenticate the credentials and verify authentication is sucessful {string}")
	public void authenticate_the_credentials_and_verify_authentication_is_sucessful(String string) {
if(loginpage.authentication(result)) {
	System.out.println(string);
}else {
	System.out.println("authentication failed");
}
	}
//closing the browser
	@Then("close browser valid")
	public void close_browser_valid() {
		 wd.closebrowser(loginpage.closebrowser());
	}

	@Given("The user should be in home page for invalid")
	public void the_user_should_be_in_home_page_for_invalid() {
		loginpage.homepage();//verifying home page
	}

	@When("User opened the Login Page")
	public void user_opened_the_login_page1() {
		loginpage.openloginpage();//opening login page
	}

	@And("User entered invalid email {string} and password {string}")
	public void user_entered_invalid_email_and_password(String string, String string2) {
		  String email=string;
		    String password=string2;
		    result=loginpage.enter_email_and_pass(email, password);//passing email and password
	}

	@And("capture the result for authentication")
	public void capture_the_result_for_authentication() {
		
		errormsg=loginpage.capturemessage();//storing error message
		System.out.println(errormsg);
	}
//validating the authentication result
	@Then("authenticate the credentials verify authentication {string}")
	public void authenticate_the_credentials_verify_authentication(String string) {
	  if(loginpage.invalid_authentication(errormsg)) {
		  System.out.println(string);
	  }else {
		  System.out.println("login sucessful");
	  }
	}
//closing browser
	@Then("close browser invalid")
	public void close_browser_invalid() {
		 wd.closebrowser(loginpage.closebrowser());
	}

}
