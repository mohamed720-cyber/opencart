package Baseclass;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
/*
 * 1.This class is used to read property file.
 * 2.Select the type of browser using the values in the config.properties file
 * 3.The open browser method will return the driver
 */
public class Testbase {
	//variable creation to store property values
	public String browser_type,url;
	//creating object for property file to read
	static Properties prop=new Properties();
	//this method "readproperty()" used to read and load the property file values.
	public static void readproperty() {
		
		try {
			InputStream input=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
			prop.load(input);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//this method "openbrowser()" is used to open a specific browser based on the browser type given in the config.properties file
	public WebDriver openbrowser() {
		readproperty();
		browser_type=prop.getProperty("browser");
		url=prop.getProperty("url");
		
		WebDriver driver = null;
		if(browser_type.equalsIgnoreCase("chrome")) {
			
			String browser_dir=prop.getProperty("user.dir_chrome");
			String user_dir=prop.getProperty("user.dir_chrome_path");
			System.setProperty(browser_dir, user_dir);
			driver=new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			
		}else if(browser_type.equalsIgnoreCase("firefox")){
			String browser_dir=prop.getProperty("user.dir_firefox");
			String user_dir=prop.getProperty("user.dir_firefox_path");
			System.setProperty(browser_dir,user_dir);
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().window().maximize();
			
		}
		
		return driver;//returning the browser driver
			
	}
	//this method used close the browser
	public void closebrowser(WebDriver driver) {
		driver.quit();//kill the driver instance
	
	}
	
	
	
}
