package trigavo.task2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Verify;

public class Contact {
	
	By element_message = new By.ByXPath("//textarea[@class='contact-msg']");
	By element_full_name = new By.ByXPath("//input[@class='contact-input']");
	By element_mail = new By.ByXPath("//input[@id='contact-email']");
	By element_submit_button = new By.ByXPath("//button[@class='contact-submit']");
	By element_feedback_error = new By.ByXPath("//div[@class='feedback-error']");
	
	private String feedbackerror = "Please mark the checkbox.";
	
	UiHelper uihelper = new UiHelper();
	Home home = new Home();
	private WebElement el;
	
	public void goToContactPage(){			
		home.clickContactlink();
		uihelper.navigateLeftToRight();
		
	}
	
	public void enterMessage(String txt){
		el = Browser.getDriver().findElement(element_message);
		el.sendKeys(txt);
		uihelper.enterText(el, txt);
	}
	
	public void enterFullName(String message){
		el = Browser.getDriver().findElement(element_full_name);
		uihelper.enterText(el, message);
	}
	
	public void enterMail(String message){
		el = Browser.getDriver().findElement(element_mail);
		uihelper.enterText(el, message);
		uihelper.waitForElementTorender();
	}

	public void selectSubmitButton() {
		// TODO Auto-generated method stub
		el = Browser.getDriver().findElement(element_submit_button);
		uihelper.click(el);
	}
	
	public void confirmSubmission(){
		uihelper.waitForElementTorender();
		el= Browser.getDriver().findElement(element_feedback_error);
		String txt = uihelper.getText(el).toString();
		Verify.verify(!txt.equalsIgnoreCase(feedbackerror));
	}

}
