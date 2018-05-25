package trigavo.task2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.google.common.base.Verify;

public class Subscription {
	
	By element_newsletter_section = By.xpath("//section[@class='newsletter']");
	By element_newsletter_confirm =By.xpath("//input[@id='confirm']");
	By element_newsletter_mail = By.xpath("//input[@name='email']");
	By element_newsletter_inspireme_button = By.xpath("//button[@class='submit']");
	By element_newsletter_confirmation_text = By.xpath("//p[@class='submitted']");
	
	UiHelper uihelper = new UiHelper();
	WebElement el;
	private String subscriptionConfirmationText = "You are now checked-in!";
	
	public void moveToNewsLetterSection(){
		WebElement element = Browser.getDriver().findElement(element_newsletter_section);
		uihelper.moveToElement(element);
	}
	
	public void checkMarkNewsLetterConfirm(){
		el = Browser.getDriver().findElement(element_newsletter_confirm);
		uihelper.click(el);
	}
	
	public void enterMailAddress(String txt){
		el = Browser.getDriver().findElement(element_newsletter_mail);
		uihelper.enterText(el, txt);
	}
	
	public void selectInspireMebutton(){
		el = Browser.getDriver().findElement(element_newsletter_inspireme_button);
		uihelper.click(el);
	}
	
	public void getConfirmationText(){
		moveToNewsLetterSection();
		uihelper.waitForElementTorender();
		el = Browser.getDriver().findElement(element_newsletter_confirmation_text);
		Assert.assertTrue(uihelper.getText(el).equalsIgnoreCase(subscriptionConfirmationText));
	}

}
