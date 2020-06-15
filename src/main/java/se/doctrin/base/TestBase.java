package se.doctrin.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import se.doctrin.utils.WebEventListener;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	String propertiesDirPath;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger log ;
		
	public TestBase(){
		try{
			
			propertiesDirPath=System.getProperty("user.dir") + "\\src\\main\\java\\se\\doctrin\\config\\config.properties";
			
			prop=new Properties();
			FileInputStream oFile=new FileInputStream(propertiesDirPath);
			prop.load(oFile);
			
			
		}
		catch(FileNotFoundException e) {
				e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
	   }
		
		
		
	}
	
	
public static void initialization(String browser){
		
		String browserName=browser;
	    //System.out.println(Thread.currentThread().getId());
		
		if (browserName.equals("chrome")) {
				
				//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\java\\org\\seleniumjava\\drivers\\chromedriver.exe");
				//ChromeOptions options = new ChromeOptions();
				//options.setPageLoadStrategy(PageLoadStrategy.NONE);
			  WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();
			}
		else if (browserName.equals("firefox")){
			System.out.println("Fireffox inside");
			//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\src\\main\\java\\se\\doctrin\\drivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		 	}	
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("urlName"));
		
		 e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		log=LogManager.getLogger("assignment");
		
		
	}

	

}
