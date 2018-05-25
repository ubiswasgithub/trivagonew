package trigavo.task2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Hello world!
 *
 */
public class Browser 
{
	private static WebDriver driver;
	   

    public Browser(String browser){
      
    	
    	switch (browser) {
    	

		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "drivers\\ie\\IEDriverServer_win32.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("ignoreZoomSetting", true);
			driver = new InternetExplorerDriver(caps);
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options);
			break;
		}

		int timeout = 30;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
    
	}

    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Close the browser.
     *
     */
    public void quit() {
       
        getDriver().quit();
    }
   
    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

   
    public static String getPageTitle(){
        return driver.getTitle();
    }
    
   
    public static void resetTimeOuts(){
    	
        int timeout = 15;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(timeout, TimeUnit.SECONDS);
    }
}
