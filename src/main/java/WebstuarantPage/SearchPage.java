package WebstuarantPage;

import java.time.Duration;
import java.util.List;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.BasePage;
import Utility.Constants;
import Utility.Locators;

public class SearchPage extends BasePage{
	
	Locators l = new Locators();
	Constants c = new Constants();
	
	public SearchPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void browserUrl(String browser,String url) {
		setupDriver(browser);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void verifyPageLoaded() {
		Assert.assertTrue(isElementPresent(l.searchBar), "Element not found");
	}
	
	public void searchItem (String searchtext) {
		
		type(l.searchBar, searchtext);
		click(l.searchButton);
	}
	
	public void verifySearchResult() {
		Assert.assertTrue(isElementPresent(l.listofResult), "Search result nor present");
	}
	
	public boolean isWordInItemTitle(String word) {
		
		moveToElement(getElement(l.firstresult));
		List<WebElement> listofPage = getElements(l.listofPage);
		for (int i = 0; i < listofPage.size(); i++) {
			moveToElement(getElement(l.firstresult));
			List<WebElement> listofTitle = getElements(l.listofResult);
	        for (int j = 0; j < listofTitle.size(); j++) {
	            String title = listofTitle.get(j).getText();
	            highlightElement(listofTitle.get(j));
	            if (title.contains(word)) {	 
	            	System.out.println("Table is present");	            	
	            }
	            
	        }
	        scrollDown(l.nextPage);
	        click(l.nextPage);
	    }
		return true;			
	}
	
	public void addCart() {
		scrollDown(l.lastProductOfSearch);
		click(l.addtoCartButton);
		click(l.notifViewcart);
	}
	
	public void verifyItemIsAdddedToCart() {
		Assert.assertTrue(isElementPresent(l.itemPresent), "Item not added to the cart");
	}
	
	public void emptyCart() {
		click(l.emptyCartButton);
		click(l.alertEmptyBtton);
	}
	
	public void verifyCartisEmpty() {
		Assert.assertTrue(isElementPresent(l.cartEmptyContainer), "Cart is not empty");
	}
}
