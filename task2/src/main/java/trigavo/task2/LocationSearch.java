package trigavo.task2;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class LocationSearch {
	
	By element_search_icon = new By.ByXPath("//div[@class='search-icon']");
	By element_search_input = new By.ByXPath("//input[@class='input search-input']");
	By element_search_result = new By.ByXPath("//h3[@class='section-title']");
	By element_search_close_icon = new By.ByXPath("//div[@class='search-icon open']");
	
	UiHelper uihelper = new UiHelper();
	Home home = new Home();
	private WebElement el;
	
	public void selectSearchIcon(){
		el = Browser.getDriver().findElement(element_search_icon);
		uihelper.click(el);
	}
	
	public void enterSearchKeyword(String key){
		el = Browser.getDriver().findElement(element_search_input);
		uihelper.enterText(el, key);
		el.sendKeys(Keys.RETURN);
	}
	
	public void searchResultIsFound(){
		uihelper.waitForElementTorender();
		List<WebElement> els = Browser.getDriver().findElements(element_search_result);
		Assert.assertTrue(!uihelper.getText(els.get(0)).isEmpty());
		
	}
	
	public void closeSearchResult(){
		el = Browser.getDriver().findElement(element_search_close_icon);
		uihelper.click(el);
		home.clickToHomeLink();
	}

}
