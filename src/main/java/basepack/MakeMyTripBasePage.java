package basepack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilPack.MakeMyTripUtils;

public class MakeMyTripBasePage {
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	
	public MakeMyTripBasePage() {
		prop= new Properties();
		
		try {
			fis= new FileInputStream("C:\\Users\\vijay\\eclipse-workspace\\MakeMytripNaveenAssignment4April2019\\src\\main\\java\\configPack\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void initialization() {
		
		String browsername=prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\vijay\\Downloads\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();			
		}
		else 
			if(browsername.equalsIgnoreCase("ff")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\vijay\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
				    driver = new FirefoxDriver();			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(MakeMyTripUtils.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(MakeMyTripUtils.implicit_wait_timeout, TimeUnit.SECONDS)	;
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		  System.out.println("after init method");
			 // System.out.println("after finding deny button webelement ");
			  System.out.println("before explicit wait ");

			  WebDriverWait wait= new WebDriverWait(driver, 20);
			  driver.switchTo().frame("webpush-bubble");
			  System.out.println("after switching to frame ");
			  WebElement denybutton =driver.findElement(By.xpath("//button[@id=\"deny\"]"));
		      System.out.println("after finding deny button webelement ");

			  wait.until(ExpectedConditions.elementToBeClickable(denybutton));
			  denybutton.click();
			  driver.switchTo().defaultContent();
		      System.out.println("after switching to default content");


	}
}
