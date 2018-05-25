package trigavo.task2;

import org.testng.annotations.Test;

import trigavo.task2.Country;

public class CountryTest extends AbstractTest {
	
	Country ct = new Country();
	private String country = "Ireland";
	private String countryUrl = "http://magazine.trivago.ie/";
  @Test
  public void verifyLocaleTest() {
	  
	  ct.selectCountryDropdwonMenu();
	  ct.selectCountryFormList(country);
	  ct.confirmSelectedCountry(countryUrl);
  }
}
