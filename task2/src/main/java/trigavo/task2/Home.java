package trigavo.task2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Home {
	
	By element_home_link = new By.ByXPath("//a[@class='logo router-link-exact-active router-link-active room5-logo']");
	By element_contact_link = new By.ByLinkText("Contact");
	
	
	UiHelper uihelper = new UiHelper();
	private WebElement el;
	
	public void clickToHomeLink(){
		el = Browser.getDriver().findElement(element_home_link);
		uihelper.click(el);
	}
	
	public void clickContactlink(){
		el = Browser.getDriver().findElement(element_contact_link);
		uihelper.scrollTillEnd();
		uihelper.click(el);		
		uihelper.switchToNewWindow();
		
	}
	

}
