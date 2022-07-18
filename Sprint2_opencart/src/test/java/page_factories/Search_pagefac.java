package page_factories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencart.utilities.Readproduct;

import junit.framework.Assert;

/*
 * this class used as a page factory for search.feature
 */
public class Search_pagefac {
	// global declaration
	public List<String> prod_details = new ArrayList<String>();

	WebDriver driver;
	Readproduct readprd = new Readproduct(); // reading excel file
	@FindBy(name = "search") // search box
	WebElement search;
	@FindBy(xpath = "//button[@id='list-view']") // list view button
	WebElement list;
	@FindBy(xpath = "//button[@id='grid-view']") // grid view button
	WebElement grid;
	@FindBy(xpath = "//select[@id='input-sort']") // sortby button
	WebElement sortby;
	@FindBy(xpath = "//select[@id='input-limit']") // show button
	WebElement show;
	@FindBy(xpath = "//button[@onclick]") // addtocart button
	WebElement addtocart;
	@FindBy(xpath = "//a[@title='Shopping Cart']") // shopping cart button
	WebElement shopcart;
	@FindBy(xpath = "//p[2]") // error message
	WebElement errormsg;

	// initiating page factory
	public Search_pagefac(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// searching the valid product
	public void searchproduct() {
		search.sendKeys(readprd.product_name.get(0));
		search.sendKeys(Keys.ENTER);
	}

	// searching the invalid product
	public void searchproductinvalid() {
		search.sendKeys(readprd.product_name.get(1));
		search.sendKeys(Keys.ENTER);
	}

	// capturing the error message
	public String errormessage() {
		String errormg = errormsg.getText();

		return errormg;
	}

	// filtering the product based on the inputs from the excel file
	public void filterproduct() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if (readprd.view.get(0).equalsIgnoreCase("list")) {
			list.click();
		} else if (readprd.view.get(0).equalsIgnoreCase("grid")) {
			grid.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(sortby));
		Select sortbyvalues = new Select(sortby);

		sortbyvalues.selectByVisibleText(readprd.sort.get(0));
		wait.until(ExpectedConditions.elementToBeClickable(show));
		Select showbyvalues = new Select(show);
		if (readprd.show.get(0).equals("15")) {

			showbyvalues.selectByVisibleText("15");
		} else if (readprd.show.get(0).equals("25")) {
			showbyvalues.selectByVisibleText("25");
		} else if (readprd.show.get(0).equals("50")) {
			showbyvalues.selectByVisibleText("50");
		} else if (readprd.show.get(0).equals("75")) {
			showbyvalues.selectByVisibleText("75");
		} else if (readprd.show.get(0).equals("100")) {
			showbyvalues.selectByVisibleText("100");
		}

	}

	/*
	 * 1.adding product to cart 2.returning the page title
	 */
	public String addtocart() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(addtocart));
		addtocart.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(shopcart));
		shopcart.click();
		String shopcart = driver.getTitle();
		return shopcart;
	}

	// validating the shopping cart page
	public void shoppingcartTest(String title) {
		Assert.assertEquals("Shopping Cart", title);
	}
	/*
	 * 1.adding the product details 2.returning the list of strings
	 */

	public List<String> productdetails() {
		List<WebElement> ele=driver.findElements(By.xpath("//div[2]//tbody/tr"));
		for(WebElement e:ele) {
			prod_details.add(e.getText());
		}
		String[] arr =prod_details.toArray(new String [prod_details.size()]);
		String[] lines =arr[0].split("//R");
		String[] lines2 = lines[0].split("[*$]+");
		List<String> list = new ArrayList<String>(Arrays.asList(lines2));
		
		list.add(driver.findElement(By.xpath("//input[@value=1]")).getAttribute("value"));
		

		return list;

	}

	// validating with invalid product name
	public void invalidproduct(String error) {
		Assert.assertEquals("There is no product that matches the search criteria.", error);
	}

	// return the current web driver
	public WebDriver closebrowser() {
		return driver;
	}

}
