package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage {
	
		
	public LoginFormPage(WebDriver navegador) {
		super(navegador);
		
	}

	
	
	public LoginFormPage typeLogin(String Login) {
		navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(Login);
		return this;
	}
	
	public LoginFormPage typePassword(String password) {
		navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
		return this;
	}
	
	public SecretaPage clicarSignIn() {
		navegador.findElement(By.linkText("SIGN IN")).click();
		return new SecretaPage(navegador);
		
	}
	
	public SecretaPage fazerLogin(String Login, String password) {
		navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(Login);
		navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
		navegador.findElement(By.linkText("SIGN IN")).click();
		
		return new SecretaPage(navegador);
				
	}

}

