package com.opencart.utilities;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*
 * 1.this class is used to read registration details excel file
 * 2.storing the data into corresponding variables
 */
public class ReadRegister {
	//declaring variables as public to access them throughout the project 
public List<String> firstname=new ArrayList<String>();
public List<String> lastname=new ArrayList<String>();
public  List<String> email=new ArrayList<String>();
public  List<String> telephone=new ArrayList<String>();
public  List<String> password=new ArrayList<String>();
//this constructor used to read excel once the object is created
public ReadRegister() {
	File file=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\registration details.xlsx");
	XSSFWorkbook wb = null;
	try {
		wb = new XSSFWorkbook(file);
	} catch (InvalidFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	XSSFSheet sheet=wb.getSheetAt(0);
	try {
		FileInputStream fileinp=new FileInputStream(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int rowcount=sheet.getLastRowNum();
	//adding data
	for(int i=1;i<=rowcount;i++) {
		firstname.add(sheet.getRow(i).getCell(0).toString());
		lastname.add(sheet.getRow(i).getCell(1).toString());
		email.add(sheet.getRow(i).getCell(2).toString());
		telephone.add(sheet.getRow(i).getCell(3).getRawValue());
		password.add(sheet.getRow(i).getCell(4).toString());
		
	}
}

}
