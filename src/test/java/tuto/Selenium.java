package tuto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
	private WebDriver driver;
	LoginPage loginPage;
	FlightFinder flightFinder;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
		loginPage = new LoginPage(driver);
		flightFinder = new FlightFinder(driver);
		
	}
	
	@Test
	public void testGoogleSearch() {

		loginPage.writeLogin();
		assertTrue(flightFinder.checkFlightFinder());
		
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
}