package com.opencart.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cucumber.api.cli.Main;
/*
 * 1.This class is used to read product excel file 
 * 2.Property file is used for fetching the project path
 */
public class Readproduct {
	//declaring variable as public for accessing globally
	public  List<String> product_name =new ArrayList<String>();
	public  List<String> view =new ArrayList<String>();
	public  List<String> sort =new ArrayList<String>();
	public  List<String> show =new ArrayList<String>();
	static Properties prop=new Properties();//creating object for properties file
	//reading and loading the properties data using this method
public static void readproperty() {
		
		try {
			InputStream input=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
			prop.load(input);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//this constructor used to read data from excel file and storing it in the corresponding variables
	public Readproduct() {//String sheetname,String column name
		//readproperty();
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\opencart products.xlsx");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();
		//adding data
		for(int i=1;i<=rowcount;i++) {
			product_name.add(sheet.getRow(i).getCell(0).toString());//change
			view.add(sheet.getRow(i).getCell(1).toString());
			show.add(sheet.getRow(i).getCell(2).toString());
			sort.add(sheet.getRow(i).getCell(3).toString());
			
			
		}
		
	}
	
}
