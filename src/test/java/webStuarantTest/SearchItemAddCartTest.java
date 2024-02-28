package webStuarantTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Utility.BasePage;
import Utility.Constants;
import WebstuarantPage.SearchPage;

public class SearchItemAddCartTest extends BasePage{
	SearchPage s = new SearchPage(null);
	Constants c = new Constants();

	
	@Test (priority = 1)
	public void goToPage() {
		s.browserUrl(c.chrome,c.baseUrl);
		s.verifyPageLoaded();
	}
	
	@Test (priority = 2)
	public void searchTheResult() {
		s.searchItem(c.searchValue);
		s.verifySearchResult();
	}
	
	@Test (priority = 3)
	public void checkTheTitle() {
		s.isWordInItemTitle(c.wordTable);
	}
	
	@Test (priority = 4)
	public void addToTheCart() {
		s.addCart();
		s.verifyItemIsAdddedToCart();
	}
	
	@Test (priority = 5)
	public void emptyTheCart() {
		s.emptyCart();
		s.verifyCartisEmpty();
	}
	
	@AfterClass
	public void afterclass() {
		driver.quit();
	}
}
