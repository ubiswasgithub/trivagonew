package trigavo.task2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Verify;

public class Link404Check {
	By element_link_list = new By.ByXPath("//p[@class='post-title']/a");
			
	Home home = new Home();
	UiHelper uihelper = new UiHelper();
	private WebElement el;
	
	public void selectPostTitle()
	{
	
		int numberOfElementsFound = getNumberOfElementsFound(element_link_list);
		
		for (int pos = 0; pos < numberOfElementsFound; pos++) 
		{
				uihelper.checkHomePageLink(element_link_list, pos);			
				check404Status();
				uihelper.getBackToPreviousPage();
			
			
		}		
		
	}
	
	public void check404Status(){
		Verify.verify(!Browser.getDriver().getTitle().contains("404"));
	}
	
	public int getNumberOfElementsFound(By by) {
	    return Browser.getDriver().findElements(by).size();
	  }

	
	
	
}
