package Damaris.Selenium;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class utilities {
	public static boolean isElementPresent(WebElement element){
		boolean exists = false;
		try {
			element.getTagName();
			exists = true;
		} catch (NoSuchElementException e) {
			
		}
		return exists;	
	}

}
