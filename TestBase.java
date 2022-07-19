package com.sprint.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sprint.qa.util.POST_Method_2FAUtil;
import com.sprint.qa.util.TestUtil;


public class TestBase 
{	
	
	public static WebDriver driver;
	public static Properties prop;
	static Logger log = Logger.getLogger(TestBase.class);
					
   public TestBase() 
   {	
		try 
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Eclipse\\eclipse-workspace\\Sprint11_Regression\\src\\main\\java\\com\\sprint\\qa\\config\\config.properties");
			prop.load(fis);
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}		
	}
        
   public static void initialization() throws Exception 
   {	
		System.setProperty("webdriver.chrome.driver","C:\\cucumber\\chromedriver.exe");
		driver = new ChromeDriver(); //launch
     	driver.close();

		//driver.manage().window().maximize();

		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addExtensions(new File("C:\\cucumber\\extension_0_0_40_0.crx"));// @2FA authenticator app
		//chromeOptions.addExtensions(new File("C:\\cucumber\\extension_0_0_0_7.crx"));// @2FAst -code sender app
		//chromeOptions.addExtensions(new File("C:\\cucumber\\buster.crx"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);

		driver = new ChromeDriver(chromeOptions);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//call the post method
				
		POST_Method_2FAUtil.sendPost1();
	
		String append = "/redirect?token_type=Bearer&access_token="+POST_Method_2FAUtil.ACCESS_TOKEN+"&refresh_token="+POST_Method_2FAUtil.REFRESH_TOKEN+"&url=/" ;
//		System.out.println(append);
				
//		driver.get(prop.getProperty("url+("+append+")"));
//		String url = "https://phoenix-shadow.presidio.com/#/redirect?token_type=Bearer&access_token="+POST_Method_2FA.ACCESS_TOKEN+"&refresh_token="+POST_Method_2FA.REFRESH_TOKEN+"&url=/";
		
//		driver.get(url);
		driver.get(prop.getProperty("url1")+append);
		
   }
   
   public static void initialization1() throws Exception 
   {	
	   
//		System.setProperty("webdriver.chrome.driver","C:\\cucumber\\Webchromedriver.exe");
//		driver = new ChromeDriver(); //launch
//     	driver.close();

		//driver.manage().window().maximize();

//		ChromeOptions chromeOptions = new ChromeOptions();
//		//chromeOptions.addExtensions(new File("C:\\cucumber\\extension_0_0_40_0.crx"));// @2FA authenticator app
//		//chromeOptions.addExtensions(new File("C:\\cucumber\\extension_0_0_0_7.crx"));// @2FAst -code sender app
//		//chromeOptions.addExtensions(new File("C:\\cucumber\\buster.crx"));
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);

//		driver = new ChromeDriver(chromeOptions);
//
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
//		
//		//call the post method
//		
//		POST_Method_2FAUtil.sendPost1();
		
//		String append = "/redirect?token_type=Bearer&access_token="+POST_Method_2FAUtil.ACCESS_TOKEN+"&refresh_token="+POST_Method_2FAUtil.REFRESH_TOKEN+"&url=/" ;
		
//		System.out.println(append);
				
//		driver.get(prop.getProperty("url+("+append+")"));
		
//		String url = "https://phoenix-shadow.presidio.com/#/redirect?token_type=Bearer&access_token="+POST_Method_2FAUtil.ACCESS_TOKEN+"&refresh_token="+POST_Method_2FAUtil.REFRESH_TOKEN+"&url=/";
		
//		driver.get(url);
		
	   	String a = "window.open('about:blank','_blank');";
			
	   	((JavascriptExecutor)driver).executeScript(a);
	   	
	   	driver.switchTo().activeElement();
	   	
	   	Set<String> Allhandles = driver.getWindowHandles();
	   	
		for( String childWindow1 : Allhandles) {

			driver.switchTo().window(childWindow1);

			Thread.sleep(2000);

		}
	   	
		driver.get(prop.getProperty("url3"));
		
   }
   
}
  
