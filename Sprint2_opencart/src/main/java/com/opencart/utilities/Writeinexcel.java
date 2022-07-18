package com.opencart.utilities;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
/*
 * 1.This class is used to write the captured product details into an excel file
 * 
 */
public class Writeinexcel  {
	//creating a parameterized constructor of list of strings
public Writeinexcel(List<String> product_det) {
	
	int rowcount;
	File file2 = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Final_product_details.xlsx");
	FileInputStream inputStream = null;
	try {
		inputStream = new FileInputStream(file2);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	XSSFWorkbook wb1 = null;
	try {
		wb1 = new XSSFWorkbook(inputStream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	XSSFSheet sheet = wb1.getSheet("sheet1");
	rowcount=sheet.getLastRowNum();
	Row row=sheet.getRow(rowcount+1);//fetching the existing row
	Row newRow = sheet.createRow(rowcount+1);//creating new row to write
	//iterating loop to store the array of elements
	for(int g=0;g<product_det.size();g++) {
		Cell cell = newRow.createCell(g);
		cell.setCellValue(product_det.get(g));
	}
	try {
		inputStream.close();//closing inputstream
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	FileOutputStream outputStream = null;
	try {
		outputStream = new FileOutputStream(file2);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		wb1.write(outputStream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		outputStream.close();//closing the output stream
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
