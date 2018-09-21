package integrationTest.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import integrationTest.pageObject.MyStore;

public class DriverSetup {
	
	public static WebDriver driver;
	public static WebDriverWait webWait;
	public static String appUrl="http://automationpractice.com";
	//public static MyStore ObjForMyStore=new MyStore(driver); 
	
	public static void setDriver(String browserType, String applicationUrl){
		appUrl=applicationUrl;
		
		switch(browserType){
		case "chrome":
			driver=initChromeDriver(appUrl);
			break;
			
		case "firefox":
			driver=initFirefoxDriver(appUrl);
			break;
			
		case "ie":
			driver=initIEDriver(appUrl);
		}
	}
	
	private static WebDriver initChromeDriver(String URL){
		System.setProperty("webdriver.chrome.driver", "F:\\Official\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.navigate().to(URL);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;
	}
		
		private static WebDriver initIEDriver(String URL){
			System.setProperty("webdriver.ie.driver", "F:\\Official\\selenium\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
			WebDriver driver=new InternetExplorerDriver();
			driver.manage().deleteAllCookies();
			driver.navigate().to(URL);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			return driver;		
	}
		private static WebDriver initFirefoxDriver(String URL){
			
			WebDriver driver=new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.navigate().to(URL);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			return driver;		
	}

}
