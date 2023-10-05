package Damaris.Selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;

import Damaris.Selenium.HomePage;
import Damaris.Selenium.ProductListPage;
import Damaris.Selenium.ProductDetailsPage;
import Damaris.Selenium.utilities;
import Damaris.Selenium.BascketDetailsPage;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {	
	private WebDriver driver;
	private HomePage homePage;
	private ProductListPage productListPage;
	private ProductDetailsPage productDetailsPage;
	private BascketDetailsPage bascketDetailsPage;

	@Before
	public void setUp() throws InterruptedException{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		homePage = new HomePage(driver);
		homePage.acceptCookies();
		productListPage = new ProductListPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		bascketDetailsPage = new BascketDetailsPage(driver);
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
//	@Test
//	public void searchIsWorking() throws InterruptedException{
//		homePage.search("samsung");
//		String expectedUrl = "https://www.emag.ro/search/samsung?ref=effective_search";
//		String actualUrl = driver.getCurrentUrl();
//		assertEquals(expectedUrl,actualUrl);
//		String expectedText = "rezultate in Telefoane Mobile pentru \"samsung\"";
//		String actualText = productListPage.resultsTitle.getText();
//		assertTrue(actualText.contains(expectedText));
//	}
//	
//	@Test
//	public void correctNumberOfItems() {
//		homePage.search("samsung");
//		int expectedItemsNumber = 60;
//		int actualItemsNumber = driver.findElements(By.cssSelector("div.card-item")).size();
//		assertEquals(expectedItemsNumber,actualItemsNumber);
//	}
	
//	@Test
//	public void correctProductDetails() {
//		homePage.search("samsung");
//		List<WebElement> items = driver.findElements(By.cssSelector("div.card-item"));
//		int actualItemsNumber = items.size();
//		Random rand = new Random();
//		int randomItem = rand.nextInt(actualItemsNumber);
//		items.get(randomItem).click();
//		productDetailsPage.addFavouriteButton.click();
//
//		List<WebElement> productTabs = driver.findElements(By.xpath("//ul[@id = \"product_navbar_sticky\"]/li/a"));
//		WebElement removedItem = productTabs.remove(0);
//		List<String> actualTabText = new ArrayList<String>();
//		for (int i = 0; i < productTabs.size(); i++) {
//			String[] tabText = productTabs.get(i).getText().split(" \\(");
//			actualTabText.add(tabText[0]);
//		}
////		List<String> expectedTabText = Arrays.asList("Specificatii", "Review-uri", "Intrebari si raspunsuri",
////				"Product Finder");
////		assertEquals(expectedTabText, actualTabText);
//		
//		productDetailsPage.seeMoreButton.click();
//		assertFalse(utilities.isElementPresent(productDetailsPage.seeMoreButton));
//	}
	
	
//	@Test
//	public void addToBascket() {
//		homePage.search("samsung");
//		List<WebElement> items = driver.findElements(By.cssSelector("div.card-item"));
//		int actualItemsNumber = items.size();
//		Random rand = new Random();
//		int randomItem = rand.nextInt(actualItemsNumber);
//		items.get(randomItem).click();
//		productDetailsPage.addToBasketButton.click();
//		
//		String expectedSuccesText = "Produsul a fost adaugat in cos";
//		String actualSuccesText = productDetailsPage.modalSuccesLabel.getText();
//		assertEquals(actualSuccesText,expectedSuccesText);
//		
//		assertTrue(utilities.isElementPresent(productDetailsPage.seeBascketDetails));
//		productDetailsPage.seeBascketDetails.click();
//		assertFalse(utilities.isElementPresent(productDetailsPage.purchasedModal));
//	}
	
	@Test
	public void verifyBascket() {
		homePage.search("samsung");
		List<WebElement> items = driver.findElements(By.cssSelector("div.card-item"));
		int actualItemsNumber = items.size();
		Random rand = new Random();
		int randomItem = rand.nextInt(actualItemsNumber);
		items.get(randomItem).click();
		productDetailsPage.addToBasketButton.click();
		productDetailsPage.seeBascketDetails.click();
		
		String actualCartItems = bascketDetailsPage.bascketIcon.getText();
		assertEquals("1", actualCartItems);
		
	}
}

