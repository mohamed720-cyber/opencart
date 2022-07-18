package Step_Definitions;

import static org.junit.Assert.assertArrayEquals;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import com.opencart.utilities.ReadRegister;

import Baseclass.Testbase;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import page_factories.Register_pagefac;

/*
 * 1.this class is used as a step definition class for account register.feature file
 * 2.it is used to register with both valid and invalid data
 */
public class Registration_cl {
	// creating object for base class
	Testbase wd = new Testbase();
	// creating object for page factory class
	Register_pagefac pf = new Register_pagefac(wd.openbrowser());
	String result;

	@Given("The user should have registration details to be filled")
	public void the_user_should_have_registration_details_to_be_filled() {
		pf.homepage();// verifying home page
		ReadRegister reg = new ReadRegister();// reading excel file

	}

	@When("User clicks on My Account and  select the register option")
	public void user_clicks_on_my_account_and_select_the_register_option() {

		pf.selectregister();// opening registration page
		pf.registertest();// verifying registration page
	}

	@And("User fill the mandatory details in the registration page")
	public void user_fill_the_mandatory_details_in_the_registration_page() {
		ReadRegister reg = new ReadRegister();
//passing data as parameters
		try {
			result = pf.registerforvalid(reg.firstname, reg.lastname, reg.email, reg.telephone, reg.password);
		} catch (Exception e) {
			System.out.println("stale error");
		}

	}

	@And("User click on continue button and capture the result")
	public void user_click_on_continue_button_and_capture_the_result() {
		System.out.println("The result is captured " + result);// printing result
	}

	@Then("Validate the confirmation message in the account page")
	public void validate_the_confirmation_message_in_the_account_page() {
		pf.valid(result);// validating the result
		wd.closebrowser(pf.closebrowsers());// closing the browser

	}

	@Given("The user should enter invalid data")
	public void the_user_should_enter_invalid_data() {
		ReadRegister reg = new ReadRegister();// reading excel file

	}

	@When("User clicks on my account and select register option")
	public void user_clicks_on_my_account_and_select_register_option() {
		pf.selectregister();// opening registration page
	}

	@And("User needs to fill the registration details")
	public void user_needs_to_fill_the_registration_details() {
		ReadRegister reg = new ReadRegister();
		try {
			// passing parameters
			result = pf.registerforinvalid(reg.firstname, reg.lastname, reg.email, reg.telephone, reg.password);
		} catch (Exception e) {
			System.out.println("stale error");
		}

	}

	@And("click continue and capture the result")
	public void click_continue_and_capture_the_result() {
		System.out.println("The result is captured " + result);// printing result

	}

	@Then("validate the confirmation of the registration.")
	public void validate_the_confirmation_of_the_registration() {
		pf.invalid(result);// validating invalid results
		wd.closebrowser(pf.closebrowsers());// closing browser
	}

}
