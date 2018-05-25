package trigavo.task2;

import org.testng.annotations.Test;

import trigavo.task2.Destination;

public class DestinationTest extends AbstractTest{
	Destination dt = new Destination();
	private String dest = "INTERNATIONAL";
  @Test
  public void verifyDestinationTest() {
	  dt.selectDetinationMenu();
	  dt.selectDestination(dest);
	  dt.confirmSelectedDestination(dest);
  }
}
