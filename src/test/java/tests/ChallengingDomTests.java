package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.WebDriver;

import config.DriverSetup;
import pages.HomePage;

//CLASSE QUE CONTÉM OS TESTES DO CHALLENGING DOM.
public class ChallengingDomTests
{
	private static WebDriver navegador;
	private HomePage pagina;
	
	@BeforeSuite
	public static void setUpSuite()
	{
		navegador = DriverSetup.getDriver();
	}
	
	@BeforeTest
	public void setUpTeste()
	{
		pagina = new HomePage(navegador);
	}
	
	@AfterClass
	public static void tearDownTeste()
	{
		DriverSetup.quitDriver();
	}
	
	@Test
	public void testClicarNoBotaoAzulDeveAlterarAnswer()
	{	
		String answerInicial = pagina.recuperarAnswer();
		String answerBtnAzul = pagina.clicarBotaoAzul();
		assertNotEquals(answerInicial, answerBtnAzul, "Validar que o Answer exibido após clicar no botão azul não é o mesmo de antes");
	}
	
	@Test
	public void testClicarNoBotaoVermelhoDeveAlterarAnswer()
	{	
		String answerInicial = pagina.recuperarAnswer();	
		String answerBtnVermelho = pagina.clicarBotaoVermelho();
		assertNotEquals(answerInicial, answerBtnVermelho, "Validar que o Answer exibido após clicar no botão vermelho não é o mesmo de antes");
	}
	
	@Test
	public void testClicarNoBotaoVerdeDeveAlterarAnswer()
	{	
		String answerInicial = pagina.recuperarAnswer();
		String answerBtnVerde = pagina.clicarBotaoVerde();
		assertNotEquals(answerInicial, answerBtnVerde, "Validar que o Answer exibido após clicar no botão verde não é o mesmo de antes");
	}
	
	@Test
	public void testClicarNoPrimeiroBotaoEditarDaTabela()
	{	
		String urlEsperada = "https://the-internet.herokuapp.com/challenging_dom#edit";
		String urlAtual = pagina.clicarOpcaoEdit();
		assertEquals(urlAtual, urlEsperada, "Validar acesso ao link de edição após clicar no botão Edit");
	}

	@Test
	public void testClicarNoPrimeiroBotaoDeletarDaTabela()
	{	
		String urlEsperada = "https://the-internet.herokuapp.com/challenging_dom#delete";
		String urlAtual = pagina.clicarOpcaoDelete();
		assertEquals(urlAtual, urlEsperada, "Validar acesso ao link de exclusão após clicar no botão Delete");
	}
	
	@Test
	public void testClicarEmTodasAsOpcoesEditarDaTabela()
	{	
		int numCliques = pagina.clicarEmTodasAsOpcoesEdit();
		assertEquals(numCliques, 10, "Validar que os 10 botões Edit da tabela foram clicados");
	}
	
	@Test
	public void testClicarEmTodasAsOpcoesDeletarDaTabela()
	{	
		int numCliques = pagina.clicarEmTodasAsOpcoesDelete();
		assertEquals(numCliques, 10, "Validar que os 10 botões Delete da tabela foram clicados");
	}
}