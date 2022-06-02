package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import Pages.LoginPages;
import suporte.Web;
import static org.junit.Assert.assertEquals;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuariosPageObjectsTest.csv")
public class InformacoesUsuariosPageObjectsTest {

	private WebDriver navegador;
	
	@Before
	public void setup() {
		navegador = Web.createBrownserStack();
	}
	
	@Test
	public void testAdicionarUmaInformacaoAdicionalDoUsuario(
	@Param(name="Login")String Login,
	@Param(name="password")String password,
	@Param(name="tipo")String tipo,
	@Param(name="contato")String contato,
	@Param(name="mensagem")String mensagemEsperada
	
) {
	
		String textoToast = new LoginPages(navegador) 
					.clickSignIn()
					.fazerLogin(Login, password)
					.clicarMe()
					.clicarAbaMoreDataAboutYou()
					.clicarBotaoAddMoreDataAboutYou()
			        .adcionarContato(tipo, contato)
					.capiturarTextoToast();					
							
		assertEquals(mensagemEsperada, textoToast);			
					
					
					
	}
	
	@After
	public void tearDown() {
		navegador.quit();
		
	}
}
