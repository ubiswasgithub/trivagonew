package trigavo.task2;

import org.testng.annotations.Test;

import trigavo.task2.Contact;

public class ContactTest extends AbstractTest {
	Contact ct = new Contact();
	private String message = "Test Message";
	private String email = "test@gmail.com";
	private String fullanme = "Tester";
	
	@Test
  public void verifyContactTest() {
	  
	  ct.goToContactPage();
	  ct.enterMessage(message);
	  ct.enterFullName(fullanme);
	  ct.enterMail(email);
	  ct.selectSubmitButton();
	  ct.confirmSubmission();
  }
}
