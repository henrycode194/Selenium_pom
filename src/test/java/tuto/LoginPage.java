package tuto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
	
	By userNameBox = By.cssSelector("input[name='userName']");
	By passBox = By.cssSelector("input[type='password']");
	By sigInBtn = By.cssSelector("input[value='Login']");
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void writeLogin() {
		writeText(userNameBox, "qualityadmin");
		writeText(passBox,"pass1");
		click(sigInBtn);
	}

}