package integrationTest.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import net.jcip.annotations.ThreadSafe;

public class MyStore {
	
	private static WebDriver driver;
	public static WebDriverWait webWait;
	public static String orderReference;
	
/*	public MyStore(WebDriver driver){
		MyStore.driver=driver;
	}*/
	
	public static String appUrl="http://automationpractice.com";
	//public static MyStore ObjForMyStore=new MyStore(driver); 
	
	public static void main(String args[]) throws InterruptedException{
		setDriver("chrome", appUrl);
		appLogin("someone@example.com", "Password123");
		tShirtOrder();		
		orderValidation();
		personalUpdate("Password123");
	}
	
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
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;		
	}
	private static WebDriver initIEDriver(String URL){
		System.setProperty("webdriver.ie.driver", "F:\\Official\\selenium\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		driver.manage().deleteAllCookies();
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;		
}
	private static WebDriver initFirefoxDriver(String URL){
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;		
}
	
	public static void appLogin(String userName, String password) throws InterruptedException{
		//webWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='login']"))).click();
		/*Thread.sleep(10000);
		WebElement element=driver.findElement(By.xpath("//a[@class='login']"));
		element.click();*/
		//webWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='login']")));
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		//webWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Authentication']")));
		driver.findElement(By.xpath("(//label[text()='Email address'])[2]/following-sibling::input")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);
		driver.findElement(By.xpath("(//button[@type='submit']//span)[3]")).click();
	}
	
	public static void tShirtOrder() throws InterruptedException{
		/*webWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@title='T-shirts'])[2]"))).click();
		webWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='product_img_link']//img"))).click();*/
		
		Thread.sleep(5000);
		WebElement element =driver.findElement(By.xpath("(//a[@title='T-shirts'])[2]"));
		element.click();
		Thread.sleep(5000);
		/*element=driver.findElement(By.xpath("//a[@class='product_img_link']//img"));
		element.click();*/
		//webWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='image-block']"))).isDisplayed();
		Thread.sleep(5000);
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@class='product_img_link']//img"))).build().perform();
		element=driver.findElement(By.xpath("//span[text()='Add to cart']"));
		element.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Proceed to checkout')])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[contains(text(),'Proceed to checkout')])[2]")).click();
		action.moveToElement(driver.findElement(By.xpath("//input[@type='checkbox']"))).click().build().perform();
		driver.findElement(By.xpath("(//span[contains(text(),'Proceed to checkout')])[2]")).click();
		Thread.sleep(3000);
		element=driver.findElement(By.xpath("//a[@title='Pay by bank wire']"));
		element.click();
		//webWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='I confirm my order']"))).click();
		Thread.sleep(3000);
		element=driver.findElement(By.xpath("//span[text()='I confirm my order']"));
		element.click();
		Thread.sleep(3000);
		orderReference=driver.findElement(By.xpath("//div[@class='box']")).getAttribute("innerText");
		}
	
	public static void orderValidation() throws InterruptedException{
		JavascriptExecutor jsx=(JavascriptExecutor)driver;
		driver.findElement(By.xpath("//a[@class='account']//span")).click();
		Thread.sleep(5000);
		//WebElement element=driver.findElement(By.xpath("//a[@title='Orders']//span"));
		/*WebElement element=driver.findElement(By.xpath("//span[text()='Order history and details']"));
		element.click();*/
		driver.findElement(By.linkText("ORDER HISTORY AND DETAILS")).click();
		//jsx.executeScript("arguments[0].click;", element);
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		String orderValidation=driver.findElement(By.xpath("(//td[@class='history_link bold']//a)[1]")).getAttribute("innerText").trim();
		Assert.assertTrue(orderReference.contains(orderValidation), "Recent ordered item is not in the top list in Order history table");
		System.out.println("Scenario 1 PASSED");
		}
	
	public static void personalUpdate(String currentPassword) throws InterruptedException{
		driver.findElement(By.xpath("//a[@class='account']//span")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("MY PERSONAL INFORMATION")).click();
		Thread.sleep(3000);
		WebElement element=driver.findElement(By.xpath("//label[@for='firstname']/following-sibling::input"));
		element.clear();
		element.sendKeys("Yoga");
		driver.findElement(By.xpath("//label[@for='old_passwd']/following-sibling::input")).sendKeys(currentPassword);
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		System.out.println("Scenario 2 PASSED");
		
	}
}
