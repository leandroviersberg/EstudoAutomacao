package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPages extends BasePage{
	

		
	public LoginPages(WebDriver navegador) {
		super(navegador);
		
	}

	
	
	public LoginFormPage clickSignIn() {
		navegador.findElement(By.linkText("Sign in")).click();	
		
		return new LoginFormPage(navegador);
		
		
	}

}
