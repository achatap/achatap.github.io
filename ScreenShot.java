package accelerate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;


public class ScreenShot {

	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = null ;
		String browser= "firefox";
		
		switch(browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver","C:\\Webdrivers\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    	
	    	break;
	    	
		case "firefox":
			System.setProperty("webdriver.gecko.driver","C:\\Webdrivers\\geckodriver.exe");
	    	driver = new FirefoxDriver();
	    	break;
	    	
		case "ie":
			
			System.setProperty("webdriver.ie.driver","C:\\Webdrivers\\IEDriverServer.exe");
			
//			InternetExplorerOptions capabilities = new InternetExplorerOptions();
//			capabilities.ignoreZoomSettings();
//			driver = new InternetExplorerDriver(capabilities);
			
//			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
//			caps.setCapability("ignoreZoomSetting", true);	
//			driver = new InternetExplorerDriver(caps);
			
			driver = new InternetExplorerDriver();
	    	break;
	    	
		case "edge":
			System.setProperty("webdriver.edge.driver","C:\\Webdrivers\\msedgedriver.exe");
	    	driver = new EdgeDriver();
	    	break;
	    	
		case "opera":
			System.setProperty("webdriver.opera.driver","C:\\Webdrivers\\operadriver.exe");
	    	driver = new OperaDriver();
	    	break;
	    
	    	
		}
		
        driver.get("https://www.album.alexflueras.ro/index.php");
        
        driver.manage().window().maximize(); 
        
        Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE_SCROLL_AND_STITCH, 1000, true).save("E:\\NewElementScreenshot");

        Thread.sleep(2000);
        driver.quit();
        
      

	}

}
