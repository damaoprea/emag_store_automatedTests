package Damaris.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;

public class HomePage {
	private String PAGE_URL = "https://www.emag.ro/";
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		driver.get(PAGE_URL);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//div[10]/div/div[2]/button[1]")
	private WebElement cookies;
	
	@FindBy(css = ".dismiss-btn")
	private WebElement dismissLoging;
	
	@FindBy(css = "button.close > i")
	private WebElement dismissOfertaZilei;
	
	@FindBy(id = "searchboxTrigger")
	private WebElement searchBox;
	
	public void acceptCookies() throws InterruptedException {
		cookies.click();
		dismissLoging.click();
		dismissOfertaZilei.click();
	}
	
	public void search(String item) {
		searchBox.click();
		searchBox.sendKeys(item);
		searchBox.sendKeys(Keys.ENTER);
		
	}	
	
}
