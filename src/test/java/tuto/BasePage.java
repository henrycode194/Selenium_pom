package tuto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
 
public class BasePage {
 
    protected WebDriver driver;
    WebElement element;
   
    // Constructor
    public BasePage(WebDriver driver) {
       this.driver = driver;
    }
 
 
    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
    
    public WebDriver window() {
         driver.manage().window().maximize();
         return driver;
    }
    
    // method
    public void navigateTo(String url) {
       driver.get(url);
    }
 
    // Click Method
    public void click(By elementBy) {
       driver.findElement(elementBy).click();
    }
    

 

 
    // Submit Method
    public void submit(By elementBy) {
       driver.findElement(elementBy).submit();
    }
 
    // Write Text
    public void writeText(By elementBy, String text) {
        driver.findElement(elementBy).sendKeys(text);
    }
   
    // Read Text
    public String readText(By elementBy) {
       return driver.findElement(elementBy).getText();
    }
   
    public void closeDriver() {
        driver.quit();
     }
   
    public boolean existElement(By elementBy) {
               Boolean isPresent = driver.findElements(elementBy).size() > 0;
        return isPresent;
    }
   
    
    public void selectDropDownOption(String i, By selectLocator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
      // wait.until(ExpectedConditions.elementToBeClickable(selectLocator));
                               Select select = new Select(driver.findElement(selectLocator));
                               select.selectByValue(i);        
    }
   
    public void waitForElementClickable(By selector, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(selector));    
    }
   
    public void waitForElement(By selector, int timeout) {
    	WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    	ewait.until(ExpectedConditions.presenceOfElementLocated(selector));
    	
    }
    public void switchToFrame (String idFrame) {
               driver.switchTo().frame(idFrame);
    }
   
    public void switchToDefaultContent () {
               driver.switchTo().defaultContent();
    }
   
    public void onMouseOverElement(By selector) {
                               JavascriptExecutor js=(JavascriptExecutor) driver;
                               element = driver.findElement(selector);
                               js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    public void hoverElement(By locator) {
    Actions hover = new Actions(driver);
    element = driver.findElement(locator);
    hover.moveToElement(element).perform();
    }
 
    public void clickConJavascript(By locator) {
               WebElement element = driver.findElement(locator);
               JavascriptExecutor executor = (JavascriptExecutor)driver;
               executor.executeScript("arguments[0].click();", element);
     }
    
    public void scrollToElement(By locator) {
    	//Scroll to Element
    	WebElement element = driver.findElement(locator);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }
   
    public void pressTabKeyOverLocator (By locator) {
               driver.findElement(locator).sendKeys(Keys.TAB);
    }
}