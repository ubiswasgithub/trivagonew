package trigavo.task2;

import org.testng.annotations.Test;

import trigavo.task2.LocationSearch;

public class LocationSearchTest extends AbstractTest{
	LocationSearch ls = new LocationSearch();
	private String location = "USA";
	
	
	
  @Test(alwaysRun = true)
  public void verifyLocationSearchTest() {
	  ls.selectSearchIcon();
	  ls.enterSearchKeyword(location);
	  ls.searchResultIsFound();
	  ls.closeSearchResult();	  
	  
  }
}
