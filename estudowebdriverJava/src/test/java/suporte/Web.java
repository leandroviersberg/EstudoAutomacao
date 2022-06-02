package suporte;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;

public class Web {
	  public static final String AUTOMATE_USERNAME = "leandroamorim_bNweJ0";
	  public static final String AUTOMATE_ACCESS_KEY = "zFJHJv53crvCipivdY8N";
	  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	@SuppressWarnings("deprecation")
	public static WebDriver createChrome() {
		// Abrindo Navegador
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sempre IT\\Documents\\Webdriver\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Navegando em Taskit
        navegador.manage().window().maximize();
		navegador.get("http://www.juliodelima.com.br/taskit");
		
		return navegador;
	}
	//Estes testes foram realizados no BrownserStack e o resultado foi positivo
	@SuppressWarnings("deprecation")
	public static WebDriver createBrownserStack() {
		DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "102");
	    caps.setCapability("os", "Windows");
	    caps.setCapability("os_version", "10");
	    caps.setCapability("resolution", "1280x800");
	    caps.setCapability("brownserstack.debug", "true");
	    
	    WebDriver navegador = null;
	    
	    try {
	    	navegador = new RemoteWebDriver(new URL(URL), caps);
	    	navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	
	    	//Navegando em Taskit
	        navegador.manage().window().maximize();
			navegador.get("http://www.juliodelima.com.br/taskit");
	    } catch (MalformedURLException e) {
	    	System.out.println("houveram problemas com a URL: " + e.getMessage());
	    	
	    }
	    	return navegador;
	   
	}
}
