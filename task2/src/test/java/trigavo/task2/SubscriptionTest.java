package trigavo.task2;

import org.testng.annotations.Test;

import trigavo.task2.Subscription;

public class SubscriptionTest extends AbstractTest{
	
	Subscription sc = new Subscription();
	private String emailaddr = "ubiswas@gmail.com";
	
	
  @Test
  public void verifyUserSubscriptionTest() {
	  sc.moveToNewsLetterSection();
	  sc.checkMarkNewsLetterConfirm();
	  sc.enterMailAddress(emailaddr);
	  sc.selectInspireMebutton();
	  sc.getConfirmationText();
	 
  }
}
