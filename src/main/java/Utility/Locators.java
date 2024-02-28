package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locators{

	WebDriver driver;
	public By searchBar = By.xpath("(//input[@id='searchval'])[1]");
	public By searchButton = By.xpath("(//button[@value='Search'])[1]");
	public By firstresult = By.xpath("(//div[@data-testid='product-listing-container']/div/div/a/span[@data-testid = 'itemDescription'])[1]");
	public By listofResult = By.xpath("//div[@data-testid='product-listing-container']/div/div/a/span[@data-testid = 'itemDescription']");
	public By productTitle = By.xpath("//div[@data-testid='productBoxContainer']//span[@data-testid = 'itemDescription']");
	public By nextPage = By.xpath("//div[@data-testid='paging']/nav/ul/li[last()]");
	public By listofPage = By.xpath("//div[@data-testid='paging']/nav/ul/li");
	public By addtoCartButton = By.xpath("//input[@data-testid = 'itemAddCart']");
	public By lastProductOfSearch = By.xpath("//div[@data-testid='productBoxContainer'][last()]");
	public By viewCartButton = By.xpath("//a[@data-testid = 'cart-button']");
	public By emptyCartButton = By.xpath("//div[@data-hypernova-key= 'EmptyCart']/button");
	public By itemPresent = By.xpath("//span[contains(@class,'itemDescription')]");
	public By notifViewcart = By.xpath("(//div[@id='watnotif-wrapper']/div[@data-role='notification']/p/div/div/a)[1]");
	public By alertEmptyBtton = By.xpath("(//div/footer[@data-testid='modal-footer']/button)[1]");
	public By cartEmptyContainer = By.xpath("//div[contains(@class, 'cartEmpty')]");
}
