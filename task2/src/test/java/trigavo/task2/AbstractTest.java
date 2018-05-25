package trigavo.task2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import trigavo.task2.Browser;
import trigavo.task2.Nav;

public class AbstractTest {
protected Browser newBrowser;
protected String siteUrl = "http://room5.trivago.com/";
 
  @BeforeClass
  @Parameters("browser")
  public void beforeTest(@Optional("chrome") String browser) {
	  
	  newBrowser = new Browser(browser);
	  Nav.toURL(siteUrl);
  }

  @AfterClass
  public void closeAllBrowserAfterTest() {
	  
	  if(newBrowser!=null){
		  newBrowser.quit();
	  }
  }

}
