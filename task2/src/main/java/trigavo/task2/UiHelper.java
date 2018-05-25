package trigavo.task2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UiHelper {
	private WebDriver driver;
	
	public UiHelper(){
		driver = Browser.getDriver();
	}

	public void click(WebElement el){
		
		if(el.isEnabled()){
			el.click();
		}
	}
	
	public void enterText(WebElement el, String txt){
		
		if(el.isEnabled()){
		
			el.sendKeys(txt);
		}
	}

	public String getText(WebElement el) {
		// TODO Auto-generated method stub		
		return el.getText().toString();
	}
	
	public void waitForElementTorender(){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void moveToElement(WebElement el){
		Actions actions = new Actions(Browser.getDriver());
		actions.moveToElement(el).perform();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void navigateLeftToRight(){
		Actions action= new Actions(Browser.getDriver());
		action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
		String url = Browser.getCurrentUrl();
		Browser.getDriver().get(url);
	}
	
	public void navigateRightToLeft(){
		Actions action= new Actions(Browser.getDriver());
		action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();
	}
	
	
	public void scrollTillEnd(){
		((JavascriptExecutor) Browser.getDriver())
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	
	public void switchToNewWindow(){
		

		String Tab1 = Browser.getDriver().getWindowHandle(); 
		ArrayList<String> availableWindows = new ArrayList<String>(Browser.getDriver().getWindowHandles()); 
		if (!availableWindows.isEmpty()) { 
			Browser.getDriver().switchTo().window(availableWindows.get(1)); 
		}
	}
	public void refreshCurrentPage() {
		// TODO Auto-generated method stub
		Browser.getDriver().navigate().to(Browser.getCurrentUrl());
		
	}

	public String getCureentUrl() {
		// TODO Auto-generated method stub
		return Browser.getDriver().getCurrentUrl().toString();
	}

	public void getBackToPreviousPage() {
		Browser.getDriver().navigate().back();
		waitForElementTorender();
		
	}
	
	
	public void checkHomePageLink(By el, int pos){
		List <WebElement> els = Browser.getDriver().findElements(el);
		String link = els.get(pos).getAttribute("href");			
		Browser.getDriver().get(link);				
	}
	
}
