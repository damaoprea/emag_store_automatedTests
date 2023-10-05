package Damaris.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	private WebDriver driver;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//span[contains(@data-text-add,\"Adauga la Favorite\")])[1]")
	public WebElement addFavouriteButton;
	
	@FindBy(xpath = "//section[@id=\"seo-links\"]/div/div/div[@class=\"text-left\"]/p/a")
	public WebElement seeMoreButton;
	
	@FindBy(css = "div.product-buy-area-wrapper>div:first-child>button")
	public WebElement addToBasketButton;
	
	@FindBy(xpath = "//h4[contains(text(),\"Produsul a fost adaugat in cos\")]")
	public WebElement modalSuccesLabel;
	
	@FindBy(xpath = "//a[contains(text(),\"Vezi detalii cos\")]")
	public WebElement seeBascketDetails;
	
	@FindBy(className = "product-purchased-modal")
	public WebElement purchasedModal;
}