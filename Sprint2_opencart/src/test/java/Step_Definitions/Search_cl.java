package Step_Definitions;

import java.util.ArrayList;
import java.util.List;

import com.opencart.utilities.Readproduct;
import com.opencart.utilities.Writeinexcel;

import Baseclass.Testbase;
import io.cucumber.java.en.*;
import page_factories.Register_pagefac;
import page_factories.Search_pagefac;
/*
 * this class is used as step definition class for searching for a valid and invalid products.
 */
public class Search_cl {
	//creating object for base class
	Testbase wd=new Testbase();
	List<String> prd_details=new ArrayList<String>();
	//creating object for page factory
	Search_pagefac sp=new Search_pagefac(wd.openbrowser());
	String errormsg,title;
	@Given("The user have the name of product to search and enter details to be filtered")
	public void the_user_have_the_name_of_product_to_search_and_enter_details_to_be_filtered() {
		Readproduct readprd=new Readproduct();//reading the excel file
	}

	@When("User enter the product name in the search box")
	public void user_enter_the_product_name_in_the_search_box() throws InterruptedException {
	sp.searchproduct();//searching for a product
	}


	@And("User filters the product page and click seacrh button")
	public void user_filters_the_product_page_and_click_seacrh_button() {
		
sp.filterproduct();//filtering the product
	}

	@And("User add the product to the shopping cart and click on shopping cart")
	public void user_add_the_product_to_the_shopping_cart_and_click_on_shopping_cart() {
title=sp.addtocart();//adding the product to the cart
	}

	@And("Capture the details from shopping cart page and save it in excel file")
	public void capture_the_details_from_shopping_cart_page_and_save_it_in_excel_file() {
	   prd_details=sp.productdetails();//extracting the required information from website
	   Writeinexcel wr=new Writeinexcel(prd_details);//writing in an excel file
	}

	@Then("validate with valid and invalid product")
	public void validate_with_valid_and_invalid_product() {
sp.shoppingcartTest(title);//verifying the website title
wd.closebrowser(sp.closebrowser());//closing the browser
	}
	@Given("The invalid details read from excel file")
	public void the_invalid_details_read_from_excel_file() {
		Readproduct readprd=new Readproduct();//reading excel file
	}

	@When("user searched for invalid product")
	public void user_searched_for_invalid_product() {
	   sp.searchproductinvalid();//searching for invalid product 
	}

	@When("capture the error message")
	public void capture_the_error_message() {
	    errormsg=sp.errormessage();//capturing error message
	    System.out.println("The captured error message is "+errormsg);
	}

	@Then("validate the result")
	public void validate_the_result() {
	sp.invalidproduct(errormsg);//validating the error message captured
	wd.closebrowser(sp.closebrowser());//closing the browser
	}
}
