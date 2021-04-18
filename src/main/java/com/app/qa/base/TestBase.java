package com.app.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.app.qa.util.TestUtils;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip= new FileInputStream(System.getProperty("user.dir")
					+"/src/main/java/com/app"
					+"/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\shyam\\java-selenium\\drivers\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\shyam\\java-selenium\\drivers\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		else if(browserName.equals("edge")){
			System.setProperty("webdriver.edge.driver", "C:\\Users\\shyam\\java-selenium\\drivers\\Edgedriver.exe");	
			driver = new EdgeDriver(); 
		}
		//forhtml unit driver is use full forthe head less testing
		/*else if(browserName.equals("FF")){
			System.setProperty("webdriver.edge.driver", "C:\\Users\\shyam\\java-selenium\\drivers\\Edgedriver.exe");	
			driver = new HtmlUnitDriver(); 
		}*/
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtils.Implicity_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtils.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
}
