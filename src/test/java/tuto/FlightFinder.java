package tuto;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightFinder extends BasePage {
	public FlightFinder(WebDriver driver) {
		super(driver);
	}
	
	public Boolean checkFlightFinder() {
		
		List <WebElement> fonts = driver.findElements(By.tagName("font"));
		for (WebElement font:fonts) {
			if (font.getText().startsWith("Use our Flight Finder")){
				return true;
			}
		}
		return false;
		
	}	

}