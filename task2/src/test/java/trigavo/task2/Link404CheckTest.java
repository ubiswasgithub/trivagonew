package trigavo.task2;

import org.testng.annotations.Test;

public class Link404CheckTest extends AbstractTest {
	Link404Check lc = new Link404Check();
  @Test
  public void verifyLink404Error() {
	  lc.selectPostTitle();
  }
}
