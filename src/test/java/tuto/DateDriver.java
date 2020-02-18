package tuto;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.poi.ss.formula.functions.Value;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class DateDriver {
	
	public static void main(String args[]) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        Result result = junit.run(DateDriver.class); // Replace "SampleTest" with the name of your class
        if (result.getFailureCount() > 0) {
          System.out.println("Test failed.");
          System.exit(1);
        } else {
          System.out.println("Test finished successfully.");
          System.exit(0);
        }
      }

	private WebDriver driver;
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;
	private By seachBoxLocator = By.id("search_query_top");
	private By summitBtn = By.name("submit_search");
	private By resulTextLocator = By.cssSelector(".heading-counter");
	
	@Before
	public void setUp() throws Exception{
		//System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		//driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		writeFile = new WriteExcelFile();
		readFile = new ReadExcelFile();
		driver.get("http://automationpractice.com");
	}
	
	@Test
	public void test() throws IOException {
		String filepath = "C:\\Users\\usuario\\Documents\\Test.xlsx";
		for (int i = 0; i <= readFile.getLastRowNumb(filepath,"Hoja1"); i++) {
			
		
			String searchText = readFile.getCellValue(filepath, "Hoja1", i, 0);
			driver.findElement(seachBoxLocator).sendKeys(searchText);
			driver.findElement(summitBtn).click();
			String resultText = driver.findElement(resulTextLocator).getText();
			System.out.println("Page result text:"+ resultText);
			readFile.readExel(filepath, "Hoja1");
			writeFile.writeCellValue(filepath, "Hoja1", i, 1, resultText);
			readFile.readExel(filepath, "Hoja1");
			driver.get("http://automationpractice.com");
			System.out.println(readFile.getLastRowNumb(filepath,"Hoja1"));
			assertTrue(true);
		}
	}
	
	@After
	public void tearDown() throws Exception{
		driver.quit();
	} 
}