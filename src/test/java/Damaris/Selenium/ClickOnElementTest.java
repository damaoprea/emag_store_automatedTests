package Damaris.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnElementTest {
	private WebDriver driver;
	
	public ClickOnElementTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//div[@id=\"card_grid\"]/div[1]/div/div/div[@class=\"card-v2-content\"]/div[1]/p[2]")
	public WebElement searchScreenProductPrice;
	
	@FindBy(xpath = "//div[@id=\"card_grid\"]/div[1]/div/div/div[@class=\"card-v2-info\"]/div/h2/a")
	public WebElement searchScrenProductName;
	
	@FindBy(xpath = "//div[@class=\"pricing-block  has-installments\"]/p[@class=\"product-new-price\"]")
	public WebElement productDetailsPageProductPrice;
	
	@FindBy(xpath = "//h1[@class=\"page-title\"]")
	public WebElement productDetailsPageProductName;	
}