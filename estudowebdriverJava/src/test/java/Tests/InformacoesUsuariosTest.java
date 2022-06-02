package Tests;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

@SuppressWarnings("unused")
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuariosTest.csv")
public class InformacoesUsuariosTest {
	private  WebDriver navegador;
	
	@Rule
	public TestName test = new TestName();
	
	
	@Before
	public void setup() {
		navegador = Web.createChrome();
	
		//Clicar em "Sign in"				
		//navegador.findElement(By.linkText("Sign in")).click();	
		
		//identificando o formulário de Login
		WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));
		
		navegador.manage().window().maximize();
				
		//Digitar no campo name "login" que está dentro do formulario do id "signinbox" o texto "viersberg0001"
		formularioSignInBox.findElement(By.name("login")).sendKeys("viersberg0001");
			
		//Digitar no campo name "Password" que está dentro do formulario do id "signinbox" o texto "123456"
		formularioSignInBox.findElement(By.name("password")).sendKeys("123456");
		
		//Clicar no link com o texto "SIGN IN"
		navegador.findElement(By.linkText("SIGN IN")).click();
		
		
		//clicar no link que possui a class "me"
		navegador.findElement(By.className("me")).click();
		
		/*Clicar no link  que possui o texto "MORE DATA ABOUT YOU"
		para localizar no inspect do navegador CTRL F e digitar na procura (//button[@data-target ="addmoredata"])*/
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
		
		
	}
	
	
	@Test
	public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name="tipo")String tipo, @Param(name="contato")String contato, @Param(name="mensagem")String mensagemEsperada) {
		// Assert.assertEquals(1, 5);
		
		
		/*Clicar no link  que possui o texto "MORE DATA ABOUT YOU"
		para localizar no inspect do navegador CTRL F e digitar na procura (//button[@data-target ="addmoredata"])*/
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
		
		
		//clicar no botão através do seu xpath //button[@data-target="addmoredata"]
		navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
		
		
		//identificar a popup onde esta o formulario de id addmoredata(No Caso se trata de combo box )
		WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));
		
		//No combo de name 'TYPE'escolhe a opação "Phone" 
		WebElement campoType = popupAddMoreData.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText(tipo);
		
		//No combo name "Contact" digitar "+5511988776659"
		popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);
		
		//Clicar no link de text "SAVE"que esta na popup
		popupAddMoreData.findElement(By.linkText("SAVE")).click();
		
		//Na mensagem de id"toast-container" validar que o texto é "Your contact has been added!"
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		assertEquals(mensagemEsperada, mensagem);	
		

		
	}

	
	//@Test
	public void removerUmContatoDeUmUsuario() {
		
		
		//clicar no elemento de seu xpath //span[text()="+551122223333"]/following-sibling::a
		
		navegador.findElement(By.xpath("//span[text()=\"+5511987877871\"]/following-sibling::a")).click();
		
		//Confirmar a janela de exclusão JavaScript
		navegador.switchTo().alert().accept();
		
		//Validar que a  mensagem apresentada foi Rest in peace, dear phone!
		
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		assertEquals("Rest in peace, dear phone!", mensagem);	
		
		String screenshotArquivo = "C:\\Users\\Sempre IT\\Documents\\Reports\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
		Screenshot.tirar(navegador, screenshotArquivo);
		
		
		//Aguardar até 10 segundos até que a janela desapareça
		
		WebDriverWait aguardar = new WebDriverWait(navegador, Duration.ofSeconds(10));
		aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));
		
		//Clicar no Link com o texto "Logout"
		
		navegador.findElement(By.linkText("Logout")).click();
		
		
		
	}
	
	
	
	@After
	public void tearDown() {
		//fechar o navegador
		navegador.quit();

	
	}
	

}	

