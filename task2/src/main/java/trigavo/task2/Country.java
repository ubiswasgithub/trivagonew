package trigavo.task2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Verify;

public class Country {
	
	By element_country_dropdownmenu = By.xpath("//select[@class='locales-dropdown']");
	By element_country_list = By.xpath("//select[@class='locales-dropdown']/option");
	
	
	UiHelper uihelper = new UiHelper();
	private WebElement el;
	
	public void selectCountryDropdwonMenu(){	
		uihelper.scrollTillEnd();
		el = Browser.getDriver().findElement(element_country_dropdownmenu);
		uihelper.click(el);
	}
	
	public void selectCountryFormList(String txt){
		List<WebElement>els = Browser.getDriver().findElements(element_country_list);
		for(int i = 0; i < els.size(); i++){
			String countryName = els.get(i).getText().toString();
			if(countryName.equalsIgnoreCase(txt)){
				uihelper.moveToElement(els.get(i));
				uihelper.click(els.get(i));
			}
			
		}
	}
	
	public void confirmSelectedCountry(String txt){
		uihelper.waitForElementTorender();
		Verify.verify(uihelper.getCureentUrl().equalsIgnoreCase(txt));
	}
	

}
