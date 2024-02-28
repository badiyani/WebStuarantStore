package Utility;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	protected WebDriver driver;
	
	public BasePage() {
		
	}

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getWebdriver() {
		return driver;
	}
	
	public void setupDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
			
	}

	public Actions getActions() {
		return new Actions(this.driver);
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public void clear(By locator) {
		driver.findElement(locator).clear();
	}

	public void type(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public String getAttribute(By locator, String Attribute) {
		return driver.findElement(locator).getAttribute(Attribute);
	}
	
	public WebElement getElement(By locator) {
		driver.findElement(locator).isDisplayed();
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		driver.findElement(locator).isDisplayed();
		return driver.findElements(locator);
	}
	
	public void waitForElementPresent(By locator) {
		final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public boolean isElementPresent(By by) {
		boolean value;
		try {
			driver.findElement(by).isDisplayed();
			value = true;
		} catch (final NoSuchElementException e) {
			value = false;
		}
		return value;
	}
	public void waitForPage(int sec) {
		final JavascriptExecutor je = (JavascriptExecutor) driver;
		final int waitTime = sec * 1000;
		int counter = 0;
		counter = 0;
		Long ajaxCount = (long) -1;
		do {
			try {
				Thread.sleep(1000);
			} catch (final InterruptedException e1) {
				e1.printStackTrace();
			}
			counter += 1000;
			try {
				ajaxCount = (Long) ((je)).executeScript("return window.dwr.engine._batchesLength");
			} catch (final WebDriverException e) {

			}
		} while (ajaxCount.intValue() > 0 && counter < waitTime);
	}
	
	public boolean isDisplayed(By locater) {
		final boolean i = getWebdriver().findElement(locater).isDisplayed();
		return i;
	}
	
	public void scrollIntoView(WebElement element) {
		final JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", element);
		waitForPage(10);
	}
	
	public void scrollDown(By locator) {
		final JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", getElement(locator));
		final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void alertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public void escape() {
		Actions action = new Actions(driver); 
		action. sendKeys(Keys. ESCAPE);
	}
	
	public void moveToElement(WebElement element) {
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		actions.moveToElement(element);
	}
	
	public void highlightElement(WebElement element) {
        for (int i = 0; i <2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 2px solid yellow;");
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
            }
        }
	
	
}
