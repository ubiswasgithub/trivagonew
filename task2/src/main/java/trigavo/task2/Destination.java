package trigavo.task2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Verify;

public class Destination {

	By element_nav_destination_icon = new By.ByXPath("//header[@class='header room5-style']//div[@class='fixed-header room5-style']//div[@class='nav-icon']");
	By element_destination_list = new By.ByXPath("//li[@class='item']");
	By element_selected_destination = new By.ByXPath("//h1[@class='section-title main']");
	
	
	UiHelper uihelper = new UiHelper();
	private WebElement el;
	
	public void selectDetinationMenu(){
		el = Browser.getDriver().findElement(element_nav_destination_icon);
		uihelper.click(el);
		
	}
	
	public void selectDestination(String txt){
		List<WebElement> els = Browser.getDriver().findElements(element_destination_list);
		
		for(int i = 0; i <els.size(); i++){
			if(els.get(i).getText().toString().equalsIgnoreCase(txt)){
				uihelper.click(els.get(i));
				break;
			}
		}
	}
	
	public void confirmSelectedDestination(String txt){
		el = Browser.getDriver().findElement(element_selected_destination);
		uihelper.waitForElementTorender();
		Verify.verify(uihelper.getText(el).equalsIgnoreCase(txt));
	}
	
}
